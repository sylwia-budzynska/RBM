package eu.tmuniversal.rbm.common.data.common;

import eu.tmuniversal.rbm.common.Reference;
import eu.tmuniversal.rbm.common.block.ModBlocks;
import eu.tmuniversal.rbm.common.tags.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {

  public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
    super(generatorIn, Reference.MOD_ID, existingFileHelper);
  }

  @Override
  protected void registerTags() {
    getOrCreateBuilder(ModTags.Blocks.ORES_DUMMY_BLOCK).add(ModBlocks.DUMMY_BLOCK.get());
    getOrCreateBuilder(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_DUMMY_BLOCK);
  }
}
