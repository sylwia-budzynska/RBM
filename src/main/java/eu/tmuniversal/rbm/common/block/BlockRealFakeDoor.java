/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */

package eu.tmuniversal.rbm.common.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class BlockRealFakeDoor extends DoorBlock {
  public BlockRealFakeDoor() {
    super(ModBlock.getDefaultProperties(Material.WOOD, Blocks.OAK_DOOR.getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid());
  }

  private int getOpenSound() {
    return this.material == Material.IRON ? 1005 : 1006;
  }

  @Override
  public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
    worldIn.playEvent(player, this.getOpenSound(), pos, 0);
    return ActionResultType.func_233537_a_(worldIn.isRemote);
  }
}
