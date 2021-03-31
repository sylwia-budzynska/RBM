/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code on github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * Creative Commons Attribution-NonCommercial-ShareAlike 4.0
 * International Public License (CC BY-NC-SA 4.0):
 * https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package eu.tmuniversal.rbm.common.item;

import eu.tmuniversal.rbm.common.lib.LibItemNames;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

  public static final Item CUP_OF_TEA = new ItemCupOfTea();
  public static final BlockNamedItem TEA_SEEDS = new ItemTeaSeeds();
  public static final Item TEA_LEAF = new ItemTeaLeaf();
  public static final Item BASEBALL_BAT = new ItemBaseballBat();

  public static void registerItems(RegistryEvent.Register<Item> event) {
    register(CUP_OF_TEA, LibItemNames.CUP_OF_TEA);
    register(TEA_SEEDS, LibItemNames.TEA_SEEDS);
    register(TEA_LEAF, LibItemNames.TEA_LEAF);
    register(BASEBALL_BAT, LibItemNames.BASEBALL_BAT);
  }

  public static Item register(Item item, String name) {
    item.setRegistryName(name);
    ForgeRegistries.ITEMS.register(item);
    return item;
  }
}
