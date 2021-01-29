package eu.tmuniversal.rbm.common.block;

import eu.tmuniversal.rbm.common.setup.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
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

  public static final RegistryObject<Block> DUMMY_BLOCK = register("dummy_block", () -> new Block(makeBlockProperties(Material.ROCK).hardnessAndResistance(3, 10).harvestLevel(5).sound(SoundType.STONE)));

  public static final RegistryObject<Block> TRAMPOLINE_BLOCK = register("trampoline", BlockTrampoline::new, new Item.Properties().group(ItemGroup.DECORATIONS));

  public static final RegistryObject<Block> SOLID_AIR_BLOCK = register(BlockSolidAir.NAME, BlockSolidAir::new, new Item.Properties().group(ItemGroup.DECORATIONS).rarity(Rarity.UNCOMMON));

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
    return register(name, blockSupplier, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
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
