package eu.tmuniversal.rbm.data.client;

import eu.tmuniversal.rbm.common.block.BlockSemiSolidAir;
import eu.tmuniversal.rbm.common.block.BlockSolidAir;
import eu.tmuniversal.rbm.common.block.BlockTrampoline;
import eu.tmuniversal.rbm.common.lib.Reference;
import net.minecraft.data.DataGenerator;
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
    withExistingParent("dummy_block", modLoc("block/dummy_block"));
    withExistingParent(BlockTrampoline.NAME, modLoc("block/" + BlockTrampoline.NAME));
    withExistingParent(BlockSolidAir.NAME, modLoc("block/" + BlockSolidAir.NAME));
    withExistingParent(BlockSemiSolidAir.NAME, modLoc("block/" + BlockSemiSolidAir.NAME));

    ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

    builder(itemGenerated, "dummy_item");
  }

  private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
    return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
  }

  @Nonnull
  @Override
  public String getName() {
    return "RBM item models";
  }
}
