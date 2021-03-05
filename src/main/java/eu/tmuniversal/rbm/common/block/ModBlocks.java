/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code on github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * Creative Commons Attribution-NonCommercial-ShareAlike 4.0
 * International Public License (CC BY-NC-SA 4.0):
 * https://creativecommons.org/licenses/by-nc-sa/4.0/
 */
package eu.tmuniversal.rbm.common.block;

import eu.tmuniversal.rbm.common.item.ModItem;
import eu.tmuniversal.rbm.common.lib.LibBlockNames;
import eu.tmuniversal.rbm.common.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.ForgeRegistries;
import shadows.placebo.util.PlaceboUtil;

public class ModBlocks {

  public static final Block TRAMPOLINE = new BlockTrampoline();
  public static final Block SOLID_AIR = new BlockSolidAir();
  public static final Block SEMI_SOLID_AIR = new BlockSemiSolidAir();
  public static final Block SLIPPERY_ICE = new BlockSlipperyIce();
  public static final Block LAUNCHPAD = new BlockLaunchpad();
  public static final Block COMPRESSED_CARVED_PUMPKIN = new BlockCompressedCarvedPumpkin();
  public static final DoorBlock REAL_FAKE_DOOR = new BlockRealFakeDoor();
  public static final CropsBlock TEA_CROP = new BlockTeaCrop();

  public static void registerBlocks(RegistryEvent.Register<Block> event) {
    register(TRAMPOLINE, LibBlockNames.TRAMPOLINE);
    register(SOLID_AIR, LibBlockNames.SOLID_AIR, ModItem.defaultBuilder().rarity(Rarity.UNCOMMON));
    register(SEMI_SOLID_AIR, LibBlockNames.SEMI_SOLID_AIR, ModItem.defaultBuilder().rarity(Rarity.UNCOMMON));
    register(SLIPPERY_ICE, LibBlockNames.SLIPPERY_ICE);
    register(LAUNCHPAD, LibBlockNames.LAUNCHPAD);
    register(COMPRESSED_CARVED_PUMPKIN, LibBlockNames.COMPRESSED_CARVED_PUMPKIN, ModItem.defaultBuilder().rarity(Rarity.RARE));
    register(REAL_FAKE_DOOR, LibBlockNames.REAL_FAKE_DOOR);
    registerNoItem(TEA_CROP, LibBlockNames.TEA_CROP);

    if (FMLEnvironment.dist == Dist.CLIENT) {
      registerRenderTypes();
    }
  }

  public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
//    ModItems.register(new BlockItem(ModBlocks.REAL_FAKE_DOOR, ModItem.defaultBuilder()), LibBlockNames.REAL_FAKE_DOOR);
  }

  public static void blockOverrides(RegistryEvent.Register<Block> event) {
    PlaceboUtil.registerOverride(new BlockOverrideBamboo(), Reference.MOD_ID);
  }

  @OnlyIn(Dist.CLIENT)
  public static void registerRenderTypes() {
    RenderTypeLookup.setRenderLayer(REAL_FAKE_DOOR, RenderType.getCutout());
    RenderTypeLookup.setRenderLayer(TEA_CROP, RenderType.getCutout());
  }

  public static Block registerNoItem(Block block, String name) {
    block.setRegistryName(name);
    ForgeRegistries.BLOCKS.register(block);
    return block;
  }

  public static Block register(Block block, String name) {
    return register(block, name, ModItem.defaultBuilder());
  }

  public static Block register(Block block, String name, Item.Properties properties) {
    BlockItem itemBlock = new BlockItem(block, properties);
    itemBlock.setRegistryName(name);
    ForgeRegistries.ITEMS.register(itemBlock);
    return registerNoItem(block, name);
  }
}
