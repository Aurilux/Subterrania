package com.vivalux.sbt.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.vivalux.sbt.gui.book.Book;

import cpw.mods.fml.common.network.IGuiHandler;

public class CommonSBTProxy implements IGuiHandler {
    
    public static Book runebook;

    public void initRenderers() {
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,
	    int x, int y, int z) {
	return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
	    int x, int y, int z) {
	return null;
    }

    public Minecraft getMCInstance() {

	return null;

    }
    
    public void readBooks(){
	
	
	
    }
}