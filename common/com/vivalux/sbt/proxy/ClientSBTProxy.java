package com.vivalux.sbt.proxy;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.client.FMLClientHandler;

public class ClientSBTProxy extends CommonSBTProxy {
    @Override
    public void initRenderers() {
    }

    @Override
    public Minecraft getMCInstance() {

	return FMLClientHandler.instance().getClient();

    }

}