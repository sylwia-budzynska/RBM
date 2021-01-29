package eu.tmuniversal.rbm.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.List;

public class BlockVerySlipperyIce extends Block {
  public static final String NAME = "very_slippery_ice_block";

  public BlockVerySlipperyIce() {
    super(ModBlocks.makeBlockProperties(Material.PACKED_ICE)
    .slipperiness(1.0F) // TODO: find good number
    .hardnessAndResistance(0.5F)
    .sound(SoundType.GLASS));
  }

  public BlockVerySlipperyIce(Properties properties) {
    super(properties);
  }

  @Override
  public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
    super.addInformation(stack, worldIn, tooltip, flagIn);
    tooltip.add(new TranslationTextComponent("block.rbm.very_slippery_ice_block.tooltip"));
  }
}
