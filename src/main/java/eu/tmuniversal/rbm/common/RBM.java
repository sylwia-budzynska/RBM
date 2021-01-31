package eu.tmuniversal.rbm.common;

import eu.tmuniversal.rbm.client.proxy.ClientProxy;
import eu.tmuniversal.rbm.common.core.IProxy;
import eu.tmuniversal.rbm.common.entity.ModEntities;
import eu.tmuniversal.rbm.common.lib.Reference;
import eu.tmuniversal.rbm.common.setup.Registration;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Reference.MOD_ID)
public class RBM {
  // Directly reference a log4j logger.
  private static final Logger LOGGER = LogManager.getLogger();

  public static IProxy proxy = new IProxy() { };

  public RBM() {
    DistExecutor.callWhenOn(Dist.CLIENT, () -> () -> proxy = new ClientProxy());
    proxy.registerHandlers();
    Registration.register();

    // Register ourselves for server and other game events we are interested in
    MinecraftForge.EVENT_BUS.register(this);

    IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
    modBus.addListener(this::commonSetup);
  }

  public void commonSetup(FMLCommonSetupEvent event) {
    event.enqueueWork(() -> {
      GlobalEntityTypeAttributes.put(ModEntities.SNOW_GIANT, MobEntity.func_233666_p_()
              .createMutableAttribute(Attributes.MOVEMENT_SPEED, 1.2)
              .createMutableAttribute(Attributes.MAX_HEALTH, 69.0D)
              .createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1.0F)
              .create());
    });
  }

/*
    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
*/
}
