package com.vivalux.sbt.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;

public class SecretGarden extends WorldGenerator {

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
        byte b0 = 3;
        int l = random.nextInt(2) + 2;
        int i1 = random.nextInt(2) + 2;
        int j1 = 0;
        int k1;
        int l1;
        int i2;

        for (k1 = x - l - 1; k1 <= x + l + 1; ++k1)
        {
            for (l1 = y - 1; l1 <= y + b0 + 1; ++l1)
            {
                for (i2 = z - i1 - 1; i2 <= z + i1 + 1; ++i2)
                {
                    Material material = world.getBlockMaterial(k1, l1, i2);

                    if (l1 == y - 1 && !material.isSolid())
                    {
                        return false;
                    }

                    if (l1 == y + b0 + 1 && !material.isSolid())
                    {
                        return false;
                    }

                    if ((k1 == x - l - 1 || k1 == x + l + 1 || i2 == z - i1 - 1 || i2 == z + i1 + 1) && l1 == y && world.isAirBlock(k1, l1, i2) && world.isAirBlock(k1, l1 + 1, i2))
                    {
                        ++j1;
                    }
                }
            }
        }

        if (j1 >= 1 && j1 <= 5)
        {
            for (k1 = x - l - 1; k1 <= x + l + 1; ++k1)
            {
                for (l1 = y + b0; l1 >= y - 1; --l1)
                {
                    for (i2 = z - i1 - 1; i2 <= z + i1 + 1; ++i2)
                    {
                        if (k1 != x - l - 1 && l1 != y - 1 && i2 != z - i1 - 1 && k1 != x + l + 1 && l1 != y + b0 + 1 && i2 != z + i1 + 1)
                        {
                            world.setBlockToAir(k1, l1, i2);
                        }
                        else if (l1 >= 0 && !world.getBlockMaterial(k1, l1 - 1, i2).isSolid())
                        {
                            world.setBlockToAir(k1, l1, i2);
                        }
                        else if (world.getBlockMaterial(k1, l1, i2).isSolid())
                        {
                            if (l1 == y - 1 && random.nextInt(4) != 0)
                            {
                                world.setBlock(k1, l1, i2, Block.cobblestoneMossy.blockID, 0, 2);
                            }
                            else
                            {
                                world.setBlock(k1, l1, i2, Block.cobblestone.blockID, 0, 2);
                            }
                        }
                    }
                }
            }

            k1 = 0;

            while (k1 < 2)
            {
                l1 = 0;

                while (true)
                {
                    if (l1 < 3)
                    {
                        label101:
                        {
                            i2 = x + random.nextInt(l * 2 + 1) - l;
                            int j2 = z + random.nextInt(i1 * 2 + 1) - i1;

                            if (world.isAirBlock(i2, y, j2))
                            {
                                int k2 = 0;

                                if (world.getBlockMaterial(i2 - 1, y, j2).isSolid())
                                {
                                    ++k2;
                                }

                                if (world.getBlockMaterial(i2 + 1, y, j2).isSolid())
                                {
                                    ++k2;
                                }

                                if (world.getBlockMaterial(i2, y, j2 - 1).isSolid())
                                {
                                    ++k2;
                                }

                                if (world.getBlockMaterial(i2, y, j2 + 1).isSolid())
                                {
                                    ++k2;
                                }

                                if (k2 == 1)
                                {
                                    world.setBlock(i2, y, j2, Block.chest.blockID, 0, 2);
                                    TileEntityChest tileentitychest = (TileEntityChest)world.getBlockTileEntity(i2, y, j2);

                                    if (tileentitychest != null)
                                    {
                                        ChestGenHooks info = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);
                                        WeightedRandomChestContent.generateChestContents(random, info.getItems(random), tileentitychest, info.getCount(random));
                                    }

                                    break label101;
                                }
                            }

                            ++l1;
                            continue;
                        }
                    }

                    ++k1;
                    break;
                }
            }

            return true;
        }
        else
        {
            return false;
        }
	}
}