package com.vivalux.sbt.lib;

public class SBT_Ref {
    public static final String MOD_ID = "Subterrania";// "@MOD_ID@";
    public static final String MOD_NAME = "@MOD_NAME@";
    public static final String MOD_VERSION = "@MOD_VERSION@";

    public static final String TEXTURE_PREFIX = MOD_ID.toLowerCase() + ":";

    public static final String ASSETS_DIR = "/assets/" + MOD_ID + "/";
    public static final String TEXTURE_DIR = ASSETS_DIR + "textures/";
    public static final String BLOCKS_DIR = TEXTURE_DIR + "blocks/";

    public static final String VERSION_FILE = "";

    public static final String CLIENT_PROXY = "com.vivalux.sbt.proxy.ClientSBTProxy";
    public static final String SERVER_PROXY = "com.vivalux.sbt.proxy.CommonSBTProxy";
    
    public static final int GUI_RUNEBOOK_ID = 1;
}