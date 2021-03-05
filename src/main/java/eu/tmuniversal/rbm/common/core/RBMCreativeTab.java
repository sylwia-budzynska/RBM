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
package eu.tmuniversal.rbm.common.core;

import eu.tmuniversal.rbm.common.block.ModBlocks;
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
    return new ItemStack(ModBlocks.TRAMPOLINE);
  }
}
