package com.vivalux.sbt.lib;

import com.vivalux.sbt.block.SBT_Blocks;
import com.vivalux.sbt.item.SBT_Items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class SBT_Recipes {
    
    public static void registerRecipes(){
	
	GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestoneMossy), new ItemStack(Block.cobblestone), new ItemStack(SBT_Blocks.moss));
	GameRegistry.addSmelting(SBT_Blocks.moss.blockID, new ItemStack(SBT_Items.cookedMoss), 0.1f);
	
    }

}
