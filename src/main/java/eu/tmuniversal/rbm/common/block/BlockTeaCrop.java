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

import eu.tmuniversal.rbm.common.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class BlockTeaCrop extends CropsBlock {
  private static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D);

  public BlockTeaCrop(Properties builder) {
    super(builder);
  }

  public BlockTeaCrop() {
    super(ModBlock.getDefaultProperties(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP));
  }

  @Override
  public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
    return SHAPE;
  }

  @Override
  protected boolean isValidGround(BlockState state, IBlockReader world, BlockPos pos) {
    return state.getBlock() instanceof FarmlandBlock;
  }

  @Override
  protected IItemProvider getSeedsItem() {
    return ModItems.TEA_SEEDS;
  }

  @Override
  public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
    return new ItemStack(this.getSeedsItem());
  }
}
