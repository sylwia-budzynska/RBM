/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.common.block;

import eu.tmuniversal.rbm.common.item.ModItem;
import eu.tmuniversal.rbm.common.lib.LibBlockNames;
import eu.tmuniversal.rbm.common.lib.Reference;
import eu.tmuniversal.rbm.common.setup.Registry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.loading.FMLEnvironment;
import shadows.placebo.util.PlaceboUtil;

import java.util.function.Supplier;

public class ModBlocks {

  public static void register() {
    registerBlocks();
    if (FMLEnvironment.dist == Dist.CLIENT) {
      registerRenderTypes();
    }
  }

  public static void registerBlocks() {
    RBMBlocks.trampoline = register(LibBlockNames.TRAMPOLINE, BlockTrampoline::new);
    RBMBlocks.solid_air = register(LibBlockNames.SOLID_AIR, BlockSolidAir::new, ModItem.defaultBuilder().rarity(Rarity.UNCOMMON));
    RBMBlocks.semi_solid_air = register(LibBlockNames.SEMI_SOLID_AIR, BlockSemiSolidAir::new, ModItem.defaultBuilder().rarity(Rarity.UNCOMMON));
    RBMBlocks.slippery_ice = register(LibBlockNames.SLIPPERY_ICE, BlockSlipperyIce::new);
    RBMBlocks.launchpad = register(LibBlockNames.LAUNCHPAD, BlockLaunchpad::new);
    RBMBlocks.compressed_carved_pumpkin = register(LibBlockNames.COMPRESSED_CARVED_PUMPKIN, BlockCompressedCarvedPumpkin::new, ModItem.defaultBuilder().rarity(Rarity.RARE));
    RBMBlocks.real_fake_door = register(LibBlockNames.REAL_FAKE_DOOR, BlockRealFakeDoor::new);
  }

  public static void blockOverrides(RegistryEvent.Register<Block> event) {
    PlaceboUtil.registerOverride(new BlockOverrideBamboo(), Reference.MOD_ID);
  }

  @OnlyIn(Dist.CLIENT)
  public static void registerRenderTypes() {
//    RenderTypeLookup.setRenderLayer(RBMBlocks.real_fake_door.get(), RenderType.getCutout());
  }

  private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> blockSupplier) {
    return Registry.BLOCKS.register(name, blockSupplier);
  }

  private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockSupplier) {
    return register(name, blockSupplier, ModItem.defaultBuilder());
  }

  private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockSupplier, Item.Properties properties) {
    RegistryObject<T> returnValue = registerNoItem(name, blockSupplier);
    Registry.ITEMS.register(name, () -> new BlockItem(returnValue.get(), properties));
    return returnValue;
  }
}
