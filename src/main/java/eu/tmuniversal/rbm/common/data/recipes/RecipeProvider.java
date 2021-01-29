package eu.tmuniversal.rbm.common.data.recipes;

import eu.tmuniversal.rbm.common.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class RecipeProvider extends net.minecraft.data.RecipeProvider {
  public RecipeProvider(DataGenerator generatorIn) {
    super(generatorIn);
  }


  @Override
  public void registerRecipes(Consumer<IFinishedRecipe> consumer) {
    registerMain(consumer);
  }

  public void registerMain(Consumer<IFinishedRecipe> consumer) {
    ShapedRecipeBuilder.shapedRecipe(ModBlocks.TRAMPOLINE_BLOCK.get(), 4)
            .key('B', Items.BAMBOO)
            .key('S', Items.SLIME_BLOCK)
            .key('d', Tags.Items.DYES_BLACK)
            .patternLine("BSB")
            .patternLine("BdB")
            .patternLine("B B")
            .addCriterion("has_item", hasItem(Blocks.BAMBOO))
            .build(consumer);
    ShapedRecipeBuilder.shapedRecipe(ModBlocks.SOLID_AIR_BLOCK.get())
            .key('B', Items.BUCKET)
            .key('G', Items.GLASS)
            .patternLine("BBB")
            .patternLine("BGB")
            .patternLine("BBB")
            .addCriterion("has_item", hasItem(Blocks.GLASS))
            .build(consumer);
  }

  @Override
  public String getName() {
    return "RBM crafting recipes";
  }
}
