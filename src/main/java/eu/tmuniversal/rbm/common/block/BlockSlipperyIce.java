package eu.tmuniversal.rbm.common.block;

import eu.tmuniversal.rbm.common.lib.LibBlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.List;

import static eu.tmuniversal.rbm.common.lib.TranslationKeyHelper.blockTooltip;

public class BlockSlipperyIce extends Block {

  public BlockSlipperyIce() {
    super(ModBlocks.makeBlockProperties(Material.PACKED_ICE)
    .slipperiness(1.0F) // TODO: find good number
    .hardnessAndResistance(0.5F)
    .sound(SoundType.GLASS));
  }

  public BlockSlipperyIce(Properties properties) {
    super(properties);
  }

  @Override
  public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
    super.addInformation(stack, worldIn, tooltip, flagIn);
    tooltip.add(blockTooltip(LibBlockNames.SLIPPERY_ICE));
  }
}
