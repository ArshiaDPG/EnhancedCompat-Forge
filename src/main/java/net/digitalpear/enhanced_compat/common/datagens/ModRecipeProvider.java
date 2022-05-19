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
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {

        createPlankRecipe("glowshroom", ECBlocks.GLOWSHROOM_PLANKS.get(), ECTags.GLOWSHROOM_STEMS, pFinishedRecipeConsumer);
        createPlankRecipe("toadstool", ECBlocks.TOADSTOOL_PLANKS.get(), ECTags.TOADSTOOL_STEMS, pFinishedRecipeConsumer);

        createHyephaeRecipe("glowshroom", ECBlocks.GLOWSHROOM_STEM.get(), ECBlocks.GLOWSHROOM_HYPHAE.get(), pFinishedRecipeConsumer);
        createHyephaeRecipe("toadstool", ECBlocks.TOADSTOOL_STEM.get(), ECBlocks.TOADSTOOL_HYPHAE.get(), pFinishedRecipeConsumer);

        createHyephaeRecipe("stripped_glowshroom", ECBlocks.STRIPPED_GLOWSHROOM_STEM.get(), ECBlocks.STRIPPED_GLOWSHROOM_HYPHAE.get(), pFinishedRecipeConsumer);
        createHyephaeRecipe("stripped_toadstool", ECBlocks.STRIPPED_TOADSTOOL_STEM.get(), ECBlocks.STRIPPED_TOADSTOOL_HYPHAE.get(), pFinishedRecipeConsumer);

        createStairsRecipe("glowshroom", ECBlocks.GLOWSHROOM_STAIRS.get(), ECBlocks.GLOWSHROOM_PLANKS.get(), pFinishedRecipeConsumer);
        createStairsRecipe("toadstool", ECBlocks.TOADSTOOL_STAIRS.get(), ECBlocks.TOADSTOOL_PLANKS.get(), pFinishedRecipeConsumer);

        createSlabRecipe("glowshroom", ECBlocks.GLOWSHROOM_SLAB.get(), ECBlocks.GLOWSHROOM_PLANKS.get(), pFinishedRecipeConsumer);
        createSlabRecipe("toadstool", ECBlocks.TOADSTOOL_SLAB.get(), ECBlocks.TOADSTOOL_PLANKS.get(), pFinishedRecipeConsumer);

        createPressurePlateRecipe("glowshroom", ECBlocks.GLOWSHROOM_PRESSURE_PLATE.get(), ECBlocks.GLOWSHROOM_PLANKS.get(), pFinishedRecipeConsumer);
        createPressurePlateRecipe("toadstool", ECBlocks.TOADSTOOL_PRESSURE_PLATE.get(), ECBlocks.TOADSTOOL_PLANKS.get(), pFinishedRecipeConsumer);

        createFenceRecipe("glowshroom", ECBlocks.GLOWSHROOM_FENCE.get(), ECBlocks.GLOWSHROOM_PLANKS.get(), pFinishedRecipeConsumer);
        createFenceRecipe("toadstool", ECBlocks.TOADSTOOL_FENCE.get(), ECBlocks.TOADSTOOL_PLANKS.get(), pFinishedRecipeConsumer);

        createFenceGateRecipe("glowshroom", ECBlocks.GLOWSHROOM_FENCE_GATE.get(), ECBlocks.GLOWSHROOM_PLANKS.get(), pFinishedRecipeConsumer);
        createFenceGateRecipe("toadstool", ECBlocks.TOADSTOOL_FENCE_GATE.get(), ECBlocks.TOADSTOOL_PLANKS.get(), pFinishedRecipeConsumer);

        createButtonRecipe("glowshroom", ECBlocks.GLOWSHROOM_BUTTON.get(), ECBlocks.GLOWSHROOM_PLANKS.get(), pFinishedRecipeConsumer);
        createButtonRecipe("toadstool", ECBlocks.TOADSTOOL_BUTTON.get(), ECBlocks.TOADSTOOL_PLANKS.get(), pFinishedRecipeConsumer);

        createSignRecipe("glowshroom", ECItems.GLOWSHROOM_SIGN.get(), ECBlocks.GLOWSHROOM_PLANKS.get(), pFinishedRecipeConsumer);
        createSignRecipe("toadstool", ECItems.TOADSTOOL_SIGN.get(), ECBlocks.TOADSTOOL_PLANKS.get(), pFinishedRecipeConsumer);

        createBoatRecipe(ECItems.GLOWSHROOM_BOAT_ITEM.get(), ECBlocks.GLOWSHROOM_PLANKS.get(), pFinishedRecipeConsumer);
        createBoatRecipe(ECItems.TOADSTOOL_BOAT_ITEM.get(), ECBlocks.TOADSTOOL_PLANKS.get(), pFinishedRecipeConsumer);

        createTrapdoorRecipe("glowshroom", ECBlocks.GLOWSHROOM_TRAPDOOR.get(), ECBlocks.GLOWSHROOM_PLANKS.get(), pFinishedRecipeConsumer);
        createTrapdoorRecipe("toadstool", ECBlocks.TOADSTOOL_TRAPDOOR.get(), ECBlocks.TOADSTOOL_PLANKS.get(), pFinishedRecipeConsumer);

        createDoorRecipe("glowshroom", ECBlocks.GLOWSHROOM_DOOR.get(), ECBlocks.GLOWSHROOM_PLANKS.get(), pFinishedRecipeConsumer);
        createDoorRecipe("toadstool", ECBlocks.TOADSTOOL_DOOR.get(), ECBlocks.TOADSTOOL_PLANKS.get(), pFinishedRecipeConsumer);

    }

    public static void createPlankRecipe(String woodName, ItemLike resultItem, TagKey<Item> neededItem, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        ShapelessRecipeBuilder.shapeless(resultItem)
                .requires(neededItem)
                .group("planks")
                .unlockedBy("has_" + woodName +"_stem", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(neededItem).build()))
                .save(pFinishedRecipeConsumer);
    }
    public static void createHyephaeRecipe(String woodName, ItemLike resultItem, ItemLike neededItem, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        ShapelessRecipeBuilder.shapeless(resultItem)
                .requires(neededItem)
                .group("hyphae")
                .unlockedBy("has_" + woodName +"_stem", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(neededItem).build()))
                .save(pFinishedRecipeConsumer);
    }
    public static void createStairsRecipe(String woodName, ItemLike resultItem, ItemLike neededItem, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        ShapedRecipeBuilder.shaped(resultItem, 4)
                .define('E', neededItem)
                .pattern("E  ")
                .pattern("EE ")
                .pattern("EEE")
                .unlockedBy("has_"+ woodName +"_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(neededItem).build()))
                .save(pFinishedRecipeConsumer);
    }
    public static void createSlabRecipe(String woodName, ItemLike resultItem, ItemLike neededItem, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        ShapedRecipeBuilder.shaped(resultItem, 6)
                .define('E', neededItem)
                .pattern("EEE")
                .unlockedBy("has_"+woodName+"_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(neededItem).build()))
                .save(pFinishedRecipeConsumer);
    }

    public static void createPressurePlateRecipe(String woodName, ItemLike resultItem, ItemLike neededItem, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        ShapedRecipeBuilder.shaped(resultItem, 1)
                .define('E', neededItem)
                .pattern("EE")
                .unlockedBy("has_"+woodName+"_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(neededItem).build()))
                .save(pFinishedRecipeConsumer);
    }
    public static void createFenceRecipe(String woodName, ItemLike resultItem, ItemLike neededItem, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        ShapedRecipeBuilder.shaped(resultItem, 3)
                .define('E', neededItem)
                .define('S', Items.STICK)
                .pattern("ESE")
                .pattern("ESE")
                .unlockedBy("has_"+woodName+"_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(neededItem).build()))
                .save(pFinishedRecipeConsumer);
    }

    public static void createFenceGateRecipe(String woodName, ItemLike resultItem, ItemLike neededItem, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        ShapedRecipeBuilder.shaped(resultItem, 1)
                .define('E', neededItem)
                .define('S', Items.STICK)
                .pattern("SES")
                .pattern("SES")
                .unlockedBy("has_"+woodName+"_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(neededItem).build()))
                .save(pFinishedRecipeConsumer);
    }
    public static void createButtonRecipe(String woodName, ItemLike resultItem, ItemLike neededItem, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        ShapelessRecipeBuilder.shapeless(resultItem)
                .requires(neededItem)
                .unlockedBy("has_" + woodName +"_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(neededItem).build()))
                .save(pFinishedRecipeConsumer);
    }
    public static void createSignRecipe(String woodName, ItemLike resultItem, ItemLike neededItem, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        ShapedRecipeBuilder.shaped(resultItem, 3)
                .define('E', neededItem)
                .define('S', Items.STICK)
                .pattern("EEE")
                .pattern("EEE")
                .pattern(" S ")
                .unlockedBy("has_" + woodName +"_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(neededItem).build()))
                .save(pFinishedRecipeConsumer);
    }
    public static void createBoatRecipe(ItemLike resultItem, ItemLike neededItem, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        ShapedRecipeBuilder.shaped(resultItem, 1)
                .define('E', neededItem)
                .pattern("E E")
                .pattern("EEE")
                .unlockedBy("in_water", insideOf(Blocks.WATER))
                .save(pFinishedRecipeConsumer);
    }
    public static void createTrapdoorRecipe(String woodName, ItemLike resultItem, ItemLike neededItem, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        ShapedRecipeBuilder.shaped(resultItem, 2)
                .define('E', neededItem)
                .pattern("EEE")
                .pattern("EEE")
                .unlockedBy("has_"+woodName+"_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(neededItem).build()))
                .save(pFinishedRecipeConsumer);
    }
    public static void createDoorRecipe(String woodName, ItemLike resultItem, ItemLike neededItem, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        ShapedRecipeBuilder.shaped(resultItem, 3)
                .define('E', neededItem)
                .pattern("EE")
                .pattern("EE")
                .pattern("EE")
                .unlockedBy("has_"+woodName+"_planks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(neededItem).build()))
                .save(pFinishedRecipeConsumer);
    }
}
