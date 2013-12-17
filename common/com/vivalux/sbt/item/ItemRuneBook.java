package com.vivalux.sbt.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.vivalux.sbt.Subterrania_ModBase;
import com.vivalux.sbt.lib.SBT_Ref;

public class ItemRuneBook extends ItemBook {

    String name;

    public ItemRuneBook(int par1, String name) {
	super(par1);
	setUnlocalizedName(name);
	setCreativeTab(Subterrania_ModBase.tab);
	this.name = name;
    }

    @Override
    public void registerIcons(IconRegister reg) {

	this.itemIcon = reg.registerIcon(SBT_Ref.TEXTURE_PREFIX + name);

    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
	par3EntityPlayer.openGui(Subterrania_ModBase.instance, SBT_Ref.GUI_RUNEBOOK_ID,
		par2World, par3EntityPlayer.serverPosX, par3EntityPlayer.serverPosY, par3EntityPlayer.serverPosZ);
	
        return par1ItemStack;
    }

}
