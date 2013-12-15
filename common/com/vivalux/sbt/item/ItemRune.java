package com.vivalux.sbt.item;

import com.vivalux.sbt.Subterrania_ModBase;
import com.vivalux.sbt.lib.Log;
import com.vivalux.sbt.lib.SBT_Ref;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemRune extends Item {

    String name;

    public ItemRune(int par1, String name) {

	super(par1);
	setCreativeTab(Subterrania_ModBase.tab);
	setUnlocalizedName(name);
	this.name = name;

    }

    @Override
    public void registerIcons(IconRegister reg) {

	this.itemIcon = reg.registerIcon(SBT_Ref.TEXTURE_PREFIX + name);

    }

    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
	    EntityPlayer par3EntityPlayer) {

	if (!par3EntityPlayer.capabilities.isCreativeMode) {
	    --par1ItemStack.stackSize;
	}

	par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F,
		0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

	if (!par2World.isRemote) {
	    par2World.spawnEntityInWorld(new EntityExpBottle(par2World,
		    par3EntityPlayer));
	}

	return par1ItemStack;
    }

}
