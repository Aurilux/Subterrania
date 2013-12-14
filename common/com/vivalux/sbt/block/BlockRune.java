package com.vivalux.sbt.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;

import com.vivalux.sbt.Subterrania_ModBase;
import com.vivalux.sbt.item.SBT_Items;
import com.vivalux.sbt.lib.SBT_Ref;

public class BlockRune extends Block {

    private Icon[] icons = new Icon[3];
    String name;

    public BlockRune(int par1, String name) {
	super(par1, Material.rock);
	setCreativeTab(Subterrania_ModBase.tab);
	setUnlocalizedName(name);
	setHardness(0.5f);
	this.name = name;
    }

    @Override
    public void registerIcons(IconRegister reg) {

	for (int k = 0; k < icons.length; k++) {

	    icons[k] = reg
		    .registerIcon(SBT_Ref.TEXTURE_PREFIX + name + (k + 1));

	}

    }

    @Override
    public Icon getIcon(int par1, int par2) {
	return icons[(int) Math.ceil(par1 / 2)];
    }

    @Override
    public boolean canHarvestBlock(EntityPlayer player, int meta) {
	return player.getCurrentEquippedItem() != null
		&& player.getCurrentEquippedItem().getItem() == SBT_Items.chisel;
    }

    @Override
    public int idDropped(int par1, Random par2Random, int par3) {
	return SBT_Items.rune.itemID;
    }

}
