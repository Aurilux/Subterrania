package com.vivalux.sbt.lib;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.client.FMLClientHandler;

public class Log {
    
    private Logger logger;
    
    private void init(){
	
	if(logger == null){
	
	    this.logger = FMLClientHandler.instance().getMinecraftLogger();
	    
	}
	
    }
    
    private void log(Level level, String text){
	
	this.init();
	this.logger.log(level, "{" + SBT_Ref.MOD_ID + "} " + text);
	
    }
    
    public void info(String text){
	
	this.log(Level.INFO, text);
	
    }
    
    public void severe(String text){
	
	this.log(Level.SEVERE, text);
	
    }
    
    public void debug(String text){
	
	this.log(Level.INFO, "DEBUG: " + text);
	
    }

}
