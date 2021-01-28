package eu.tmuniversal.rbm.data.client;

import eu.tmuniversal.rbm.Reference;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class RBMItemModelProvider extends ItemModelProvider {

  public RBMItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
    super(generator, Reference.MOD_ID, existingFileHelper);
  }

  @Override
  protected void registerModels() {
    withExistingParent("dummy_block", modLoc("block/dummy_block"));


    ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

    builder(itemGenerated, "dummy_item");
  }

  private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
    return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
  }
}
