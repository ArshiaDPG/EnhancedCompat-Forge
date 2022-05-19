package net.digitalpear.enhanced_compat.init;

import biomesoplenty.api.block.BOPBlocks;
import com.teamaurora.enhanced_mushrooms.core.registry.EMBlocks;
import net.digitalpear.enhanced_compat.EnhancedCompatMod;
import net.digitalpear.enhanced_compat.common.block.ModStandingSignBlock;
import net.digitalpear.enhanced_compat.common.block.ModWallSignBlock;
import net.digitalpear.enhanced_compat.common.block.entity.ModSignBlockEntity;
import net.digitalpear.enhanced_compat.common.block.entity.ModWoodTypes;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ECBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EnhancedCompatMod.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, EnhancedCompatMod.MOD_ID);

    //Default values for Glowshroom blocks
    public static final MaterialColor GLOWSHROOM_COLOR = MaterialColor.DIAMOND;
    public static final MaterialColor GLOWSHROOM_SIDE_COLOR = MaterialColor.SNOW;
    public static final int glowshroomLight = 6;

    //Default values for Toadstool blocks
    public static final MaterialColor TOADSTOOL_COLOR = MaterialColor.COLOR_ORANGE;
    public static final MaterialColor TOADSTOOL_SIDE_COLOR = MaterialColor.SNOW;

    public static BlockBehaviour.Properties createToadstoolMaterial(Block baseBlock){
        return BlockBehaviour.Properties.copy(baseBlock).color(TOADSTOOL_COLOR);
    }
    private static RotatedPillarBlock createToadstoolStem(MaterialColor p_50789_, MaterialColor p_50790_) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD,
                        (p_152624_) -> p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? p_50789_ : p_50790_)
                .strength(2.0F).sound(SoundType.STEM));
    }

    public static BlockBehaviour.Properties createGlowshroomMaterial(Block baseBlock){
        return BlockBehaviour.Properties.copy(baseBlock).color(GLOWSHROOM_COLOR).lightLevel((state) -> glowshroomLight);
    }
    private static RotatedPillarBlock createGlowshroomStem(MaterialColor p_50789_, MaterialColor p_50790_) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD,
                (p_152624_) -> p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? p_50789_ : p_50790_)
                .strength(2.0F).sound(SoundType.STEM).lightLevel((state) -> glowshroomLight));
    }

    /*
    Glowshroom Blocks
    */
    public static final RegistryObject<Block> GLOWSHROOM_STEM = registerBlock("glowshroom_stem",
            () -> createGlowshroomStem(GLOWSHROOM_COLOR, GLOWSHROOM_SIDE_COLOR), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_GLOWSHROOM_STEM = registerBlock("stripped_glowshroom_stem",
            () -> createGlowshroomStem(GLOWSHROOM_COLOR, GLOWSHROOM_COLOR), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> GLOWSHROOM_HYPHAE = registerBlock("glowshroom_hyphae",
            () -> createGlowshroomStem(GLOWSHROOM_SIDE_COLOR, GLOWSHROOM_SIDE_COLOR), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_GLOWSHROOM_HYPHAE = registerBlock("stripped_glowshroom_hyphae",
            () -> createGlowshroomStem(GLOWSHROOM_COLOR, GLOWSHROOM_COLOR), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> GLOWSHROOM_PLANKS = registerBlock("glowshroom_planks",
            () -> new Block(createGlowshroomMaterial(Blocks.WARPED_PLANKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> GLOWSHROOM_SLAB = registerBlock("glowshroom_slab",
            () -> new SlabBlock(createGlowshroomMaterial(Blocks.WARPED_SLAB)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> GLOWSHROOM_STAIRS = registerBlock("glowshroom_stairs",
            () -> new StairBlock(() -> GLOWSHROOM_PLANKS.get().defaultBlockState(), createGlowshroomMaterial(Blocks.WARPED_STAIRS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> GLOWSHROOM_PRESSURE_PLATE = registerBlock("glowshroom_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, createGlowshroomMaterial(Blocks.WARPED_PRESSURE_PLATE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> GLOWSHROOM_FENCE = registerBlock("glowshroom_fence",
            () -> new FenceBlock(createGlowshroomMaterial(Blocks.WARPED_FENCE)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> GLOWSHROOM_FENCE_GATE = registerBlock("glowshroom_fence_gate",
            () -> new FenceGateBlock(createGlowshroomMaterial(Blocks.WARPED_FENCE_GATE)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> GLOWSHROOM_BUTTON = registerBlock("glowshroom_button",
            () -> new WoodButtonBlock(createGlowshroomMaterial(Blocks.WARPED_BUTTON)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> GLOWSHROOM_TRAPDOOR = registerBlock("glowshroom_trapdoor",
            () -> new TrapDoorBlock(createGlowshroomMaterial(Blocks.WARPED_TRAPDOOR).noOcclusion()), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> GLOWSHROOM_DOOR = registerBlock("glowshroom_door",
            () -> new DoorBlock(createGlowshroomMaterial(Blocks.WARPED_DOOR).noOcclusion()), CreativeModeTab.TAB_REDSTONE);

    public static final RegistryObject<Block> GLOWSHROOM_WALL_SIGN = registerBlockWithoutBlockItem("glowshroom_wall_sign",
            () -> new ModWallSignBlock(createGlowshroomMaterial(Blocks.WARPED_WALL_SIGN), ModWoodTypes.GLOWSHROOM));
    public static final RegistryObject<Block> GLOWSHROOM_SIGN = registerBlockWithoutBlockItem("glowshroom_sign",
            () -> new ModStandingSignBlock(createGlowshroomMaterial(Blocks.WARPED_SIGN),ModWoodTypes.GLOWSHROOM));

    /*
    Toadstool Blocks
    */
    public static final RegistryObject<Block> TOADSTOOL_STEM = registerBlock("toadstool_stem",
            () -> createToadstoolStem(TOADSTOOL_COLOR, TOADSTOOL_SIDE_COLOR), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_TOADSTOOL_STEM = registerBlock("stripped_toadstool_stem",
            () -> createToadstoolStem(TOADSTOOL_COLOR, TOADSTOOL_COLOR), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> TOADSTOOL_HYPHAE = registerBlock("toadstool_hyphae",
            () -> createGlowshroomStem(TOADSTOOL_SIDE_COLOR, TOADSTOOL_SIDE_COLOR), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_TOADSTOOL_HYPHAE = registerBlock("stripped_toadstool_hyphae",
            () -> createGlowshroomStem(TOADSTOOL_COLOR, TOADSTOOL_COLOR), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> TOADSTOOL_PLANKS = registerBlock("toadstool_planks",
            () -> new Block(createToadstoolMaterial(Blocks.WARPED_PLANKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> TOADSTOOL_SLAB = registerBlock("toadstool_slab",
            () -> new SlabBlock(createToadstoolMaterial(Blocks.WARPED_SLAB)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> TOADSTOOL_STAIRS = registerBlock("toadstool_stairs",
            () -> new StairBlock(() -> TOADSTOOL_PLANKS.get().defaultBlockState(), createToadstoolMaterial(Blocks.WARPED_STAIRS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> TOADSTOOL_PRESSURE_PLATE = registerBlock("toadstool_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, createToadstoolMaterial(Blocks.WARPED_PRESSURE_PLATE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> TOADSTOOL_FENCE = registerBlock("toadstool_fence",
            () -> new FenceBlock(createToadstoolMaterial(Blocks.WARPED_FENCE)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> TOADSTOOL_FENCE_GATE = registerBlock("toadstool_fence_gate",
            () -> new FenceGateBlock(createToadstoolMaterial(Blocks.WARPED_FENCE_GATE)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> TOADSTOOL_BUTTON = registerBlock("toadstool_button",
            () -> new WoodButtonBlock(createToadstoolMaterial(Blocks.WARPED_BUTTON)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> TOADSTOOL_TRAPDOOR = registerBlock("toadstool_trapdoor",
            () -> new TrapDoorBlock(createToadstoolMaterial(Blocks.WARPED_TRAPDOOR).noOcclusion()), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> TOADSTOOL_DOOR = registerBlock("toadstool_door",
            () -> new DoorBlock(createToadstoolMaterial(Blocks.WARPED_DOOR).noOcclusion()), CreativeModeTab.TAB_REDSTONE);

    public static final RegistryObject<Block> TOADSTOOL_WALL_SIGN = registerBlockWithoutBlockItem("toadstool_wall_sign",
            () -> new ModWallSignBlock(createToadstoolMaterial(Blocks.WARPED_WALL_SIGN), ModWoodTypes.TOADSTOOL));
    public static final RegistryObject<Block> TOADSTOOL_SIGN = registerBlockWithoutBlockItem("toadstool_sign",
            () -> new ModStandingSignBlock(createToadstoolMaterial(Blocks.WARPED_SIGN), ModWoodTypes.TOADSTOOL));



    //Register sign block entities
    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> SIGN_BLOCK_ENTITIES =
            BLOCK_ENTITIES.register("sign_block_entity", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            ECBlocks.GLOWSHROOM_WALL_SIGN.get(),
                            ECBlocks.GLOWSHROOM_SIGN.get(),
                            ECBlocks.TOADSTOOL_WALL_SIGN.get(),
                            ECBlocks.TOADSTOOL_SIGN.get()).build(null));







    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                     CreativeModeTab tab, String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltipKey);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab, String tooltipKey) {
        return ECItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ECItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void init(IEventBus bus){
        BLOCKS.register(bus);
        BLOCK_ENTITIES.register(bus);
    }
}
