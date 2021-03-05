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
package eu.tmuniversal.rbm.data;

import eu.tmuniversal.rbm.common.item.ModItems;
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
//    BlockItems
//    copy(Tags.Blocks.ORES, Tags.Items.ORES);

//    items
    getOrCreateBuilder(Tags.Items.SEEDS).add(ModItems.TEA_SEEDS);
  }

  @Override
  public String getName() {
    return Reference.MOD_NAME_SHORT + " Item Tags";
  }
}
