/*
 * This class is distributed as part of the RBM Mod.
 * Get the Source Code in github:
 * https://github.com/TMUniversal/RBM
 *
 * RBM is Open Source and distributed under the
 * GPL-3.0 License: https://www.gnu.org/licenses/gpl-3.0.en.html
 */
package eu.tmuniversal.rbm.data.recipes;

import eu.tmuniversal.rbm.common.block.ModBlocks;
import eu.tmuniversal.rbm.common.item.ModItems;
import eu.tmuniversal.rbm.common.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

import static eu.tmuniversal.rbm.common.lib.ResourceLocationHelper.prefix;
import static eu.tmuniversal.rbm.common.lib.ResourceLocationHelper.prefixId;

public class RecipeProvider extends net.minecraft.data.RecipeProvider {
  public RecipeProvider(DataGenerator generatorIn) {
    super(generatorIn);
  }

  public static ResourceLocation recipeLocation(Block block, String name) {
    return prefix(block.getRegistryName().getPath() + name);
  }

  @Override
  public void registerRecipes(Consumer<IFinishedRecipe> consumer) {
    registerMain(consumer);
  }

  public void registerMain(Consumer<IFinishedRecipe> consumer) {
    ShapedRecipeBuilder.shapedRecipe(ModBlocks.TRAMPOLINE, 4)
      .key('B', Items.BAMBOO)
      .key('S', Items.SLIME_BLOCK)
      .key('d', Tags.Items.DYES_BLACK)
      .patternLine("BSB")
      .patternLine("BdB")
      .patternLine("B B")
      .addCriterion("has_item", hasItem(Blocks.BAMBOO))
      .build(consumer);
    ShapedRecipeBuilder.shapedRecipe(ModBlocks.SEMI_SOLID_AIR, 8)
      .key('B', Items.GLASS_BOTTLE)
      .patternLine("BBB")
      .patternLine("B B")
      .patternLine("BBB")
      .addCriterion("has_item", hasItem(Blocks.GLASS))
      .setGroup(prefixId("solid_air"))
      .build(consumer);
    ShapelessRecipeBuilder.shapelessRecipe(ModBlocks.SOLID_AIR)
      .addIngredient(ModBlocks.SEMI_SOLID_AIR, 2)
      .addCriterion("has_item", hasItem(ModBlocks.SEMI_SOLID_AIR))
      .setGroup(prefixId("solid_air"))
      .build(consumer);
    ShapelessRecipeBuilder.shapelessRecipe(ModBlocks.SEMI_SOLID_AIR, 2)
      .addIngredient(ModBlocks.SOLID_AIR)
      .addCriterion("has_item", hasItem(ModBlocks.SOLID_AIR))
      .setGroup(prefixId("solid_air"))
      .build(consumer, recipeLocation(ModBlocks.SEMI_SOLID_AIR, "_from_solid_air"));
    ShapedRecipeBuilder.shapedRecipe(ModBlocks.SLIPPERY_ICE, 4)
      .key('I', Items.ICE)
      .key('B', Items.BLUE_ICE)
      .patternLine(" I ")
      .patternLine("IBI")
      .patternLine(" I ")
      .addCriterion("has_item", hasItem(Blocks.ICE))
      .build(consumer);
    ShapelessRecipeBuilder.shapelessRecipe(ModItems.TEA_SEEDS, 1)
      .addIngredient(ModItems.TEA_LEAF)
      .addCriterion("has_item", hasItem(ModItems.TEA_LEAF))
      .setGroup(prefixId("tea"))
      .build(consumer);
  }

  @Override
  public String getName() {
    return Reference.MOD_NAME_SHORT + " Crafting Recipes";
  }
}
