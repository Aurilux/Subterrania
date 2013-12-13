package com.vivalux.sbt.common.block;

import com.vivalux.sbt.SBTBlocks;
import com.vivalux.sbt.Subterrania_ModBase;
import com.vivalux.sbt.lib.SBT_Ref;

import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockMoss extends BlockVine {

    public BlockMoss(int par1) {
	super(par1);
	setCreativeTab(Subterrania_ModBase.tab);
    }
    
    @Override 
    public void registerIcons(IconRegister reg){
	
	this.blockIcon = reg.registerIcon(SBT_Ref.TEXTURE_PREFIX + SBTBlocks.MOSS_NAME_LOWER);
	
    }

}
