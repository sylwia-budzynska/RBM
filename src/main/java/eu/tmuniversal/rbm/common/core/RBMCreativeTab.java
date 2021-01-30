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
    return new ItemStack(ModBlocks.TRAMPOLINE.get());
  }

  @Override
  public boolean hasSearchBar() {
    return true;
  }
}
