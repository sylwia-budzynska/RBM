package eu.tmuniversal.rbm.data;

import eu.tmuniversal.rbm.Reference;
import eu.tmuniversal.rbm.setup.RBMBlocks;
import eu.tmuniversal.rbm.setup.RBMTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class RBMBlockTagsProvider extends BlockTagsProvider {

  public RBMBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
    super(generatorIn, Reference.MOD_ID, existingFileHelper);
  }

  @Override
  protected void registerTags() {
    getOrCreateBuilder(RBMTags.Blocks.ORES_DUMMY_BLOCK).add(RBMBlocks.DUMMY_BLOCK.get());
    getOrCreateBuilder(Tags.Blocks.ORES).addTag(RBMTags.Blocks.ORES_DUMMY_BLOCK);
  }
}
