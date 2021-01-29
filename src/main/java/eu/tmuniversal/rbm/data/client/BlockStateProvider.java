package eu.tmuniversal.rbm.data.client;

import eu.tmuniversal.rbm.common.lib.Reference;
import eu.tmuniversal.rbm.common.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStateProvider extends net.minecraftforge.client.model.generators.BlockStateProvider {
  private final ExistingFileHelper exFileHelper;

  public BlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
    super(gen, Reference.MOD_ID, exFileHelper);

    this.exFileHelper = exFileHelper;
  }

  @Override
  protected void registerStatesAndModels() {
    simpleBlock(ModBlocks.DUMMY_BLOCK.get());
    simpleBlock(ModBlocks.TRAMPOLINE_BLOCK.get(), new ModelFile.ExistingModelFile(modLoc("block/trampoline"), exFileHelper));
    simpleBlock(ModBlocks.SOLID_AIR_BLOCK.get());
    simpleBlock(ModBlocks.SEMI_SOLID_AIR_BLOCK.get());
  }
}
