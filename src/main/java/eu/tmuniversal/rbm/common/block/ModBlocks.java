/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.common.block;

import eu.tmuniversal.rbm.common.item.ModItems;
import eu.tmuniversal.rbm.common.lib.LibBlockNames;
import eu.tmuniversal.rbm.common.lib.Reference;
import eu.tmuniversal.rbm.common.setup.Registration;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.RegistryObject;
import shadows.placebo.util.PlaceboUtil;

import java.util.function.Supplier;

public class ModBlocks {

  //#region  Block Registration

  public static final RegistryObject<Block> TRAMPOLINE = register(LibBlockNames.TRAMPOLINE, BlockTrampoline::new);

  public static final RegistryObject<Block> SOLID_AIR = register(LibBlockNames.SOLID_AIR, BlockSolidAir::new, ModItems.defaultBuilder().rarity(Rarity.UNCOMMON));

  public static final RegistryObject<Block> SEMI_SOLID_AIR = register(LibBlockNames.SEMI_SOLID_AIR, BlockSemiSolidAir::new, ModItems.defaultBuilder().rarity(Rarity.UNCOMMON));

  public static final RegistryObject<Block> SLIPPERY_ICE = register(LibBlockNames.SLIPPERY_ICE, BlockSlipperyIce::new);

  public static final RegistryObject<Block> LAUNCHPAD = register(LibBlockNames.LAUNCHPAD, BlockLaunchpad::new);

  public static final RegistryObject<Block> COMPRESSED_CARVED_PUMPKIN = register(LibBlockNames.COMPRESSED_CARVED_PUMPKIN, BlockCompressedCarvedPumpkin::new, ModItems.defaultBuilder().rarity(Rarity.RARE));


  public static void blockOverrides(RegistryEvent.Register<Block> event) {
    PlaceboUtil.registerOverride(new BlockOverrideBamboo(), Reference.MOD_ID);
  }

  //#endregion  End block registration

  public static void register() {
  }

  private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> blockSupplier) {
    return Registration.BLOCKS.register(name, blockSupplier);
  }

  private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockSupplier) {
    return register(name, blockSupplier, ModItems.defaultBuilder());
  }

  private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockSupplier, Item.Properties properties) {
    RegistryObject<T> returnValue = registerNoItem(name, blockSupplier);
    Registration.ITEMS.register(name, () -> new BlockItem(returnValue.get(), properties));
    return returnValue;
  }
}
