package com.vivalux.sbt.item;

import com.vivalux.sbt.Subterrania_ModBase;
import com.vivalux.sbt.lib.SBT_Ref;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemBook;

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

}
