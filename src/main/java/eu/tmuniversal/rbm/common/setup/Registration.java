package eu.tmuniversal.rbm.common.setup;

import eu.tmuniversal.rbm.common.block.ModBlocks;
import eu.tmuniversal.rbm.common.entity.ModEntities;
import eu.tmuniversal.rbm.common.item.ModItems;
import eu.tmuniversal.rbm.common.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MOD_ID);
  public static final DeferredRegister<Block> OVERRIDE_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "minecraft");

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);
  public static final DeferredRegister<Item> OVERRIDE_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft");

  public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Reference.MOD_ID);

  public static void register() {
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    OVERRIDE_BLOCKS.register(modEventBus);
    OVERRIDE_ITEMS.register(modEventBus);

    BLOCKS.register(modEventBus);
    ITEMS.register(modEventBus);
    ENTITIES.register(modEventBus);


    ModBlocks.register();
    ModItems.register();
    ModEntities.register();
  }
}
