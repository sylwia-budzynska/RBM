/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.data.client;

import eu.tmuniversal.rbm.common.lib.LibBlockNames;
import eu.tmuniversal.rbm.common.lib.Reference;
import eu.tmuniversal.rbm.common.lib.ResourceLocationHelper;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {

  public ItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
    super(generator, Reference.MOD_ID, existingFileHelper);
  }

  protected static ResourceLocation prefixBlock(String name) {
    return ResourceLocationHelper.prefix("block/" + name);
  }

  @Override
  protected void registerModels() {
    register(LibBlockNames.TRAMPOLINE);
    register(LibBlockNames.SOLID_AIR);
    register(LibBlockNames.SEMI_SOLID_AIR);
    register(LibBlockNames.SLIPPERY_ICE);
    register(LibBlockNames.LAUNCHPAD);
    register(LibBlockNames.COMPRESSED_CARVED_PUMPKIN);

    ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

    builder(itemGenerated, "dummy_item");
  }

  protected ItemModelBuilder register(String name) {
    return withExistingParent(name, prefixBlock(name));
  }

  private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
    return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
  }

  @Nonnull
  @Override
  public String getName() {
    return "RBM Item Models";
  }
}
