package net.isaac.isaacsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.isaac.isaacsmod.block.ModBlocks;
import net.isaac.isaacsmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> MITHRIL_SMELTABLES = List.of(ModItems.RAW_MITHRIL);
    private static final List<ItemConvertible> ADAMANT_SMELTABLES = List.of(ModItems.RAW_ADAMANT);
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }
    /// Take a look at the "recipeProvider" and "VanillaRecipeProvider" class by mmb one of the offer methods
    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, MITHRIL_SMELTABLES, RecipeCategory.MISC, ModItems.MITHRIL, 0.5f, 100, "mithril");
        offerBlasting(exporter, MITHRIL_SMELTABLES, RecipeCategory.MISC, ModItems.MITHRIL, 0.5f, 50, "mithril");
        offerSmelting(exporter, ADAMANT_SMELTABLES, RecipeCategory.MISC, ModItems.ADAMANT, 1f, 200, "adamant");
        offerBlasting(exporter, ADAMANT_SMELTABLES, RecipeCategory.MISC, ModItems.ADAMANT, 1f, 100, "adamant");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.MITHRIL, RecipeCategory.DECORATIONS, ModBlocks.MITHRIL_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ADAMANT, RecipeCategory.DECORATIONS, ModBlocks.ADAMANT_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.LESSER_MANA, RecipeCategory.MISC, ModItems.GREATER_MANA);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.LESSER_GREEN_MANA, RecipeCategory.MISC, ModItems.GREATER_GREEN_MANA);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.LESSER_PINK_MANA, RecipeCategory.MISC, ModItems.GREATER_PINK_MANA);

/// SHAPELESS RECIPES:
        /// Mithril Sword Recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.MITHRIL_SWORD, 1)
                .pattern("M")
                .pattern("M")
                .pattern("S")
                .input('M',ModItems.MITHRIL)
                .input('S',Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.MITHRIL), conditionsFromItem(ModItems.MITHRIL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.MITHRIL_SWORD)));

        /// Mithril Pickaxe Recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.MITHRIL_PICKAXE, 1)
                .pattern("MMM")
                .pattern(" S ")
                .pattern(" S ")
                .input('M',ModItems.MITHRIL)
                .input('S',Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.MITHRIL), conditionsFromItem(ModItems.MITHRIL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.MITHRIL_PICKAXE)));

        /// Mithril AXE Recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.MITHRIL_AXE, 1)
                .pattern("MM")
                .pattern("MS")
                .pattern(" S")
                .input('M',ModItems.MITHRIL)
                .input('S',Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.MITHRIL), conditionsFromItem(ModItems.MITHRIL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.MITHRIL_AXE)));

        /// Mithril SHOVEL Recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.MITHRIL_SHOVEL, 1)
                .pattern("M")
                .pattern("S")
                .pattern("S")
                .input('M',ModItems.MITHRIL)
                .input('S',Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.MITHRIL), conditionsFromItem(ModItems.MITHRIL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.MITHRIL_SHOVEL)));

        /// Adamant Sword Recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ADAMANT_SWORD, 1)
                .pattern("A")
                .pattern("A")
                .pattern("S")
                .input('A',ModItems.ADAMANT)
                .input('S',Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.ADAMANT), conditionsFromItem(ModItems.ADAMANT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADAMANT_SWORD)));

        /// Adamant Pickaxe Recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ADAMANT_PICKAXE, 1)
                .pattern("AAA")
                .pattern(" S ")
                .pattern(" S ")
                .input('A',ModItems.ADAMANT)
                .input('S',Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.ADAMANT), conditionsFromItem(ModItems.ADAMANT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADAMANT_PICKAXE)));

        /// Adamant AXE Recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ADAMANT_AXE, 1)
                .pattern("AA")
                .pattern("AS")
                .pattern(" S")
                .input('A',ModItems.ADAMANT)
                .input('S',Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.ADAMANT), conditionsFromItem(ModItems.ADAMANT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADAMANT_AXE)));

        /// Adamant SHOVEL Recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ADAMANT_SHOVEL, 1)
                .pattern("A")
                .pattern("S")
                .pattern("S")
                .input('A',ModItems.ADAMANT)
                .input('S',Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.ADAMANT), conditionsFromItem(ModItems.ADAMANT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADAMANT_SHOVEL)));






    }
}
