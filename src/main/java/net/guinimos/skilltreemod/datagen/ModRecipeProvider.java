package net.guinimos.skilltreemod.datagen;

import java.util.List;
import java.util.function.Consumer;

import net.guinimos.skilltreemod.SkillTreeMod;
import net.guinimos.skilltreemod.block.ModBlocks;
import net.guinimos.skilltreemod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

public class ModRecipeProvider extends RecipeProvider {
    private static final List<ItemLike> MITHRIL_SMELTABLES = List.of(ModItems.RAW_MITHRIL.get(), ModBlocks.MITHRIL_ORE.get());
    private static final List<ItemLike> ADAMANTINA_SMELTABLES = List.of(ModItems.RAW_ADAMANTINA.get(), ModBlocks.ADAMANTINA_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, MITHRIL_SMELTABLES, RecipeCategory.MISC, ModItems.MITHRIL_INGOT.get(), 0.25f, 100, "mithril");
        oreSmelting(pWriter, MITHRIL_SMELTABLES, RecipeCategory.MISC, ModItems.MITHRIL_INGOT.get(), 0.25f, 200, "mithril");
        oreBlasting(pWriter, ADAMANTINA_SMELTABLES, RecipeCategory.MISC, ModItems.ADAMANTINA_INGOT.get(), 0.25f, 100, "adamantina");
        oreSmelting(pWriter, ADAMANTINA_SMELTABLES, RecipeCategory.MISC, ModItems.ADAMANTINA_INGOT.get(), 0.25f, 200, "adamantina");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModBlocks.MITHRIL_BLOCK.get(), 1)
            .pattern("MMM")
            .pattern("MMM")
            .pattern("MMM")
            .define('M', ModItems.MITHRIL_INGOT.get())
            .unlockedBy(getHasName(ModItems.MITHRIL_INGOT.get()), has(ModItems.MITHRIL_INGOT.get()))
            .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.MITHRIL_INGOT.get(), 9)
            .requires(ModBlocks.MITHRIL_BLOCK.get())
            .unlockedBy(getHasName(ModBlocks.MITHRIL_BLOCK.get()), has(ModBlocks.MITHRIL_BLOCK.get()))
            .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModBlocks.ADAMANTINA_BLOCK.get(), 1)
            .pattern("MMM")
            .pattern("MMM")
            .pattern("MMM")
            .define('M', ModItems.ADAMANTINA_INGOT.get())
            .unlockedBy(getHasName(ModItems.ADAMANTINA_INGOT.get()), has(ModItems.ADAMANTINA_INGOT.get()))
            .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.ADAMANTINA_INGOT.get(), 9)
            .requires(ModBlocks.ADAMANTINA_BLOCK.get())
            .unlockedBy(getHasName(ModBlocks.ADAMANTINA_BLOCK.get()), has(ModBlocks.ADAMANTINA_BLOCK.get()))
            .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients,
            RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients,
            RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer,
            RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients,
            RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup,
            String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder
                    .generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, SkillTreeMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
