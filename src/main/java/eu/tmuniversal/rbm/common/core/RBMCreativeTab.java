/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.common.core;

import eu.tmuniversal.rbm.common.block.ModBlocks;
import eu.tmuniversal.rbm.common.block.RBMBlocks;
import eu.tmuniversal.rbm.common.lib.Reference;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class RBMCreativeTab extends ItemGroup {

  public static final RBMCreativeTab INSTANCE = new RBMCreativeTab();

  public RBMCreativeTab() {
    super(Reference.MOD_ID);
  }

  @Nonnull
  @Override
  public ItemStack createIcon() {
    return new ItemStack(RBMBlocks.trampoline.get());
  }
}
