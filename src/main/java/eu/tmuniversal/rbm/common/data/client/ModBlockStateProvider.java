package eu.tmuniversal.rbm.common.data.client;

import eu.tmuniversal.rbm.common.Reference;
import eu.tmuniversal.rbm.common.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
  private final ExistingFileHelper exFileHelper;

  public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
    super(gen, Reference.MOD_ID, exFileHelper);

    this.exFileHelper = exFileHelper;
  }

  @Override
  protected void registerStatesAndModels() {
    simpleBlock(ModBlocks.DUMMY_BLOCK.get());
    simpleBlock(ModBlocks.TRAMPOLINE_BLOCK.get(), new ModelFile.ExistingModelFile(modLoc("block/trampoline"), exFileHelper));
  }
}
