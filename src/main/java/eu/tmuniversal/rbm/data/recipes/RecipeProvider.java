package eu.tmuniversal.rbm.data.recipes;

import eu.tmuniversal.rbm.common.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Consumer;

import static eu.tmuniversal.rbm.common.lib.ResourceLocationHelper.prefix;
import static eu.tmuniversal.rbm.common.lib.ResourceLocationHelper.prefixId;

public class RecipeProvider extends net.minecraft.data.RecipeProvider {
  public RecipeProvider(DataGenerator generatorIn) {
    super(generatorIn);
  }


  @Override
  public void registerRecipes(Consumer<IFinishedRecipe> consumer) {
    registerMain(consumer);
  }

  public void registerMain(Consumer<IFinishedRecipe> consumer) {
    ShapedRecipeBuilder.shapedRecipe(ModBlocks.TRAMPOLINE.get(), 4)
            .key('B', Items.BAMBOO)
            .key('S', Items.SLIME_BLOCK)
            .key('d', Tags.Items.DYES_BLACK)
            .patternLine("BSB")
            .patternLine("BdB")
            .patternLine("B B")
            .addCriterion("has_item", hasItem(Blocks.BAMBOO))
            .build(consumer);
    ShapedRecipeBuilder.shapedRecipe(ModBlocks.SEMI_SOLID_AIR.get(), 8)
            .key('B', Items.GLASS_BOTTLE)
            .patternLine("BBB")
            .patternLine("B B")
            .patternLine("BBB")
            .addCriterion("has_item", hasItem(Blocks.GLASS))
            .setGroup(prefixId("solid_air"))
            .build(consumer);
    ShapelessRecipeBuilder.shapelessRecipe(ModBlocks.SOLID_AIR.get())
            .addIngredient(ModBlocks.SEMI_SOLID_AIR.get(), 2)
            .addCriterion("has_item", hasItem(ModBlocks.SEMI_SOLID_AIR.get()))
            .setGroup(prefixId("solid_air"))
            .build(consumer);
    ShapelessRecipeBuilder.shapelessRecipe(ModBlocks.SEMI_SOLID_AIR.get(), 2)
            .addIngredient(ModBlocks.SOLID_AIR.get())
            .addCriterion("has_item", hasItem(ModBlocks.SOLID_AIR.get()))
            .setGroup(prefixId("solid_air"))
            .build(consumer, recipeLocation(ModBlocks.SEMI_SOLID_AIR, "_from_solid_air"));
    ShapedRecipeBuilder.shapedRecipe(ModBlocks.SLIPPERY_ICE.get(), 4)
            .key('I', Items.ICE)
            .key('P', Items.BLUE_ICE)
            .patternLine(" I ")
            .patternLine("IPI")
            .patternLine(" I ")
            .addCriterion("has_item", hasItem(Blocks.ICE))
            .build(consumer);
  }

  public static ResourceLocation recipeLocation (RegistryObject<Block> block, String name) {
    return prefix(block.getId().getPath() + name);
  }

  @Override
  public String getName() {
    return "RBM Crafting Recipes";
  }
}
