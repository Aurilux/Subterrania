package com.vivalux.sbt.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class MagmaChamber extends WorldGenerator {
	
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
		//make sure we are in a hot biome, a few blocks below sea level (64), but not too far below ground
		if (world.getBiomeGenForCoords(x, z).temperature > .6f && (caveTop <= 30 && caveTop >= 15)) {
			//generate the overall shape of the cave, calculating from the center, adding dirt to the bottom 2-3 layers
			for (int length = x + dimX/2; length > x - dimX/2; length--) {
				for (int width = z + dimZ/2; width > z - dimZ/2; width--) {
					//move from top to bottom on the y-axis
					for (int height = caveTop; height > y - dimY/2; height--) {
						//if we are below the half of the depth, start adding lava and obsidian
						if (height <= y) {
							//if we are at the edges, make obsidian, otherwise add lava
							if ((length == x + dimX/2 || length == x - dimX/2 + 1)
									|| (width == z + dimZ/2 || width == z - dimZ/2 + 1)
									|| height == y - dimY/2 + 1) {
								world.setBlock(length, height, width, Block.obsidian.blockID);
							}
							else {
								world.setBlock(length, height, width, Block.lavaStill.blockID);
							}
							
						}
						else {
							world.setBlockToAir(length, height, width);
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