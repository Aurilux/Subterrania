package com.vivalux.sbt.item;

import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;

import com.vivalux.sbt.block.SBT_Blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class SBT_Items {

    public static ItemCookedMoss cookedMoss;
    public static final String MOSS_NAME = "Cooked " + SBT_Blocks.MOSS_NAME;
    public static final String MOSS_NAME_LOWER = "cookedMoss";

    public static ItemRune rune;
    public static final String RUNE_NAME = "Rune Stone";
    public static final String RUNE_NAME_LOWER = "runeStone";

    public static ItemChisel chisel;
    public static final String CHISEL_NAME = "Rune Chisel";
    public static final String CHISEL_NAME_LOWER = "runeChisel";

    public static ItemRuneBook book;
    public static final String BOOK_NAME = "Book of Trogian Runes";
    public static final String BOOK_NAME_LOWER = "runeBook";

    public static int itemID = 700;

    private static int getNewID() {

	return itemID++;

    }

    public static void registerItems(Configuration config) {

	config.load();

	cookedMoss = new ItemCookedMoss(config.get(Configuration.CATEGORY_ITEM,
		MOSS_NAME_LOWER, getNewID()).getInt(), MOSS_NAME_LOWER);
	addItem(cookedMoss, MOSS_NAME_LOWER, MOSS_NAME);

	rune = new ItemRune(config.get(Configuration.CATEGORY_ITEM,
		RUNE_NAME_LOWER, getNewID()).getInt(), RUNE_NAME_LOWER);
	addItem(rune, RUNE_NAME_LOWER, RUNE_NAME);

	chisel = new ItemChisel(config.get(Configuration.CATEGORY_ITEM,
		CHISEL_NAME_LOWER, getNewID()).getInt(), CHISEL_NAME_LOWER);
	addItem(chisel, CHISEL_NAME_LOWER, CHISEL_NAME);

	book = new ItemRuneBook(config.get(Configuration.CATEGORY_ITEM,
		BOOK_NAME_LOWER, getNewID()).getInt(), BOOK_NAME_LOWER);
	addItem(book, BOOK_NAME_LOWER, BOOK_NAME);

	config.save();

    }

    private static void addItem(Item item, String subname, String name) {

	GameRegistry.registerItem(item, subname);
	LanguageRegistry.addName(item, name);

    }

}
