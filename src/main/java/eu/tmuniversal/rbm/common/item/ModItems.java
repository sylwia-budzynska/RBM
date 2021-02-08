/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.common.item;

import eu.tmuniversal.rbm.common.lib.LibItemNames;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

  public static final Item DUMMY_ITEM = new Item(ModItem.defaultBuilder());

  private static Item.Properties nonStackable() {
    return ModItem.defaultBuilder().maxStackSize(1);
  }

  public static void registerItems(RegistryEvent.Register<Item> event) {
    register(DUMMY_ITEM, LibItemNames.DUMMY_ITEM);
  }

  public static Item register(Item item, String name) {
    item.setRegistryName(name);
    ForgeRegistries.ITEMS.register(item);
    return item;
  }

}
