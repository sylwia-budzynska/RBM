package eu.tmuniversal.rbm.data.client;

import eu.tmuniversal.rbm.common.block.ModBlocks;
import eu.tmuniversal.rbm.common.lib.Reference;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;

public class BlockStateProvider extends net.minecraftforge.client.model.generators.BlockStateProvider {
  private final ExistingFileHelper exFileHelper;

  public BlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
    super(gen, Reference.MOD_ID, exFileHelper);

    this.exFileHelper = exFileHelper;
  }

  @Override
  protected void registerStatesAndModels() {
    simpleBlock(ModBlocks.TRAMPOLINE.get(), new ModelFile.ExistingModelFile(modLoc("block/trampoline"), exFileHelper));
    simpleBlock(ModBlocks.SOLID_AIR.get());
    simpleBlock(ModBlocks.SEMI_SOLID_AIR.get());
    simpleBlock(ModBlocks.SLIPPERY_ICE.get());
  }

  @Nonnull
  @Override
  public String getName() {
    return "RBM Block States";
  }
}
