/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */

package eu.tmuniversal.rbm.common.block;

import eu.tmuniversal.rbm.common.lib.LibBlockNames;
import eu.tmuniversal.rbm.common.lib.TranslationKeyHelper;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BlockRealFakeDoor extends DoorBlock {
  public BlockRealFakeDoor() {
    super(ModBlock.getDefaultProperties(Material.WOOD, Blocks.OAK_DOOR.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid());
  }

  @Override
  public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
    super.addInformation(stack, worldIn, tooltip, flagIn);
    tooltip.add(TranslationKeyHelper.blockTooltip(LibBlockNames.REAL_FAKE_DOOR));
  }

  @Override
  public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
    if (this.material == Material.IRON) {
      return ActionResultType.PASS;
    } else {
      worldIn.playEvent(player, this.getOpenSound(), pos, 0);
      return ActionResultType.func_233537_a_(worldIn.isRemote);
    }
  }

  @Override
  public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
    boolean flag = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(pos.offset(state.get(HALF) == DoubleBlockHalf.LOWER ? Direction.UP : Direction.DOWN));
    if (blockIn != this && flag != state.get(POWERED)) {
      worldIn.playEvent(null, this.getOpenSound(), pos, 0);
    }
  }


  private int getOpenSound() {
    return this.material == Material.IRON ? 1005 : 1006;
  }
}
