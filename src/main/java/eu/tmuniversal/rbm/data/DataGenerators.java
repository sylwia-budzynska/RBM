package eu.tmuniversal.rbm.data;

import eu.tmuniversal.rbm.Reference;
import eu.tmuniversal.rbm.data.client.RBMBlockStateProvider;
import eu.tmuniversal.rbm.data.client.RBMItemModelProvider;
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

    gen.addProvider(new RBMBlockStateProvider(gen, existingFileHelper));
    gen.addProvider(new RBMItemModelProvider(gen, existingFileHelper));
  }
}
