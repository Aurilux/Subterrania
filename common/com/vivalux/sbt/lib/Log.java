package com.vivalux.sbt.lib;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLLog;

public class Log {

    private static Logger logger;

    private static void init() {

	if (logger == null) {

	    logger = FMLLog.getLogger();
	    ;

	}

    }

    private static void log(Level level, String text) {

	init();
	logger.log(level, "{" + SBT_Ref.MOD_ID + "} " + text);

    }

    public static void info(String text) {

	log(Level.INFO, text);

    }

    public static void severe(String text) {

	log(Level.SEVERE, text);

    }

    public static void debug(String text) {

	log(Level.INFO, "DEBUG: " + text);

    }

}
