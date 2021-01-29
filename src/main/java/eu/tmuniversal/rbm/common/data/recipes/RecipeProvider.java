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
    ShapedRecipeBuilder.shapedRecipe(ModBlocks.TRAMPOLINE_BLOCK.get())
            .key('B', Items.BAMBOO)
            .key('S', Items.SLIME_BLOCK)
            .key('s', Tags.Items.STRING)
            .patternLine("BSB")
            .patternLine("BsB")
            .patternLine("B B")
            .addCriterion("has_item", hasItem(Blocks.BAMBOO))
            .build(consumer);
  }

  @Override
  public String getName() {
    return "RBM crafting recipes";
  }
}
