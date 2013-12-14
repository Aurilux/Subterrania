package com.vivalux.sbt.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import com.vivalux.sbt.Subterrania_ModBase;
import com.vivalux.sbt.lib.SBT_Ref;

public class ItemCrystal extends Item {

    public ItemCrystal(int par1) {
	super(par1);
	setCreativeTab(Subterrania_ModBase.tab);
    }
    
    @Override
    public void registerIcons(IconRegister reg){
	
	this.itemIcon = reg.registerIcon(SBT_Ref.TEXTURE_PREFIX + SBT_Items.CRYSTAL_NAME_LOWER);
	
    }

}
