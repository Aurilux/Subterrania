package com.vivalux.sbt.lib;

import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingSpawnEvent.CheckSpawn;

public class SBT_EventHandler {
    
    @ForgeSubscribe
    public void onSpawn(CheckSpawn event){
		
	Coord coord = new Coord(event.world, (int)event.x,(int) event.y, (int)event.z);
		
	if(MushroomList.inRangeOfMushroom(coord, 10)){
	    	    		
	    event.setResult(Result.DENY);
			    
	}
		
    }

}
