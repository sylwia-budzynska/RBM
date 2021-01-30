package eu.tmuniversal.rbm.common.block;

import eu.tmuniversal.rbm.common.item.ModItems;
import eu.tmuniversal.rbm.common.lib.LibBlockNames;
import eu.tmuniversal.rbm.common.setup.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

  //#region  Block Registration

  public static final RegistryObject<Block> TRAMPOLINE = register(LibBlockNames.TRAMPOLINE, BlockTrampoline::new);

  public static final RegistryObject<Block> SOLID_AIR = register(LibBlockNames.SOLID_AIR, BlockSolidAir::new, ModItems.defaultBuilder().rarity(Rarity.UNCOMMON));

  public static final RegistryObject<Block> SEMI_SOLID_AIR = register(LibBlockNames.SEMI_SOLID_AIR, BlockSemiSolidAir::new, ModItems.defaultBuilder().rarity(Rarity.UNCOMMON));

  public static final RegistryObject<Block> SLIPPERY_ICE = register(LibBlockNames.SLIPPERY_ICE, BlockSlipperyIce::new);

  // v Vanilla Overrides v

  public static final RegistryObject<Block> BAMBOO_BLOCK = overrideRegister("bamboo", BlockOverrideBamboo::new, new Item.Properties().group(ItemGroup.DECORATIONS));

  //#endregion  End block registration

  public static AbstractBlock.Properties makeBlockProperties(Material material) {
    return AbstractBlock.Properties.create(material);
  }

  public static AbstractBlock.Properties makeBlockProperties(Material material, MaterialColor materialColor) {
    return AbstractBlock.Properties.create(material, materialColor);
  }

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

//  Overrides

  private static <T extends Block> RegistryObject<T> overrideRegisterNoItem(String name, Supplier<T> blockSupplier) {
    return Registration.OVERRIDE_BLOCKS.register(name, blockSupplier);
  }

  private static <T extends Block> RegistryObject<T> overrideRegister(String name, Supplier<T> blockSupplier) {
    return overrideRegister(name, blockSupplier, new Item.Properties());
  }

  private static <T extends Block> RegistryObject<T> overrideRegister(String name, Supplier<T> blockSupplier, Item.Properties itemProperties) {
    RegistryObject<T> returnValue = overrideRegisterNoItem(name, blockSupplier);
    Registration.OVERRIDE_ITEMS.register(name, () -> new BlockItem(returnValue.get(), itemProperties));
    return returnValue;
  }
}
