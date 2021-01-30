package eu.tmuniversal.rbm.data;

import eu.tmuniversal.rbm.common.block.ModBlocks;
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
    getOrCreateBuilder(ModTags.Blocks.TRAMPOLINE).add(ModBlocks.TRAMPOLINE.get());
    getOrCreateBuilder(ModTags.Blocks.BLOCKS_SOLID_AIR).add(ModBlocks.SOLID_AIR.get());
    getOrCreateBuilder(ModTags.Blocks.BLOCKS_SOLID_AIR).add(ModBlocks.SEMI_SOLID_AIR.get());
    getOrCreateBuilder(Tags.Blocks.GLASS).add(ModBlocks.SOLID_AIR.get());
    getOrCreateBuilder(Tags.Blocks.GLASS).add(ModBlocks.SEMI_SOLID_AIR.get());
  }

  @Override
  public String getName() {
    return "RBM Block Tags";
  }
}
