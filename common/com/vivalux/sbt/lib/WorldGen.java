package com.vivalux.sbt.lib;

import com.vivalux.sbt.worldgen.FeatureGenerator;

import cpw.mods.fml.common.registry.GameRegistry;

public class WorldGen {
	
	public static void init() {
		GameRegistry.registerWorldGenerator(new FeatureGenerator());
	}
}