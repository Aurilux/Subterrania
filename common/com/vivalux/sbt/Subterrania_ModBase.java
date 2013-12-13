package com.vivalux.sbt;

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

@Mod(modid = SBT_Ref.MOD_ID, name = SBT_Ref.MOD_NAME, version = SBT_Ref.MOD_VERSION)
@NetworkMod(channels = {SBT_Ref.MOD_ID}, clientSideRequired = true, serverSideRequired = false)
public class Subterrania_ModBase {
		
	@Instance(SBT_Ref.MOD_ID)
    public static Subterrania_ModBase instance;

    @SidedProxy(clientSide = SBT_Ref.CLIENT_PROXY, serverSide = SBT_Ref.SERVER_PROXY)
    public static CommonSBTProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		//initialize enum additions, localization, and load configuration
		//register enums, blocks, items, and entities
		//register biomes, dimensions, and other world-gen
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		//register event handlers
		//register tile entities and other rendering
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		//used for working with other mods
	}
}