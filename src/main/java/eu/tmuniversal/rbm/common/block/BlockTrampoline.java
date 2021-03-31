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
package eu.tmuniversal.rbm.common.block;

import eu.tmuniversal.rbm.common.lib.LibBlockNames;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

import static eu.tmuniversal.rbm.common.lib.TooltipHelper.blockTooltip;

public class BlockTrampoline extends SlimeBlock implements IWaterLoggable {

  public static final double WALKING_MODIFIER = 0.85D;
  public static final SoundEvent SLIME_SOUND_EVENT = SoundEvents.BLOCK_SLIME_BLOCK_STEP;
  public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
  private static final VoxelShape SCAFFOLDING_SHAPE;

  static {
    VoxelShape voxelshape = Block.makeCuboidShape(0.0D, 14.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    VoxelShape voxelshape1 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 2.0D, 16.0D, 2.0D);
    VoxelShape voxelshape2 = Block.makeCuboidShape(14.0D, 0.0D, 0.0D, 16.0D, 16.0D, 2.0D);
    VoxelShape voxelshape3 = Block.makeCuboidShape(0.0D, 0.0D, 14.0D, 2.0D, 16.0D, 16.0D);
    VoxelShape voxelshape4 = Block.makeCuboidShape(14.0D, 0.0D, 14.0D, 16.0D, 16.0D, 16.0D);
    SCAFFOLDING_SHAPE = VoxelShapes.or(voxelshape, voxelshape1, voxelshape2, voxelshape3, voxelshape4);
  }

  public BlockTrampoline() {
    super(ModBlock.getDefaultProperties(Material.CLAY, MaterialColor.GRASS)
      .slipperiness(0.8F)
      .sound(SoundType.SLIME)
      .jumpFactor(1.5F / 1.25F) // divide by default jump height of 1.25 blocks
      .notSolid()
      .variableOpacity()
    );
    this.setDefaultState(this.getDefaultState().with(WATERLOGGED, Boolean.FALSE));
  }

  @Override
  public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
    super.addInformation(stack, worldIn, tooltip, flagIn);
    tooltip.add(blockTooltip(LibBlockNames.TRAMPOLINE));
  }

  @Override
  public void onLanded(IBlockReader worldIn, Entity entityIn) {
    if (entityIn.isSuppressingBounce()) {
      super.onLanded(worldIn, entityIn);
    } else {
      Vector3d motion = entityIn.getMotion();
      if (motion.y < -0.1D) {
        double modifier = entityIn instanceof LivingEntity ? 1.35D : 0.8D;
        entityIn.playSound(SLIME_SOUND_EVENT, ((float) Math.abs(motion.y) / 6), 1.0F);
        entityIn.setMotion(motion.x, -motion.y * modifier, motion.z);
      } else {
//        hacky solution to prevent infinite bouncing on the spot
        entityIn.setMotion(entityIn.getMotion().mul(1.0, 0.0, 1.0));
      }
    }
  }

  @Override
  public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
    double v0 = Math.abs(entityIn.getMotion().y);
    if (v0 < 0.1D && !entityIn.isSteppingCarefully()) {
      double v1 = 0.65D + v0 * 0.2D;
      entityIn.setMotion(entityIn.getMotion().mul(v1, 1.0D, v1));
    }

    super.onEntityWalk(worldIn, pos, entityIn);
  }

  @Override
  protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
    builder.add(WATERLOGGED);
  }

  @Override
  public FluidState getFluidState(BlockState state) {
    return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
  }

  @Override
  public BlockState getStateForPlacement(BlockItemUseContext context) {
    BlockPos blockpos = context.getPos();
    World world = context.getWorld();
    return this.getDefaultState().with(WATERLOGGED, world.getFluidState(blockpos).getFluid() == Fluids.WATER);
  }

  @Override
  public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
    if (!worldIn.isRemote) {
      worldIn.getPendingBlockTicks().scheduleTick(pos, this, 1);
    }

  }

  @Override
  public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
    if (stateIn.get(WATERLOGGED)) {
      worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
    }

    if (!worldIn.isRemote()) {
      worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 1);
    }

    return stateIn;
  }


  @Override
  public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
    if (!context.hasItem(state.getBlock().asItem())) {
      return SCAFFOLDING_SHAPE;
    } else {
      return VoxelShapes.fullCube();
    }
  }

  @Override
  public VoxelShape getRaytraceShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
    return VoxelShapes.fullCube();
  }
}
