package com.vivalux.sbt.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

import com.vivalux.sbt.Subterrania_ModBase;
import com.vivalux.sbt.lib.SBT_Ref;

public class ItemCookedMoss extends ItemFood {

    String name;

    public ItemCookedMoss(int par1, String name) {
	super(par1, 4, false); // ID, heal amount, wolves like the food
	this.setCreativeTab(Subterrania_ModBase.tab);
	setUnlocalizedName(name);
	this.name = name;
    }

    @Override
    public void registerIcons(IconRegister reg) {

	this.itemIcon = reg.registerIcon(SBT_Ref.TEXTURE_PREFIX + name);

    }

}
