package eu.tmuniversal.rbm.data.recipes;

import eu.tmuniversal.rbm.common.block.BlockSemiSolidAir;
import eu.tmuniversal.rbm.common.block.ModBlocks;
import eu.tmuniversal.rbm.common.lib.ModTags;
import net.minecraft.advancements.criterion.ItemPredicate;
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
import static eu.tmuniversal.rbm.common.lib.ResourceLocationHelper.prefixS;

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
    ShapedRecipeBuilder.shapedRecipe(ModBlocks.SEMI_SOLID_AIR_BLOCK.get(), 8)
            .key('B', Items.GLASS_BOTTLE)
            .patternLine("BBB")
            .patternLine("B B")
            .patternLine("BBB")
            .addCriterion("has_item", hasItem(Blocks.GLASS))
            .setGroup(prefixS("solid_air"))
            .build(consumer, recipeLocation(ModBlocks.SEMI_SOLID_AIR_BLOCK));
    ShapelessRecipeBuilder.shapelessRecipe(ModBlocks.SOLID_AIR_BLOCK.get())
            .addIngredient(ModBlocks.SEMI_SOLID_AIR_BLOCK.get(), 2)
            .addCriterion("has_item", hasItem(ModBlocks.SEMI_SOLID_AIR_BLOCK.get()))
            .setGroup(prefixS("solid_air"))
            .build(consumer);
    ShapelessRecipeBuilder.shapelessRecipe(ModBlocks.SEMI_SOLID_AIR_BLOCK.get(), 2)
            .addIngredient(ModBlocks.SOLID_AIR_BLOCK.get())
            .addCriterion("has_item", hasItem(ModBlocks.SOLID_AIR_BLOCK.get()))
            .setGroup(prefixS("solid_air"))
            .build(consumer, recipeLocation(ModBlocks.SEMI_SOLID_AIR_BLOCK, "_from_solid_air"));
  }

  public static ResourceLocation recipeLocation (RegistryObject<Block> block, String name) {
    return prefix(block.getId().getPath() + name);
  }

  public static ResourceLocation recipeLocation (RegistryObject<Block> block) {
    return prefix(block.getId().getPath());
  }

  @Override
  public String getName() {
    return "RBM crafting recipes";
  }
}
