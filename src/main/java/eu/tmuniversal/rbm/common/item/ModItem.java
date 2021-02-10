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
