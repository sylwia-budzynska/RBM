package eu.tmuniversal.rbm.data.client;

import eu.tmuniversal.rbm.Reference;
import eu.tmuniversal.rbm.setup.RBMBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class RBMBlockStateProvider extends BlockStateProvider {
  public RBMBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
    super(gen, Reference.MOD_ID, exFileHelper);
  }

  @Override
  protected void registerStatesAndModels() {
    simpleBlock(RBMBlocks.DUMMY_BLOCK.get());
  }
}
