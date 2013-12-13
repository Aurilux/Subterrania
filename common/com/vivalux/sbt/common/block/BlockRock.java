package com.vivalux.sbt.common.block;

import com.vivalux.sbt.Subterrania_ModBase;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockRock extends Block {

    public BlockRock(int ID) {
	super(ID, Material.rock);
	setCreativeTab(Subterrania_ModBase.tab);
    }
    
    @Override
    public void registerIcons(IconRegister reg){
	
	this.blockIcon = reg.registerIcon("minecraft:stone");
	
    }

}
