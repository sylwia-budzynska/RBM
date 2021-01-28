package eu.tmuniversal.rbm.data;

import eu.tmuniversal.rbm.Reference;
import eu.tmuniversal.rbm.setup.RBMItems;
import eu.tmuniversal.rbm.setup.RBMTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class RBMItemTagsProvider extends ItemTagsProvider {
  public RBMItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
    super(dataGenerator, blockTagProvider, Reference.MOD_ID, existingFileHelper);
  }

  @Override
  protected void registerTags() {
//    for BlockItems
    copy(RBMTags.Blocks.ORES_DUMMY_BLOCK, RBMTags.Items.ORES_DUMMY_BLOCK);
    copy(Tags.Blocks.ORES, Tags.Items.ORES);

//    items
    getOrCreateBuilder(RBMTags.Items.INGOTS_DUMMY).add(RBMItems.DUMMY_ITEM.get());
    getOrCreateBuilder(Tags.Items.INGOTS).addTag(RBMTags.Items.INGOTS_DUMMY);
  }
}
