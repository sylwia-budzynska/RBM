package eu.tmuniversal.rbm.client.proxy;

import eu.tmuniversal.rbm.client.render.entity.RendererSnowGiant;
import eu.tmuniversal.rbm.common.core.IProxy;
import eu.tmuniversal.rbm.common.entity.ModEntities;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ClientProxy implements IProxy {

  @Override
  public void registerHandlers() {
    IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
    modBus.addListener(this::clientSetup);

//    IEventBus forgeBus = MinecraftForge.EVENT_BUS;
  }

  private void clientSetup(FMLClientSetupEvent event) {
    registerEntityRenderers();
  }

  private static void registerEntityRenderers() {
    RenderingRegistry.registerEntityRenderingHandler(ModEntities.SNOW_GIANT, (manager) -> new RendererSnowGiant(manager, ModEntities.SNOW_GIANT_SCALE));
  }
}
