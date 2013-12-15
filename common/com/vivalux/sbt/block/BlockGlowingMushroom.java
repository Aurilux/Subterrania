package com.vivalux.sbt.block;

import com.vivalux.sbt.Subterrania_ModBase;
import com.vivalux.sbt.lib.SBT_Ref;

import net.minecraft.block.BlockMushroom;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockGlowingMushroom extends BlockMushroom {

    String name;

    public BlockGlowingMushroom(int ID, String name) {

	super(ID);
	setCreativeTab(Subterrania_ModBase.tab);
	setUnlocalizedName(name);
	setLightValue(0.7f);
	this.name = name;
    }

    @Override
    public void registerIcons(IconRegister reg) {

	this.blockIcon = reg.registerIcon(SBT_Ref.TEXTURE_PREFIX + name);

    }

}
