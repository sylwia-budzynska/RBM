package eu.tmuniversal.rbm.common.block;

import eu.tmuniversal.rbm.common.entity.EntitySnowGiant;
import eu.tmuniversal.rbm.common.entity.ModEntities;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.pattern.BlockMaterialMatcher;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCompressedCarvedPumpkin extends HorizontalBlock {
  public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

  private BlockPattern snowGiantBasePattern;
  private BlockPattern snowGiantPattern;

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
    BlockPattern.PatternHelper patternHelper = this.getSnowGiantPattern().match(world, pos);
    if (patternHelper != null) {

      for (int j = 0; j < this.getSnowGiantPattern().getPalmLength(); ++j) {
        for (int k = 0; k < this.getSnowGiantPattern().getThumbLength(); ++k) {
          CachedBlockInfo cachedblockinfo2 = patternHelper.translateOffset(j, k, 0);
          world.setBlockState(cachedblockinfo2.getPos(), Blocks.AIR.getDefaultState(), 2);
          world.playEvent(2001, cachedblockinfo2.getPos(), Block.getStateId(cachedblockinfo2.getBlockState()));
        }
      }


      BlockPos blockPos = patternHelper.translateOffset(5, 12, 0).getPos();
      EntitySnowGiant snowGiant = ModEntities.SNOW_GIANT.create(world);
      assert snowGiant != null;
      snowGiant.setLocationAndAngles(blockPos.getX() + 0.5D, blockPos.getY() + 0.05D, blockPos.getZ() + 0.5D, 0.0F, 0.0F);
      world.addEntity(snowGiant);

      for (int i1 = 0; i1 < this.getSnowGiantPattern().getPalmLength(); ++i1) {
        for (int j1 = 0; j1 < this.getSnowGiantPattern().getThumbLength(); ++j1) {
          CachedBlockInfo cachedblockinfo1 = patternHelper.translateOffset(i1, j1, 0);
          world.func_230547_a_(cachedblockinfo1.getPos(), Blocks.AIR);
        }
      }
    }
  }

  private BlockPattern getSnowGiantBasePattern() {
    if (this.snowGiantBasePattern == null) {
      this.snowGiantBasePattern = BlockPatternBuilder.start()
              .aisle("~~~PPP~~~", "~~~P~P~~~", "~~~PPP~~~", "~~#####~~", "~~##S##~~", "WW#####WW", "~~##S##~~", "~~#####~~", "~#######~", "~###S###~", "~#######~", "~###S###~", "~#######~", "~#######~")
              .where('P', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.PUMPKIN)))
              .where('#', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.SNOW_BLOCK)))
              .where('S', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.SMOOTH_STONE)))
              .where('W', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.OAK_LOG)))
              .where('~', CachedBlockInfo.hasState(BlockMaterialMatcher.forMaterial(Material.AIR)))
              .build();
    }

    return this.snowGiantBasePattern;
  }

  private BlockPattern getSnowGiantPattern() {
    if (this.snowGiantPattern == null) {
      this.snowGiantPattern = BlockPatternBuilder.start()
              .aisle("~~~PPP~~~", "~~~PCP~~~", "~~~PPP~~~", "~~#####~~", "~~##S##~~", "WW#####WW", "~~##S##~~", "~~#####~~", "~#######~", "~###S###~", "~#######~", "~###S###~", "~#######~", "~#######~")
              .where('P', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.PUMPKIN)))
              .where('#', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.SNOW_BLOCK)))
              .where('S', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.SMOOTH_STONE)))
              .where('W', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.OAK_LOG)))
              .where('C', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(ModBlocks.COMPRESSED_CARVED_PUMPKIN.get())))
              .where('~', CachedBlockInfo.hasState(BlockMaterialMatcher.forMaterial(Material.AIR)))
              .build();
    }

    return this.snowGiantPattern;
  }

  public BlockState getStateForPlacement(BlockItemUseContext context) {
    return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
  }

  protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
    builder.add(FACING);
  }

}
