package com.vivalux.sbt.block;

import com.vivalux.sbt.Subterrania_ModBase;

import net.minecraft.block.Block;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SBT_Blocks {

    public static BlockGlowingMushroom mushroom;
    public static final String MUSHROOM_NAME = "Foxfire Fungus"; // I looked up
								 // "glowing mushroom"
								 // and found
								 // this name.
    public static final String MUSHROOM_NAME_LOWER = "glowingMushroom";

    public static BlockRune rune;
    public static final String RUNE_NAME = "Rune";
    public static final String RUNE_NAME_LOWER = RUNE_NAME.toLowerCase();

    public static BlockMoss moss;
    public static final String MOSS_NAME = "Lichen";
    public static final String MOSS_NAME_LOWER = "moss";

    public static int blockID = 1000;

    public static int getNewID() {

	return blockID++;

    }

    public static void registerBlocks(Configuration config) {

	config.load();

	mushroom = new BlockGlowingMushroom(config.get(
		Configuration.CATEGORY_BLOCK, MUSHROOM_NAME_LOWER, blockID)
		.getInt(), MUSHROOM_NAME_LOWER);
	addBlock(mushroom, MUSHROOM_NAME_LOWER, MUSHROOM_NAME);

	rune = new BlockRune(config.get(Configuration.CATEGORY_BLOCK,
		RUNE_NAME_LOWER, blockID + 1).getInt(), RUNE_NAME_LOWER);
	addBlock(rune, RUNE_NAME_LOWER, RUNE_NAME);

	moss = new BlockMoss(config.get(Configuration.CATEGORY_BLOCK,
		MOSS_NAME_LOWER, blockID + 2).getInt(), MOSS_NAME_LOWER);
	addBlock(moss, MOSS_NAME_LOWER, MOSS_NAME);

	config.save();

    }

    private static void addBlock(Block block, String subname, String name) {

	LanguageRegistry.addName(block, name);
	GameRegistry.registerBlock(block, subname);

    }

}
