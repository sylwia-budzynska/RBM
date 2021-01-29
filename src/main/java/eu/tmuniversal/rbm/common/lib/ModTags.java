package eu.tmuniversal.rbm.common.lib;

import eu.tmuniversal.rbm.common.block.BlockSemiSolidAir;
import eu.tmuniversal.rbm.common.block.BlockSolidAir;
import eu.tmuniversal.rbm.common.block.BlockTrampoline;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

import java.util.List;
import java.util.function.Function;

import static eu.tmuniversal.rbm.common.lib.ResourceLocationHelper.prefix;

public class ModTags {
  private static <T> ITag.INamedTag<T> getOrRegister(List<? extends ITag.INamedTag<T>> list, Function<ResourceLocation, ITag.INamedTag<T>> register, ResourceLocation loc) {
    for (ITag.INamedTag<T> existing : list) {
      if (existing.getName().equals(loc)) {
        return existing;
      }
    }

    return register.apply(loc);
  }

  public static final class Blocks {
    public static final ITag.INamedTag<Block> TRAMPOLINE = forgeTag("blocks/" + BlockTrampoline.NAME);

    public static final ITag.INamedTag<Block> BLOCKS_SOLID_AIR = tag("blocks/solid_air");

    private static ITag.INamedTag<Block> tag(String name) {
      return BlockTags.makeWrapperTag(prefix(name).toString());
    }

    private static ITag.INamedTag<Block> forgeTag(String name) {
      return getOrRegister(BlockTags.getAllTags(), loc -> BlockTags.makeWrapperTag(loc.toString()), new ResourceLocation("forge", name));
    }
  }

  public static final class Items {
    //    BlockItems
    public static final ITag.INamedTag<Item> ORES_DUMMY_BLOCK = forge("ores/dummy");

    //    Actual items
    public static final ITag.INamedTag<Item> INGOTS_DUMMY = forge("ingots/dummy");

    private static ITag.INamedTag<Item> mod(String name) {
      return ItemTags.makeWrapperTag(prefix(name).toString());
    }

    private static ITag.INamedTag<Item> forge(String name) {
      return getOrRegister(ItemTags.getAllTags(), loc -> ItemTags.makeWrapperTag(loc.toString()), new ResourceLocation("forge", name));
    }
  }
}
