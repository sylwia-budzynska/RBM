package eu.tmuniversal.rbm.common.data;

import eu.tmuniversal.rbm.common.Reference;
import eu.tmuniversal.rbm.common.item.ModItems;
import eu.tmuniversal.rbm.common.tags.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemTagsProvider extends net.minecraft.data.ItemTagsProvider {
  public ItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
    super(dataGenerator, blockTagProvider, Reference.MOD_ID, existingFileHelper);
  }

  @Override
  protected void registerTags() {
//    for BlockItems
//    copy(ModTags.Blocks.ORES_DUMMY_BLOCK, ModTags.Items.ORES_DUMMY_BLOCK);
    copy(Tags.Blocks.ORES, Tags.Items.ORES);

//    items
    getOrCreateBuilder(ModTags.Items.INGOTS_DUMMY).add(ModItems.DUMMY_ITEM.get());
    getOrCreateBuilder(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_DUMMY);
  }
}
