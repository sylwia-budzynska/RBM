package eu.tmuniversal.rbm.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlimeBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;

public class BlockTrampoline extends SlimeBlock {

  public static final double WALKING_MODIFIER = 0.85D;
  public static final SoundEvent SLIME_SOUND_EVENT = SoundEvents.BLOCK_SLIME_BLOCK_STEP;
  private static final VoxelShape SCAFFOLDING_SHAPE;

  public BlockTrampoline() {
    super(ModBlocks.makeBlockProperties(Material.CLAY, MaterialColor.GRASS)
            .slipperiness(0.8F)
            .sound(SoundType.SLIME)
            .jumpFactor(1.5F / 1.25F) // divide by default jump height of 1.25 blocks
            .notSolid()
    );
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
      }
      else {
//        hacky solution to prevent infinite bouncing on the spot
        entityIn.setMotion(entityIn.getMotion().mul(1.0, 0.0, 1.0));
      }
    }
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

  static {
    VoxelShape voxelshape = Block.makeCuboidShape(0.0D, 14.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    VoxelShape voxelshape1 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 2.0D, 16.0D, 2.0D);
    VoxelShape voxelshape2 = Block.makeCuboidShape(14.0D, 0.0D, 0.0D, 16.0D, 16.0D, 2.0D);
    VoxelShape voxelshape3 = Block.makeCuboidShape(0.0D, 0.0D, 14.0D, 2.0D, 16.0D, 16.0D);
    VoxelShape voxelshape4 = Block.makeCuboidShape(14.0D, 0.0D, 14.0D, 16.0D, 16.0D, 16.0D);
    SCAFFOLDING_SHAPE = VoxelShapes.or(voxelshape, voxelshape1, voxelshape2, voxelshape3, voxelshape4);
  }
}
