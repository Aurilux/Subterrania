package com.vivalux.sbt.gui.book;

import java.util.HashMap;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.vivalux.sbt.block.SBT_Blocks;
import com.vivalux.sbt.gui.book.page.Page;
import com.vivalux.sbt.item.SBT_Items;
import com.vivalux.sbt.lib.SBT_Ref;

public class Book {

    Page[] pages;
    Document doc;
    
    public static HashMap icons = new HashMap<String, ResourceLocation>();
    
    public Book(Document doc){
	
	this.doc = doc;
	this.init();
	
    }
    
    public static void initIcons(){
	
	icons.put("rune", new ResourceLocation(SBT_Ref.TEXTURE_PREFIX + "textures/items/"+SBT_Items.RUNE_NAME_LOWER+".png"));
	icons.put("chisel", new ResourceLocation(SBT_Ref.TEXTURE_PREFIX + "textures/items/"+SBT_Items.CHISEL_NAME_LOWER+".png"));
	icons.put("recipeChisel", new ResourceLocation(SBT_Ref.TEXTURE_PREFIX + "textures/recipes/"+"recipeChisel.png"));
	icons.put("recipeCookedMoss", new ResourceLocation(SBT_Ref.TEXTURE_PREFIX + "textures/recipse/"+"recipeCookedMoss.png"));
	icons.put("recipeRuneBook", new ResourceLocation(SBT_Ref.TEXTURE_PREFIX + "textures/recipes/"+"recipeRuneBook.png"));
	icons.put("runeBlock", new ResourceLocation(SBT_Ref.TEXTURE_PREFIX + "textures/blocks/" + SBT_Blocks.RUNE_NAME_LOWER+".png"));
	icons.put("moss", new ResourceLocation(SBT_Ref.TEXTURE_PREFIX + "textures/blocks/" + SBT_Blocks.MOSS_NAME_LOWER+".png"));
	icons.put("fungus", new ResourceLocation(SBT_Ref.TEXTURE_PREFIX + "textures/blocks/" + SBT_Blocks.MUSHROOM_NAME_LOWER+".png"));

    }
    
    private void init(){
	
	pages = new Page[doc.getElementsByTagName("page").getLength()];
	
	for(int k = 0; k < pages.length; k++){
	    
	    pages[k] = new Page((Element) doc.getElementsByTagName("page").item(k));
	    
	}
	
    }

}
