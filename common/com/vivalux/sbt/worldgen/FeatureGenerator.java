package com.vivalux.sbt.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;

public class FeatureGenerator implements IWorldGenerator {

    private WorldGenerator grotto       = new Grotto();
    private WorldGenerator secretGarden = new SecretGarden();
    private WorldGenerator mushroomCave = new MushroomCave();
    private WorldGenerator magmaChamber = new MagmaChamber();
    private WorldGenerator earthCyst    = new EarthCyst();
    private WorldGenerator testGen      = new TestGen();

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
		    generateNether(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 0:
		    generateOverworld(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 1:
		    generateEnd(world, random, chunkX * 16, chunkZ * 16);
		    break;
		}
    }

    private void generateOverworld(World world, Random random, int x, int z) {
		int randX = 0;
		int randY = 0;
		int randZ = 0;
	
		// Grotto generation
		randX = x + random.nextInt(8);
		randY = random.nextInt(128);
		randZ = z + random.nextInt(8);
		//grotto.generate(world, random, randX, randY, randZ);
	
		// Secret Garden generation
		randX = x + random.nextInt(8);
		randY = random.nextInt(128);
		randZ = z + random.nextInt(8);
		secretGarden.generate(world, random, randX, randY, randZ);
	
		// Mushroom Cave generation
		randX = x + random.nextInt(8);
		randY = random.nextInt(128);
		randZ = z + random.nextInt(8);
		mushroomCave.generate(world, random, randX, randY, randZ);
	
		// Magma Chamber generation
		randX = x + random.nextInt(8);
		randY = random.nextInt(128);
		randZ = z + random.nextInt(8);
		magmaChamber.generate(world, random, randX, randY, randZ);
		
		// Earth Cyst generation
		randX = x + random.nextInt(8);
		randY = random.nextInt(256);
		randZ = z + random.nextInt(8);
		earthCyst.generate(world, random, randX, randY, randZ);
		
		/*
		randX = x + random.nextInt(8);
		randY = random.nextInt(128);
		randZ = z + random.nextInt(8);
		testGen.generate(world, random, randX, randY, randZ);
		*/
    }

    private void generateEnd(World world, Random random, int x, int z) {
    }

    private void generateNether(World world, Random random, int x, int z) {
    }
}
