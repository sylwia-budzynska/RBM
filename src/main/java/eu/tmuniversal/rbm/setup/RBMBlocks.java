package eu.tmuniversal.rbm.setup;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class RBMBlocks {

  public static final RegistryObject<Block> DUMMY_BLOCK = register("dummy_block", () ->
          new Block(AbstractBlock.Properties.create(Material.ROCK)
                  .hardnessAndResistance(3, 10)
                  .harvestLevel(5)
                  .sound(SoundType.GROUND)
                  .jumpFactor(4)));

  private static Block defaultBlock() {
    return new Block(makeBlockProperties(Material.ROCK)
            .hardnessAndResistance(3, 10)
            .harvestLevel(0)
            .sound(SoundType.STONE)
    );
  }

  private static AbstractBlock.Properties makeBlockProperties(Material material) {
    return AbstractBlock.Properties.create(material);
  }

  static void register() {
  }

  private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> blockSupplier) {
    return Registration.BLOCKS.register(name, blockSupplier);
  }

  private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockSupplier) {
    RegistryObject<T> returnValue = registerNoItem(name, blockSupplier);
    Registration.ITEMS.register(name, () -> new BlockItem(returnValue.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
    return returnValue;
  }
}
