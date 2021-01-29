package eu.tmuniversal.rbm.common.data;

import eu.tmuniversal.rbm.common.Reference;
import eu.tmuniversal.rbm.common.block.ModBlocks;
import eu.tmuniversal.rbm.common.tags.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockTagsProvider extends net.minecraft.data.BlockTagsProvider {

  public BlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
    super(generatorIn, Reference.MOD_ID, existingFileHelper);
  }

  @Override
  protected void registerTags() {
    getOrCreateBuilder(ModTags.Blocks.TRAMPOLINE_BLOCK).add(ModBlocks.TRAMPOLINE_BLOCK.get());
    getOrCreateBuilder(ModTags.Blocks.SOLID_AIR_BLOCK).add(ModBlocks.SOLID_AIR_BLOCK.get());
    getOrCreateBuilder(Tags.Blocks.GLASS).add(ModBlocks.SOLID_AIR_BLOCK.get());
  }
}
