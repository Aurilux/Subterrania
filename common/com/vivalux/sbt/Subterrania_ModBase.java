package com.vivalux.sbt;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;

import com.vivalux.sbt.block.SBT_Blocks;
import com.vivalux.sbt.item.SBT_Items;
import com.vivalux.sbt.lib.Log;
import com.vivalux.sbt.lib.SBT_EventHandler;
import com.vivalux.sbt.lib.SBT_OreDictionary;
import com.vivalux.sbt.lib.SBT_Recipes;
import com.vivalux.sbt.lib.SBT_Ref;
import com.vivalux.sbt.proxy.CommonSBTProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = SBT_Ref.MOD_ID, name = SBT_Ref.MOD_NAME, version = SBT_Ref.MOD_VERSION)
@NetworkMod(channels = { SBT_Ref.MOD_ID }, clientSideRequired = true, serverSideRequired = false)
public class Subterrania_ModBase {

    @Instance(SBT_Ref.MOD_ID)
    public static Subterrania_ModBase instance;

    @SidedProxy(clientSide = SBT_Ref.CLIENT_PROXY, serverSide = SBT_Ref.SERVER_PROXY)
    public static CommonSBTProxy proxy;

    public static CreativeTabs tab;
    public static Configuration config;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
	// initialize enum additions, localization, and load configuration
	// register enums, blocks, items, and entities
	// register biomes, dimensions, and other world-gen
	config = new Configuration(e.getSuggestedConfigurationFile());
	setCreativeTab();
	SBT_Blocks.registerBlocks(config);
	SBT_Items.registerItems(config);
	SBT_Recipes.registerRecipes();

	// I KEEP RUNNING THE WRONG MOD GRRRRRRRRR!!!!!!!!
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
	// register event handlers
	// register tile entities and other rendering
	MinecraftForge.EVENT_BUS.register(new SBT_EventHandler());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
	SBT_OreDictionary.setOres();
	for (ItemStack stack : SBT_OreDictionary.ores) {

	    System.out.println(stack.toString());

	}
    }

    private static void setCreativeTab() {

	tab = new CreativeTabs(SBT_Ref.MOD_ID) {

	    @Override
	    public ItemStack getIconItemStack() {
		return new ItemStack(SBT_Blocks.mushroom);
	    }

	};
	LanguageRegistry.instance().addStringLocalization(
		"itemGroup." + SBT_Ref.MOD_ID, SBT_Ref.MOD_NAME);

    }

}