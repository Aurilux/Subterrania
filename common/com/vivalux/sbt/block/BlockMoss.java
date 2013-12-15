package com.vivalux.sbt.block;

import com.vivalux.sbt.Subterrania_ModBase;
import com.vivalux.sbt.lib.SBT_Ref;

import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockMoss extends BlockVine {

    String name;

    public BlockMoss(int par1, String name) {
	super(par1);
	setCreativeTab(Subterrania_ModBase.tab);
	setUnlocalizedName(name);
	this.name = name;
    }

    @Override
    public void registerIcons(IconRegister reg) {

	this.blockIcon = reg.registerIcon(SBT_Ref.TEXTURE_PREFIX + name);

    }

}
