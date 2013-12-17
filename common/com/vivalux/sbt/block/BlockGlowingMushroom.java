package com.vivalux.sbt.block;

import java.util.Random;

import net.minecraft.block.BlockMushroom;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

import com.vivalux.sbt.Subterrania_ModBase;
import com.vivalux.sbt.lib.Log;
import com.vivalux.sbt.lib.MushroomList;
import com.vivalux.sbt.lib.SBT_Ref;

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
    public boolean canBlockStay(World par1World, int par2, int par3, int par4) {
        return true;
    }
    
    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
    	if (random.nextInt(3) == 0)
        {
    		for (int i = 0; i < 360; i+=30) {
	            world.spawnParticle("townaura", 
	            		(double)((float)x + .6f + (Math.cos(i) * .3f)), 
	            		(double)((float)y + .2f), 
	            		(double)((float)z + .6f + (Math.sin(i) * .3f)), 
	            		Math.cos(i), 0.0D, Math.sin(i));
    		}
        }
    }
    
    @Override
    public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		MushroomList.addMushroomAt(par2, par3, par4);
		//Log.debug("added mush");
    }
    
    @Override
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6) {
        super.breakBlock(par1World, par2, par3, par4, par5, par6);
        MushroomList.removeMushroomAt(par2, par3, par4);
        //Log.debug("removed mush");
    }
}