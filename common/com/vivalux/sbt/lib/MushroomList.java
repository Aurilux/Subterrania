package com.vivalux.sbt.lib;

import java.util.ArrayList;

public class MushroomList {
    
    private static ArrayList<Coord> mushrooms = new ArrayList<Coord>();
    
    public static void addMushroomAt(int x, int y, int z){
    	mushrooms.add(new Coord(x, y, z));
    }
    
    public static void addMushroomAt(Coord coord){
    	mushrooms.add(coord);
    }
    
    public static void removeMushroomAt(Coord coord){
		if (mushrooms.contains(coord)) {
			mushrooms.remove(coord);
		}
    }
    
    public static void removeMushroomAt(int x, int y, int z){
		Coord coord = new Coord(x, y, z);
		removeMushroomAt(coord);
    }
    
    public static boolean inRangeOfMushroom(Coord coord, int distance){
    	return inRangeOfMushroom(coord.getX(), coord.getY(), coord.getZ(), distance);
    }
    
    public static boolean inRangeOfMushroom(int x, int y, int z, int distance){
		for(Coord coord : mushrooms){
		    //Log.debug("Checking mush at " + coord.toString());
		    
		    int diffX = Math.max(x, coord.getX()) - Math.min(x, coord.getX());
		    int diffY = Math.max(y, coord.getY()) - Math.min(y, coord.getY());
		    int diffZ = Math.max(z, coord.getZ()) - Math.min(z, coord.getZ());
		    int total = diffX + diffY + diffZ;
		    
		    if(total < distance){
			
			return true;
			
		    }
		}
		return false;
    }

}
