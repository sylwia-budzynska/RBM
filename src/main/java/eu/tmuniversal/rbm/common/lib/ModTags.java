/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.common.lib;

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
    public static final ITag.INamedTag<Block> TRAMPOLINE = forgeTag(LibBlockNames.TRAMPOLINE);

    public static final ITag.INamedTag<Block> BLOCKS_SOLID_AIR = tag(LibBlockNames.SOLID_AIR);

    public static final ITag.INamedTag<Block> BLOCKS_VERY_SLIPPERY_ICE = forgeTag("ice");

    private static ITag.INamedTag<Block> tag(String name) {
      return BlockTags.makeWrapperTag(prefix(name).toString());
    }

    private static ITag.INamedTag<Block> forgeTag(String name) {
      return getOrRegister(BlockTags.getAllTags(), loc -> BlockTags.makeWrapperTag(loc.toString()), new ResourceLocation("forge", name));
    }
  }

  public static final class Items {
    //    BlockItems

    //    Actual items

    private static ITag.INamedTag<Item> mod(String name) {
      return ItemTags.makeWrapperTag(prefix(name).toString());
    }

    private static ITag.INamedTag<Item> forge(String name) {
      return getOrRegister(ItemTags.getAllTags(), loc -> ItemTags.makeWrapperTag(loc.toString()), new ResourceLocation("forge", name));
    }
  }
}
