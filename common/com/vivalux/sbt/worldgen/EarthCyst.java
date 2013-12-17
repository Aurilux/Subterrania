package com.vivalux.sbt.worldgen;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class EarthCyst extends WorldGenerator {
	
	//minimum size for each axis
	private final int minX = 2;
	private final int minY = 2;
	private final int minZ = 2;
	
	//maximum size for each axis
	private final int maxX = 5;
	private final int maxY = 5;
	private final int maxZ = 5;

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		
		//determine the dimensions of the cave
		int dimX = Math.min(minX + random.nextInt(maxX), maxX);
		int dimY = Math.min(minY + random.nextInt(maxY), maxY);
		int dimZ = Math.min(minZ + random.nextInt(maxZ), maxZ);
		
		//then determine if the location is applicable
		int caveTop = y + dimY/2;
		//make sure we are a few blocks below sea level (64), but not too far below ground
		if (caveTop <= 59 && caveTop >= 11) {
			//choose the ore the earth cyst will be comprised of
			ArrayList<Integer> options = new ArrayList<Integer>();
			options.add(Block.oreCoal.blockID);
			options.add(Block.oreIron.blockID);
			if (y <= 34) {
				options.add(Block.oreGold.blockID);
			}
			if (y <= 18) {
				options.add(Block.oreRedstone.blockID);
				options.add(Block.oreDiamond.blockID);
			}
			int ore = options.get(random.nextInt(options.size()));
			//generate the overall shape of the cave, calculating from the center
			for (int length = x + dimX/2; length > x - dimX/2; length--) {
				for (int width = z + dimZ/2; width > z - dimZ/2; width--) {
					//move from top to bottom on the y-axis
					for (int height = caveTop; height > y - dimY/2; height--) {
						world.setBlock(length, height, width, ore);
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