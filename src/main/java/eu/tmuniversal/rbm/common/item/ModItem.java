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

import eu.tmuniversal.rbm.common.core.RBMCreativeTab;
import net.minecraft.item.Item;

public abstract class ModItem extends Item {
  public ModItem() {
    super(defaultBuilder());
  }

  public ModItem(Properties properties) {
    super(properties);
  }

  public static Item.Properties defaultBuilder() {
    return new Item.Properties().group(RBMCreativeTab.INSTANCE);
  }

  public static Item.Properties nonStackable() {
    return ModItem.defaultBuilder().maxStackSize(1);
  }
}
