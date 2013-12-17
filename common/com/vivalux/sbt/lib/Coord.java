package com.vivalux.sbt.lib;

public class Coord {

    private int x;
    private int y;
    private int z;
    
    /**
     * @param x
     * @param y
     * @param z
     */
    public Coord(int x, int y, int z) {
	super();
	this.x = x;
	this.y = y;
	this.z = z;
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
    
    @Override
    public boolean equals(Object obj){
	
	if(obj instanceof Coord){
	    
	    return (((Coord) obj).getX() ==  this.getX() && ((Coord) obj).getY() == this.getY() && ((Coord) obj).getZ() == this.getZ());
					    
	}
	
	return false;
	
    }
    
    @Override
    public String toString(){
	
	return this.getX() + ", " + this.getY() + ", " + this.getZ();
	
    }

}
