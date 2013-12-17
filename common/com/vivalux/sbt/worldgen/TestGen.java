package com.vivalux.sbt.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TestGen extends WorldGenerator {
		
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
		//XXX This works! adapt it to the other feature gens
		//for testing purposes
		x = 0;
		y = 70;
		z = 0;
		
		//determine the dimensions of the cave
		int dimX = 12;
		int dimY = 6;
		int dimZ = 18;
		
		//then determine if the location is applicable
		int caveTop = y + dimY/2;
		//make sure we are in a cold biome, a few blocks below sea level (64), but not too far below ground
		if (doOnce) {
			doOnce = false; //when I remove this also be sure to change the temperature back
			//generate the overall shape of the cave, calculating from the center, adding dirt to the bottom 2-3 layers
			for (int length = x - dimX/2; length <= x + dimX/2; length++) {
				for (int width = z - dimZ/2; width <= z + dimZ/2; width++) {
					//move from top to bottom on the y-axis
					for (int height = y - dimY/2; height <= y + dimY/2; height++) {
						int dx = length - x;
						int dy = height - y;
						int dz = width - z;
						double point = (dx*dx) / (dimX/2) + (dy*dy) / (dimY/2) + (dz*dz) / (dimZ/2);
						System.out.println(point);
						if (point <= 1.0D) {
							world.setBlock(length, height, width, Block.stoneBrick.blockID);
						}

					}
				}
			}
		}
		return true;
	}
}
