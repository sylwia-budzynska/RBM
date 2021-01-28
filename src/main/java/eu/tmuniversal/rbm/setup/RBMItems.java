package eu.tmuniversal.rbm.setup;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class RBMItems {

  public static final RegistryObject<Item> DUMMY_ITEM = Registration.ITEMS.register("dummy_item", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

  static void register() {}
}
