package eu.tmuniversal.rbm.common.setup;

import eu.tmuniversal.rbm.common.lib.Reference;
import eu.tmuniversal.rbm.common.block.ModBlocks;
import eu.tmuniversal.rbm.common.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MOD_ID);
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);

  public static final DeferredRegister<Block> OVERRIDE_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "minecraft");
  public static final DeferredRegister<Item> OVERRIDE_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft");

  public static void register() {
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    BLOCKS.register(modEventBus);
    ITEMS.register(modEventBus);

    OVERRIDE_BLOCKS.register(modEventBus);
    OVERRIDE_ITEMS.register(modEventBus);

    ModBlocks.register();
    ModItems.register();
  }
}
