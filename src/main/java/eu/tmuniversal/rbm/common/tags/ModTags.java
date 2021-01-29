package eu.tmuniversal.rbm.common.tags;

import eu.tmuniversal.rbm.common.Reference;
import eu.tmuniversal.rbm.common.block.BlockSolidAir;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {
  public static final class Blocks {
    public static final ITag.INamedTag<Block> TRAMPOLINE_BLOCK = forge("blocks/trampoline");

    public static final ITag.INamedTag<Block> SOLID_AIR_BLOCK = mod("blocks/" + BlockSolidAir.NAME);

    private static ITag.INamedTag<Block> forge(String path) {
      return BlockTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
    }

    private static ITag.INamedTag<Block> mod(String path) {
      return BlockTags.makeWrapperTag(new ResourceLocation(Reference.MOD_ID, path).toString());
    }
  }

  public static final class Items {
//    BlockItems
    public static final ITag.INamedTag<Item> ORES_DUMMY_BLOCK = forge("ores/dummy");

//    Actual items
    public static final ITag.INamedTag<Item> INGOTS_DUMMY = forge("ingots/dummy");

    private static ITag.INamedTag<Item> forge(String path) {
      return ItemTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
    }

    private static ITag.INamedTag<Item> mod(String path) {
      return ItemTags.makeWrapperTag(new ResourceLocation(Reference.MOD_ID, path).toString());
    }
  }
}
