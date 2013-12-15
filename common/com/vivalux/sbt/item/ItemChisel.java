package com.vivalux.sbt.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemTool;

import com.vivalux.sbt.Subterrania_ModBase;
import com.vivalux.sbt.block.SBT_Blocks;
import com.vivalux.sbt.lib.SBT_Ref;

public class ItemChisel extends ItemTool {

    String name;

    public ItemChisel(int par1, String name) {
	super(par1, 1f, EnumToolMaterial.WOOD, new Block[] { SBT_Blocks.rune });
	setCreativeTab(Subterrania_ModBase.tab);
	this.name = name;
    }

    @Override
    public void registerIcons(IconRegister reg) {

	this.itemIcon = reg.registerIcon(SBT_Ref.TEXTURE_PREFIX + name);

    }

}
