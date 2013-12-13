package com.vivalux.sbt.block;

import com.vivalux.sbt.Subterrania_ModBase;
import com.vivalux.sbt.lib.SBT_Ref;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockRune extends Block {

    public BlockRune(int par1) {
	super(par1, Material.rock);
	setCreativeTab(Subterrania_ModBase.tab);
    }

    public void registerIcons(IconRegister reg) {

	this.blockIcon = reg.registerIcon(SBT_Ref.TEXTURE_PREFIX
		+ SBTBlocks.RUNE_NAME_LOWER);

    }

}
