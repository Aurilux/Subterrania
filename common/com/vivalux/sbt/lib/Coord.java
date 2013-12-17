package com.vivalux.sbt.lib;

import net.minecraft.world.World;

public class Coord {

    private int x;
    private int y;
    private int z;
    private World world;
    
    /**
     * @param x
     * @param y
     * @param z
     */
    public Coord(World world, int x, int y, int z) {

	this.x = x;
	this.y = y;
	this.z = z;
	this.world = world;
    }
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }
    /**
     * @return the y
     */
    public int getY() {
        return y;
    }
    /**
     * @return the z
     */
    public int getZ() {
        return z;
    }
    
    public World getWorld(){
	
	return this.world;
	
    }

    @Override
    public boolean equals(Object obj){
	
	if(obj instanceof Coord){
	    
	    return (((Coord) obj).getX() ==  this.getX() && ((Coord) obj).getY() == this.getY() && ((Coord) obj).getZ() == this.getZ() && ((Coord) obj).getWorld() == this.getWorld());

					    
	}
	
	return false;
	
    }
    
    @Override
    public String toString(){
	
	return this.getX() + ", " + this.getY() + ", " + this.getZ();
	
    }

}
