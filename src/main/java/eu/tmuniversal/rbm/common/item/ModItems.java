package eu.tmuniversal.rbm.common.item;

import eu.tmuniversal.rbm.common.setup.Registration;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {

  public static final RegistryObject<Item> DUMMY_ITEM = Registration.ITEMS.register("dummy_item", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

  public static void register() {}
}
