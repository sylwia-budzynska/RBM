/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.data.client;

import eu.tmuniversal.rbm.common.block.ModBlocks;
import eu.tmuniversal.rbm.common.lib.LibBlockNames;
import eu.tmuniversal.rbm.common.lib.Reference;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
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
  }

  private ModelFile model(String name) {
    return model(name, modLoc("block/" + name));
  }

  private ModelFile model(String name, ResourceLocation location) {
    return new ModelFile.ExistingModelFile(location, this.exFileHelper);
  }

  @Nonnull
  @Override
  public String getName() {
    return Reference.MOD_NAME_SHORT + " Block States";
  }
}
