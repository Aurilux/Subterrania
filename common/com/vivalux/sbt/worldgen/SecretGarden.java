package com.vivalux.sbt.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class SecretGarden extends WorldGenerator {
	
	//minimum size for each axis
	private final int minX = 20;
	private final int minY = 5;
	private final int minZ = 20;
	
	//maximum size for each axis
	private final int maxX = 40;
	private final int maxY = 10;
	private final int maxZ = 40;
	
	private boolean doOnce = true;

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		
		//determine the dimensions of the cave
		int dimX = Math.min(minX + random.nextInt(maxX), maxX);
		int dimY = Math.min(minY + random.nextInt(maxY), maxY);
		int dimZ = Math.min(minZ + random.nextInt(maxZ), maxZ);
		
		//then determine if the location is applicable
		int caveTop = y + dimY/2;
		//make sure we are in a cold biome, a few blocks below sea level (64), but not too far below ground
		if (world.getBiomeGenForCoords(x, z).temperature < .4f && (caveTop <= 59 && caveTop >= 44)) {
			//generate the overall shape of the cave, calculating from the center, adding dirt to the bottom 2-3 layers
			for (int length = x + dimX/2; length > x - dimX/2; length--) {
				for (int width = z + dimZ/2; width > z - dimZ/2; width--) {
					//move from top to bottom on the y-axis
					for (int height = caveTop; height > y - dimY/2; height--) {
						//if we are at the bottom, generate the dirt
						if (height <= (y - dimY/2) + 1) {
							//make the top layer grass.. 
							world.setBlock(length, height, width, Block.grass.blockID);
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
			
			//then generate the sub terrain features
			for (int length = x + dimX/2; length > x - dimX/2; length--) {
				for (int width = z + dimZ/2; width > z - dimZ/2; width--) {
					//move from top to bottom on the y-axis
					for (int height = caveTop; height > y - dimY/2; height--) {
						//add glowstone to the ceiling
						if (random.nextFloat() > .95f //random number to see if we spawn at all (put first to short-circuit)
								&& height > caveTop - 2
								&& world.isAirBlock(length, height, width) //is the current block air?
								&& world.getBlockMaterial(length, height + 1, width).isSolid()) { //is the block above solid?
							world.setBlock(length, height, width, Block.glowStone.blockID, 0, 2);
						}

						//generate pools of water
						if (random.nextFloat() > .99f //random number to see if we spawn at all (put first to short-circiut)
							&& world.isAirBlock(length, height, width) //is the current block air?
							&& world.getBlockMaterial(length, height - 1, width).isSolid()) { //is the block below solid?
							//make this carve semi-circle shaped pools later
							for (int i = -1; i < 2; i++) {
								for (int j = -1; j < 2; j++) {
									world.setBlock(length + i, height - 1, width + j, Block.waterStill.blockID);
								}
							}
						}
						
						//add glowstone to the floor
						if (random.nextFloat() > .9f //random number to see if we spawn at all (put first to short-circuit)
								&& world.isAirBlock(length, height, width) //is the current block air?
								&& world.getBlockMaterial(length, height - 1, width).isSolid() 
								&& world.getBlockId(length, height - 1, width) == Block.grass.blockID) { //is the block below solid?
							world.setBlock(length, height - 1, width, Block.glowStone.blockID, 0, 2);
						}
					}
				}
			}

			//then generate the all the other features
			for (int length = x + dimX/2; length > x - dimX/2; length--) {
				for (int width = z + dimZ/2; width > z - dimZ/2; width--) {
					//move from top to bottom on the y-axis
					for (int height = caveTop; height > y - dimY/2; height--) {
						//add plants (trees, vines, flowers, grass, bushes, reeds)
						if (random.nextFloat() > .9f //random number to see if we spawn at all (put first to short-circuit)
								&& world.isAirBlock(length, height, width) //is the current block air?
								&& world.getBlockMaterial(length, height - 1, width).isSolid()
								&& world.getBlockId(length, height - 1, width) == Block.grass.blockID) { //is the block below solid?
							int plantChance = random.nextInt(4);
							switch(plantChance) {
							case 0: //spawn trees and vines
								int maxTreeHeight = 2 + random.nextInt(3);
								for (int i = 0; i < maxTreeHeight; i++) {
									world.setBlock(length, height + i, width, Block.wood.blockID, 3, 2);
									//spawn leaves and vines
									if (i == maxTreeHeight - 1) {
										for (int j = 0; j < 2; j++) {
											for (int k = -1; k < 2; k++) {
												for (int l = -1; l < 2; l++) {
													if (!world.getBlockMaterial(length + k, height + j + i, width + l).isSolid()) {
														//this ensures the leaves on the top sides aren't placed
														if (!(j == 1 && Math.abs(k) != Math.abs(l))) {
															world.setBlock(length + k, height + j + i, width + l, Block.leaves.blockID, 3, 2);
														}
													}
												}
											}
										}
									}
								}
								break;
							case 1: //spawn flowers
								world.setBlock(length, height, width, random.nextInt(2) > 0 ? Block.plantRed.blockID : Block.plantYellow.blockID);
								break;
							case 2: //spawn grass
								world.setBlock(length, height, width, Block.tallGrass.blockID, 1, 2);
								break;
							case 3: //spawn reeds
								if (Block.reed.canBlockStay(world, length, height, width)) {
									for (int i = 0; i < random.nextInt(3); i++) {
										world.setBlock(length, height + i, width, Block.reed.blockID);
									}
								}
								break;
							}
						}
						
						//spawn passive mobs (cows, pigs, chicken, horses, sheep)
						if (random.nextFloat() > .97f //random number to see if we spawn at all (put first to short-circiut)
								&& world.isAirBlock(length, height, width) //is the current block air?
								&& world.getBlockMaterial(length, height - 1, width).isSolid()) { //is the block below solid?
							int mob = random.nextInt(5);
							Entity entity;
							switch (mob) {
								case 0: entity = new EntityCow(world);
									break;
								case 1: entity = new EntityPig(world);
									break;
								case 2: entity = new EntitySheep(world);
									break;
								case 3: entity = new EntityChicken(world);
									break;
								default: entity = new EntityHorse(world);
									break;
							}
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
