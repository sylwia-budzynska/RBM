/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.common.item;

import eu.tmuniversal.rbm.common.core.RBMCreativeTab;
import eu.tmuniversal.rbm.common.lib.LibItemNames;
import eu.tmuniversal.rbm.common.setup.Registration;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {

  public static final RegistryObject<Item> DUMMY_ITEM = Registration.ITEMS.register(LibItemNames.DUMMY_ITEM, () -> new Item(defaultBuilder()));

  public static Item.Properties defaultBuilder() {
    return new Item.Properties().group(RBMCreativeTab.INSTANCE);
  }

  private static Item.Properties nonStackable() {
    return defaultBuilder().maxStackSize(1);
  }

  public static void register() {}
}
