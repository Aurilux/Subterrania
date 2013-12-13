package com.vivalux.sbt;

import com.vivalux.sbt.common.block.BlockGlowingMushroom;
import com.vivalux.sbt.common.block.BlockMoss;
import com.vivalux.sbt.common.block.BlockRune;

import net.minecraft.block.Block;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SBTBlocks {
    
    public static BlockGlowingMushroom mushroom;
    public static final String MUSHROOM_NAME = "Foxfire Fungus"; // I looked up "glowing mushroom" and found this name.
    public static final String MUSHROOM_NAME_LOWER = "glowingMushroom";
    
    public static BlockRune rune;
    public static final String RUNE_NAME = "Rune";
    public static final String RUNE_NAME_LOWER = "rune";
    
    public static BlockMoss moss;
    public static final String MOSS_NAME = "Lichen";
    public static final String MOSS_NAME_LOWER = "moss";
    
    public static int blockID = 1000;
    
    public static int getNewID(){
	
	return blockID++;
	
    }
    
    public static void registerBlocks(){
	
	Subterrania_ModBase.config.load();
	
	mushroom = new BlockGlowingMushroom(Subterrania_ModBase.config.get(Configuration.CATEGORY_BLOCK, MUSHROOM_NAME_LOWER, getNewID()).getInt());
	addBlock(mushroom, MUSHROOM_NAME_LOWER, MUSHROOM_NAME);
	
	rune = new BlockRune(Subterrania_ModBase.config.get(Configuration.CATEGORY_BLOCK, RUNE_NAME_LOWER, getNewID()).getInt());
	addBlock(rune, RUNE_NAME_LOWER, RUNE_NAME);
	
	moss = new BlockMoss(Subterrania_ModBase.config.get(Configuration.CATEGORY_BLOCK, MOSS_NAME_LOWER, getNewID()).getInt());
	addBlock(moss, MOSS_NAME_LOWER, MOSS_NAME);
	
	Subterrania_ModBase.config.save();
	
    }
    
    private static void addBlock(Block block, String subname, String name){
	    
	LanguageRegistry.addName(block, name);
	GameRegistry.registerBlock(block, subname);
	    
    }
    

}
