package net.digitalpear.enhanced_compat.common.datagens;

import net.digitalpear.enhanced_compat.init.ECBlocks;
import net.digitalpear.enhanced_compat.init.ECItems;
import net.digitalpear.enhanced_compat.init.ECTags;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

//Absolutely broken right now, idk why, where, or when, all I know is that it doesn't work.

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {

        ShapelessRecipeBuilder.shapeless(ECBlocks.GLOWSHROOM_PLANKS.get())
                .requires(ECBlocks.GLOWSHROOM_STEM.get())
                .unlockedBy("has_glowshroom_stem", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ECTags.GLOWSHROOM_STEMS).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ECBlocks.GLOWSHROOM_HYPHAE.get(), 3)
                .define('E', ECBlocks.GLOWSHROOM_STEM.get())
                .pattern("EE")
                .pattern("EE")
                .unlockedBy("has_glowshroom_stem", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ECBlocks.GLOWSHROOM_STEM.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ECBlocks.STRIPPED_GLOWSHROOM_HYPHAE.get(), 3)
                .define('E', ECBlocks.STRIPPED_GLOWSHROOM_STEM.get())
                .pattern("EE")
                .pattern("EE")
                .unlockedBy("has_stripped_glowshroom_stem", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ECBlocks.STRIPPED_GLOWSHROOM_STEM.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ECBlocks.GLOWSHROOM_STAIRS.get(), 4)
                .define('E', ECBlocks.GLOWSHROOM_PLANKS.get())
                .pattern("E")
                .pattern("EE")
                .pattern("EEE")
                .unlockedBy("has_glowshroom_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ECBlocks.GLOWSHROOM_PLANKS.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ECBlocks.GLOWSHROOM_SLAB.get(), 6)
                .define('E', ECBlocks.GLOWSHROOM_PLANKS.get())
                .pattern("EEE")
                .unlockedBy("has_glowshroom_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ECBlocks.GLOWSHROOM_PLANKS.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ECBlocks.GLOWSHROOM_PRESSURE_PLATE.get(), 1)
                .define('E', ECBlocks.GLOWSHROOM_PLANKS.get())
                .pattern("EE")
                .unlockedBy("has_glowshroom_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ECBlocks.GLOWSHROOM_PLANKS.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ECBlocks.GLOWSHROOM_FENCE.get(), 3)
                .define('E', ECBlocks.GLOWSHROOM_PLANKS.get())
                .define('S', Items.STICK)
                .pattern("ESE")
                .pattern("ESE")
                .unlockedBy("has_glowshroom_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ECBlocks.GLOWSHROOM_PLANKS.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ECBlocks.GLOWSHROOM_FENCE_GATE.get(), 1)
                .define('E', ECBlocks.GLOWSHROOM_PLANKS.get())
                .define('S', Items.STICK)
                .pattern("SES")
                .pattern("SES")
                .unlockedBy("has_glowshroom_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ECBlocks.GLOWSHROOM_PLANKS.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(ECBlocks.GLOWSHROOM_BUTTON.get())
                .requires(ECBlocks.GLOWSHROOM_STEM.get())
                .unlockedBy("has_glowshroom_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ECBlocks.GLOWSHROOM_PLANKS.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ECItems.GLOWSHROOM_SIGN.get(), 1)
                .define('E', ECBlocks.GLOWSHROOM_PLANKS.get())
                .define('S', Items.STICK)
                .pattern("EEE")
                .pattern("EEE")
                .pattern(" S ")
                .unlockedBy("has_glowshroom_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ECBlocks.GLOWSHROOM_PLANKS.get()).build()))
                .save(pFinishedRecipeConsumer);

//        ShapedRecipeBuilder.shaped(ECItems.GLOWSHROOM_BOAT_ITEM.get(), 2)
//                .define('E', ECBlocks.GLOWSHROOM_PLANKS.get())
//                .pattern("E E")
//                .pattern("EEE")
//                .unlockedBy("in_water", insideOf(Blocks.WATER))
//                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ECBlocks.GLOWSHROOM_TRAPDOOR.get(), 2)
                .define('E', ECBlocks.GLOWSHROOM_PLANKS.get())
                .pattern("EEE")
                .pattern("EEE")
                .unlockedBy("has_glowshroom_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ECBlocks.GLOWSHROOM_PLANKS.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ECBlocks.GLOWSHROOM_DOOR.get(), 3)
                .define('E', ECBlocks.GLOWSHROOM_PLANKS.get())
                .pattern("EE")
                .pattern("EE")
                .pattern("EE")
                .unlockedBy("has_glowshroom_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ECBlocks.GLOWSHROOM_PLANKS.get()).build()))
                .save(pFinishedRecipeConsumer);
    }


}
