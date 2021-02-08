/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.data;

import eu.tmuniversal.rbm.common.block.RBMBlocks;
import eu.tmuniversal.rbm.common.lib.ModTags;
import eu.tmuniversal.rbm.common.lib.Reference;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockTagsProvider extends net.minecraft.data.BlockTagsProvider {

  public BlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
    super(generatorIn, Reference.MOD_ID, existingFileHelper);
  }

  @Override
  protected void registerTags() {
    getOrCreateBuilder(ModTags.Blocks.TRAMPOLINE).add(RBMBlocks.trampoline.get());
    getOrCreateBuilder(ModTags.Blocks.BLOCKS_SOLID_AIR).add(RBMBlocks.solid_air.get());
    getOrCreateBuilder(ModTags.Blocks.BLOCKS_SOLID_AIR).add(RBMBlocks.semi_solid_air.get());
    getOrCreateBuilder(Tags.Blocks.GLASS).add(RBMBlocks.solid_air.get());
    getOrCreateBuilder(Tags.Blocks.GLASS).add(RBMBlocks.semi_solid_air.get());
  }

  @Override
  public String getName() {
    return "RBM Block Tags";
  }
}
