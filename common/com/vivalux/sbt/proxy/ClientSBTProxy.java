package com.vivalux.sbt.proxy;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import org.w3c.dom.Document;

import com.vivalux.sbt.Subterrania_ModBase;
import com.vivalux.sbt.gui.book.Book;
import com.vivalux.sbt.gui.book.GuiRuneBook;
import com.vivalux.sbt.lib.SBT_Ref;

import cpw.mods.fml.client.FMLClientHandler;

public class ClientSBTProxy extends CommonSBTProxy {
    
    
    
    @Override
    public void initRenderers() {
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
	    int x, int y, int z) {
	
	if(ID == SBT_Ref.GUI_RUNEBOOK_ID){
	    
	    return new GuiRuneBook();
	    
	}
	
	return null;
	
    }
    
    @Override
    public Minecraft getMCInstance() {

	return FMLClientHandler.instance().getClient();

    }
    
    @Override
    public void readBooks(){
	
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	Book.initIcons();
	this.runebook = new Book(readDocument(SBT_Ref.ASSETS_DIR+"books/"+"runebook.xml", dbf));
    }
    
    private Document readDocument(String path, DocumentBuilderFactory dbf){
	
	InputStream in = Subterrania_ModBase.class.getResourceAsStream(path);
	try {
	    DocumentBuilder db = dbf.newDocumentBuilder();
	    Document doc = db.parse(in);
	    doc.getDocumentElement().normalize();
	    return doc;
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	return null;
	
    }

}