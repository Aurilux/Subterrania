package com.vivalux.sbt.lib;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class SBT_OreDictionary {

    public static ArrayList<ItemStack> ores = new ArrayList<ItemStack>();

    public static void setOres() {

	for (int k = 0; k < OreDictionary.getOreNames().length; k++) {

	    if (OreDictionary.getOreNames()[k].contains("ore")) {

		for (ItemStack stack : OreDictionary.getOres(OreDictionary
			.getOreNames()[k])) {

		    ores.add(stack);

		}

	    }

	}

    }

}
