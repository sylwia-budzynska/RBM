/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.data;

import eu.tmuniversal.rbm.common.item.ModItems;
import eu.tmuniversal.rbm.common.lib.ModTags;
import eu.tmuniversal.rbm.common.lib.Reference;
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

  @Override
  public String getName() {
    return "RBM Item Tags";
  }
}
