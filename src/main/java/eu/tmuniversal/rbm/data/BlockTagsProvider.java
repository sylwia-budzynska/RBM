/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.data;

import eu.tmuniversal.rbm.common.block.ModBlocks;
import eu.tmuniversal.rbm.common.lib.ModTags;
import eu.tmuniversal.rbm.common.lib.Reference;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockTagsProvider extends net.minecraft.data.BlockTagsProvider {

  public BlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
    super(generatorIn, Reference.MOD_ID, existingFileHelper);
  }

  @Override
  protected void registerTags() {
    getOrCreateBuilder(ModTags.Blocks.TRAMPOLINE).add(ModBlocks.TRAMPOLINE);
    getOrCreateBuilder(ModTags.Blocks.BLOCKS_SOLID_AIR).add(ModBlocks.SOLID_AIR);
    getOrCreateBuilder(ModTags.Blocks.BLOCKS_SOLID_AIR).add(ModBlocks.SEMI_SOLID_AIR);
    getOrCreateBuilder(Tags.Blocks.GLASS).add(ModBlocks.SOLID_AIR);
    getOrCreateBuilder(Tags.Blocks.GLASS).add(ModBlocks.SEMI_SOLID_AIR);
    getOrCreateBuilder(BlockTags.CROPS).add(ModBlocks.TEA_CROP);
  }

  @Override
  public String getName() {
    return Reference.MOD_NAME_SHORT + " Block Tags";
  }
}
