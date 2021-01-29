package eu.tmuniversal.rbm.data;

import eu.tmuniversal.rbm.common.lib.Reference;
import eu.tmuniversal.rbm.data.client.BlockStateProvider;
import eu.tmuniversal.rbm.data.client.ItemModelProvider;
import eu.tmuniversal.rbm.data.recipes.RecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators {
  private DataGenerators() {
  }

  @SubscribeEvent
  public static void gatherData(GatherDataEvent event) {
    DataGenerator gen = event.getGenerator();
    ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

    if (event.includeServer()) {
      BlockTagsProvider blockTagsProvider = new BlockTagsProvider(gen, existingFileHelper);
      gen.addProvider(blockTagsProvider);
      gen.addProvider(new ItemTagsProvider(gen, blockTagsProvider, existingFileHelper));

      gen.addProvider(new BlockLootProvider(gen));
      gen.addProvider(new RecipeProvider(gen));
    }

    if (event.includeClient()) {
      gen.addProvider(new BlockStateProvider(gen, existingFileHelper));
      gen.addProvider(new ItemModelProvider(gen, existingFileHelper));
    }
  }
}
