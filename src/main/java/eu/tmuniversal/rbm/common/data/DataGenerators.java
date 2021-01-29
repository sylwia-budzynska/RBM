package eu.tmuniversal.rbm.common.data;

import eu.tmuniversal.rbm.common.Reference;
import eu.tmuniversal.rbm.common.data.client.ModBlockStateProvider;
import eu.tmuniversal.rbm.common.data.client.ModItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators {
  private DataGenerators() {}

  @SubscribeEvent
  public static void gatherData(GatherDataEvent event) {
    DataGenerator gen = event.getGenerator();
    ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

    gen.addProvider(new ModBlockStateProvider(gen, existingFileHelper));
    gen.addProvider(new ModItemModelProvider(gen, existingFileHelper));

    ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(gen, existingFileHelper);
    gen.addProvider(blockTagsProvider);
    gen.addProvider(new ModItemTagsProvider(gen, blockTagsProvider, existingFileHelper));

    gen.addProvider(new BlockLootProvider(gen));
  }
}
