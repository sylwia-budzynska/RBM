package eu.tmuniversal.rbm.common.block;

import net.minecraft.block.BarrierBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.List;

public class BlockSolidAir extends BarrierBlock {
  public static final String NAME = "solid_air_block";

  public BlockSolidAir() {
    super(ModBlocks.makeBlockProperties(Material.GLASS)
            .notSolid()
            .setAllowsSpawn((p1, p2, p3, p4) -> false)
            .hardnessAndResistance(0.3F)
            .setSuffocates((p1, p2, p3) -> false)
            .sound(SoundType.FUNGUS)
            .setBlocksVision((p1, p2, p3) -> false)
            .setOpaque((p1, p2, p3) -> false)
    );
  }

  @Override
  public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
    super.addInformation(stack, worldIn, tooltip, flagIn);
    tooltip.add(new TranslationTextComponent("block.rbm." + NAME + ".tooltip"));
  }
}
