package com.vivalux.sbt.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockMushroom;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.vivalux.sbt.block.SBT_Blocks;

public class MushroomCave extends WorldGenerator {
	
	//minimum size for each axis
	private final int minX = 20;
	private final int minY = 5;
	private final int minZ = 20;
	
	//maximum size for each axis
	private final int maxX = 40;
	private final int maxY = 10;
	private final int maxZ = 40;

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		//determine the dimensions of the cave
		int dimX = Math.min(minX + random.nextInt(maxX), maxX);
		int dimY = Math.min(minY + random.nextInt(maxY), maxY);
		int dimZ = Math.min(minZ + random.nextInt(maxZ), maxZ);
		
		//then determine if the location is applicable
		int caveTop = y + dimY/2;
		//make sure we are in a humid biome, a few blocks below sea level (64), but not too far below ground
		if (world.getBiomeGenForCoords(x, z).rainfall > .6f && (caveTop <= 59 && caveTop >= 44)) {
			//generate the overall shape of the cave, calculating from the center, adding dirt to the bottom 2-3 layers
			for (int length = x + dimX/2; length > x - dimX/2; length--) {
				for (int width = z + dimZ/2; width > z - dimZ/2; width--) {
					//move from top to bottom on the y-axis
					for (int height = caveTop; height > y - dimY/2; height--) {
						//if we are at the bottom, generate the mycelium and dirt
						if (height <= (y - dimY/2) + 1) {
							//make the top layer mycelium.. 
							world.setBlock(length, height, width, Block.mycelium.blockID);
							//...then make the one below that dirt...
							world.setBlock(length, height - 1, width, Block.dirt.blockID);
							//..and finally randomize the layer below that to dirt
							world.setBlock(length, height - 1 - random.nextInt(2), width, Block.dirt.blockID);
							
						}
						else {
							world.setBlockToAir(length, height, width);
						}
					}
				}
			}
			
			//then generate the all the other features
			for (int length = x + dimX/2; length > x - dimX/2; length--) {
				for (int width = z + dimZ/2; width > z - dimZ/2; width--) {
					//move from top to bottom on the y-axis
					for (int height = caveTop; height > y - dimY/2; height--) {
						//add mushrooms
						if (random.nextFloat() > .8f //random number to see if we spawn at all (put first to short-circuit)
								&& world.isAirBlock(length, height, width) //is the current block air?
								&& world.getBlockMaterial(length, height - 1, width).isSolid() //is the block below solid?
								&& world.getBlockId(length, height - 1, width) == Block.mycelium.blockID) { //is the block below mycelium?
							int mushroomChance = random.nextInt(3);
							int mushroomID;
							switch (mushroomChance) {
								case 1: mushroomID = Block.mushroomRed.blockID;
									break;
								case 2: mushroomID = Block.mushroomBrown.blockID;
									break;
								default: mushroomID = SBT_Blocks.mushroom.blockID;
									break;
							}
							world.setBlock(length, height, width, mushroomID, 0, 2);
							if (random.nextFloat() > .7f && mushroomChance > 0) {
								((BlockMushroom)Block.blocksList[mushroomID]).fertilizeMushroom(world, length, height, width, random);
							}
						}
						
						//spawn passive mobs (cows, pigs, chicken, horses, sheep)
						if (random.nextFloat() > .97f //random number to see if we spawn at all (put first to short-circiut)
								&& world.isAirBlock(length, height, width) //is the current block air?
								&& world.getBlockMaterial(length, height - 1, width).isSolid()) { //is the block below solid?
							Entity entity = new EntityMooshroom(world);
							entity.setPosition(length + .5f, height + .5f, width + .5f);
							world.spawnEntityInWorld(entity);
						}
					}
				}
			}
			
			return true;
		}
		else {
			return false;
		}
    }
}
