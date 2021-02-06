/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import eu.tmuniversal.rbm.common.lib.Reference;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.MatchTool;
import net.minecraft.loot.conditions.SurvivesExplosion;
import net.minecraft.loot.functions.CopyNbt;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class BlockLootProvider implements IDataProvider {
  private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
  private static final ILootCondition.IBuilder SILK_TOUCH = MatchTool.builder(ItemPredicate.Builder.create()
          .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1))));

  private final DataGenerator generator;
  private final Map<Block, Function<Block, LootTable.Builder>> functionTable = new HashMap<>();

  public BlockLootProvider(DataGenerator generator) {
    this.generator = generator;

//    /**
//     * @see https://github.com/Vazkii/Botania/blob/22ad6789d537f31076a602e6b984a64e6315c05f/src/main/java/vazkii/botania/data/BlockLootProvider.java
//     */
//    for (Block block : Registry.BLOCK) {
//      ResourceLocation id = Registry.BLOCK.getKey(block);
//      if (!Reference.MOD_ID.equals(id.getNamespace())) continue;
//
////      generate similar
//    }
  }

  private static Path getPath(Path root, ResourceLocation id) {
    return root.resolve("data/" + id.getNamespace() + "/loot_tables/blocks/" + id.getPath() + ".json");
  }

  private static LootTable.Builder empty(Block b) {
    return LootTable.builder();
  }

  private static LootTable.Builder genCopyNbt(Block b, String... tags) {
    LootEntry.Builder<?> entry = ItemLootEntry.builder(b);
    CopyNbt.Builder func = CopyNbt.builder(CopyNbt.Source.BLOCK_ENTITY);
    for (String tag : tags) {
      func = func.replaceOperation(tag, "BlockEntityTag." + tag);
    }
    LootPool.Builder pool = LootPool.builder().name("main").rolls(ConstantRange.of(1)).addEntry(entry)
            .acceptCondition(SurvivesExplosion.builder())
            .acceptFunction(func);
    return LootTable.builder().addLootPool(pool);
  }

  private static LootTable.Builder genRegular(Block b) {
    LootEntry.Builder<?> entry = ItemLootEntry.builder(b);
    LootPool.Builder pool = LootPool.builder().name("main").rolls(ConstantRange.of(1)).addEntry(entry)
            .acceptCondition(SurvivesExplosion.builder());
    return LootTable.builder().addLootPool(pool);
  }

  @Override
  public void act(DirectoryCache cache) throws IOException {
    Map<ResourceLocation, LootTable.Builder> tables = new HashMap<>();

    for (Block b : Registry.BLOCK) {
      ResourceLocation id = Registry.BLOCK.getKey(b);
      if (!Reference.MOD_ID.equals(id.getNamespace())) {
        continue;
      }
      Function<Block, LootTable.Builder> func = functionTable.getOrDefault(b, BlockLootProvider::genRegular);
      tables.put(id, func.apply(b));
    }

    for (Map.Entry<ResourceLocation, LootTable.Builder> e : tables.entrySet()) {
      Path path = getPath(generator.getOutputFolder(), e.getKey());
      IDataProvider.save(GSON, cache, LootTableManager.toJson(e.getValue().setParameterSet(LootParameterSets.BLOCK).build()), path);
    }
  }

  @Nonnull
  @Override
  public String getName() {
    return "RBM block loot tables";
  }
}
