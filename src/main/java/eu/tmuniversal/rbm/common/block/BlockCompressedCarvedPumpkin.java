package eu.tmuniversal.rbm.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCompressedCarvedPumpkin extends HorizontalBlock {
  public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

  public BlockCompressedCarvedPumpkin() {
    super(ModBlocks.makeBlockProperties(Material.GOURD, MaterialColor.ADOBE)
            .sound(SoundType.WOOD)
            .hardnessAndResistance(3.0f)
    );
    this.setDefaultState(this.getStateContainer().getBaseState().with(FACING, Direction.NORTH));
  }

  public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean isMoving) {
    if (!oldState.isIn(state.getBlock())) {
      this.trySpawnGiant(world, pos);
    }
  }

  private void trySpawnGiant(World world, BlockPos pos) {

  }

  public BlockState getStateForPlacement(BlockItemUseContext context) {
    return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
  }

  protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
    builder.add(FACING);
  }

}
