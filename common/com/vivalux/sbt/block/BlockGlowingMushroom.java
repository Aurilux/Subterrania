package com.vivalux.sbt.block;

import com.vivalux.sbt.Subterrania_ModBase;
import com.vivalux.sbt.lib.Log;
import com.vivalux.sbt.lib.MushroomList;
import com.vivalux.sbt.lib.SBT_Ref;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

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
    
    @Override
    public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
        return true;
    }
    
    @Override
    public void onBlockAdded(World par1World, int par2, int par3, int par4) {
	
	MushroomList.addMushroomAt(par2, par3, par4);
	Log.debug("added mush");
	
    }
    
    @Override
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        super.breakBlock(par1World, par2, par3, par4, par5, par6);
        
        MushroomList.removeMushroomAt(par2, par3, par4);
        
        Log.debug("removed mush");
    }

}
