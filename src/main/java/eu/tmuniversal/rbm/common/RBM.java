/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.common;

import eu.tmuniversal.rbm.client.proxy.ClientProxy;
import eu.tmuniversal.rbm.common.block.ModBlocks;
import eu.tmuniversal.rbm.common.core.IProxy;
import eu.tmuniversal.rbm.common.entity.ModEntities;
import eu.tmuniversal.rbm.common.entity.passive.EntitySnowGiant;
import eu.tmuniversal.rbm.common.item.ModItems;
import eu.tmuniversal.rbm.common.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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

  public static IProxy proxy = new IProxy() {
  };

  public RBM() {
    DistExecutor.callWhenOn(Dist.CLIENT, () -> () -> proxy = new ClientProxy());
    proxy.registerHandlers();

    // Register ourselves for server and other game events we are interested in
    MinecraftForge.EVENT_BUS.register(this);

    IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
    modBus.addListener(this::commonSetup);
    modBus.addGenericListener(Block.class, ModBlocks::registerBlocks);
    modBus.addGenericListener(Block.class, ModBlocks::blockOverrides);
    modBus.addGenericListener(Item.class, ModBlocks::registerItemBlocks);
    modBus.addGenericListener(Item.class, ModItems::registerItems);
    modBus.addGenericListener(EntityType.class, ModEntities::registerEntities);
  }

  public void commonSetup(FMLCommonSetupEvent event) {
    event.enqueueWork(() -> {
      GlobalEntityTypeAttributes.put(ModEntities.SNOW_GIANT, EntitySnowGiant.setAttributes());
    });
  }

  //  Do not allow Snow Giants to receive fire damage
  @SubscribeEvent
  public void onBurnDamage(LivingAttackEvent event) {
    if (event.getEntity() instanceof EntitySnowGiant) {
      if (event.getSource().equals(DamageSource.ON_FIRE) || event.getSource().equals(DamageSource.IN_FIRE)) {
        event.setCanceled(true);
      }
    }
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
