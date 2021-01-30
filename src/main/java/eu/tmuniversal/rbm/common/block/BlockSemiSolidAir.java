package eu.tmuniversal.rbm.common.block;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.List;

import static eu.tmuniversal.rbm.common.lib.TranslationKeyHelper.blockTooltip;

public class BlockSemiSolidAir extends BlockSolidAirBase {

  public static final String NAME = "semi_solid_air";

  public static final Properties PROPERTIES = BlockSolidAirBase.PROPERTIES.doesNotBlockMovement();

  public BlockSemiSolidAir() {
    super(PROPERTIES);
  }

  @Override
  public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
    super.addInformation(stack, worldIn, tooltip, flagIn);
    tooltip.add(blockTooltip(NAME));
  }
}
