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
package eu.tmuniversal.rbm.data.client;

import eu.tmuniversal.rbm.common.block.ModBlocks;
import eu.tmuniversal.rbm.common.lib.LibBlockNames;
import eu.tmuniversal.rbm.common.lib.Reference;
import net.minecraft.block.CropsBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ConfiguredModel;
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
    simpleBlock(ModBlocks.TRAMPOLINE, model(LibBlockNames.TRAMPOLINE));
    simpleBlock(ModBlocks.SOLID_AIR);
    simpleBlock(ModBlocks.SEMI_SOLID_AIR);
    simpleBlock(ModBlocks.SLIPPERY_ICE);
    simpleBlock(ModBlocks.LAUNCHPAD);
    doorBlock(ModBlocks.REAL_FAKE_DOOR, mcLoc("block/oak_door_bottom"), mcLoc("block/oak_door_top"));
    horizontalBlock(ModBlocks.COMPRESSED_CARVED_PUMPKIN, model(LibBlockNames.COMPRESSED_CARVED_PUMPKIN));
    registerCrop(ModBlocks.TEA_CROP, LibBlockNames.TEA_CROP);
  }

  private void registerCrop(CropsBlock block, String name) {
    getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder().modelFile(model(name + "_" + state.get(CropsBlock.AGE))).build());
  }

  private ModelFile model(String name) {
    return model(modLoc("block/" + name));
  }

  private ModelFile model(ResourceLocation location) {
    return new ModelFile.ExistingModelFile(location, this.exFileHelper);
  }

  @Nonnull
  @Override
  public String getName() {
    return Reference.MOD_NAME_SHORT + " Block States";
  }
}
