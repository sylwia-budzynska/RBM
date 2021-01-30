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

  @Override
  protected void registerModels() {
    withExistingParent(LibBlockNames.TRAMPOLINE, prefixBlock(LibBlockNames.TRAMPOLINE));
    withExistingParent(LibBlockNames.SOLID_AIR, prefixBlock(LibBlockNames.SOLID_AIR));
    withExistingParent(LibBlockNames.SEMI_SOLID_AIR, prefixBlock(LibBlockNames.SEMI_SOLID_AIR));
    withExistingParent(LibBlockNames.SLIPPERY_ICE, prefixBlock(LibBlockNames.SLIPPERY_ICE));

    ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

    builder(itemGenerated, "dummy_item");
  }

  protected ResourceLocation prefixBlock(String name) {
    return ResourceLocationHelper.prefix("block/" + name);
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
