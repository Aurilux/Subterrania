package com.vivalux.sbt.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class SecretGarden extends WorldGenerator {
	
	//minimum size for each axis
	private final int minX = 20;
	private final int minY = 10;
	private final int minZ = 20;
	
	//maximum size for each axis
	private final int maxX = 40;
	private final int maxY = 20;
	private final int maxZ = 40;

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		//determine the dimensions of the cave
		int dimX = Math.min(minX + random.nextInt(maxX), maxX);
		int dimY = Math.min(minY + random.nextInt(maxY), maxY);
		int dimZ = Math.min(minZ + random.nextInt(maxZ), maxZ);
		
		//then determine if the location is applicable
		int caveTop = y + dimY;
		//make sure we are in a cold biome, a few blocks below sea level (64), but not too far below ground
		if (world.getBiomeGenForCoords(x, z).temperature < .3f && (caveTop < 54 && caveTop > 44)) {
			
			//generate the overall shape of the cave, adding dirt to the bottom 1-2 layers
			
			//then generate the sub features
			//add glowstone
			
			//add plants (trees, vines, flowers, grass, bushes)
			
			//spawn passive mobs (cows, pigs, chicken, horses)
			
			//generate pools of water

			return true;
		}
		else {
			return false;
		}
	}
}