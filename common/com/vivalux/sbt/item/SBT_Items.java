package com.vivalux.sbt.item;

import com.vivalux.sbt.Subterrania_ModBase;
import com.vivalux.sbt.block.SBT_Blocks;

import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SBT_Items {
    
    public static ItemCookedMoss cookedMoss;
    public static final String MOSS_NAME = "Cooked " + SBT_Blocks.MOSS_NAME;
    public static final String MOSS_NAME_LOWER = "cookedMoss";
    
    public static int itemID = 700;
    
    private static int getNewID(){
	
	return itemID++;
	
    }
    
    public static void registerItems(){
	
	Subterrania_ModBase.config.load();
	
	cookedMoss = new ItemCookedMoss(Subterrania_ModBase.config.get(Configuration.CATEGORY_ITEM, MOSS_NAME_LOWER, getNewID()).getInt());
	addItem(cookedMoss, MOSS_NAME_LOWER, MOSS_NAME);
	
	Subterrania_ModBase.config.save();
	
    }
    
    private static void addItem(Item item, String subname, String name){
	
	GameRegistry.registerItem(item, subname);
	LanguageRegistry.addName(item, name);
	
    }

}
