package net.digitalpear.enhanced_compat.init;

import net.digitalpear.enhanced_compat.EnhancedCompatMod;
import net.digitalpear.enhanced_compat.common.block.ModStandingSignBlock;
import net.digitalpear.enhanced_compat.common.block.ModWallSignBlock;
import net.digitalpear.enhanced_compat.common.entity.ModSignBlockEntity;
import net.digitalpear.enhanced_compat.common.entity.ModWoodTypes;
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

    public static final MaterialColor GLOWSHROOM_COLOR = MaterialColor.COLOR_BLUE;
    public static final MaterialColor GLOWSHROOM_SIDE_COLOR = MaterialColor.COLOR_LIGHT_BLUE;
    public static final int glowshroomLight = 6;

    public static BlockBehaviour.Properties createGlowshroomMaterial(MaterialColor color){
        return BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).color(color).lightLevel((state) -> glowshroomLight);
    }
    private static RotatedPillarBlock createGlowshroomStem(MaterialColor p_50789_, MaterialColor p_50790_) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD,
                (p_152624_) -> p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? p_50789_ : p_50790_)
                .strength(2.0F).sound(SoundType.WOOD).lightLevel((state) -> glowshroomLight));
    }


    public static final RegistryObject<Block> GLOWSHROOM_STEM = registerBlock("glowshroom_stem",
            () -> createGlowshroomStem(GLOWSHROOM_COLOR, GLOWSHROOM_SIDE_COLOR), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_GLOWSHROOM_STEM = registerBlock("stripped_glowshroom_stem",
            () -> createGlowshroomStem(GLOWSHROOM_COLOR, GLOWSHROOM_COLOR), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> GLOWSHROOM_HYPHAE = registerBlock("glowshroom_hyphae",
            () -> createGlowshroomStem(GLOWSHROOM_SIDE_COLOR, GLOWSHROOM_SIDE_COLOR), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_GLOWSHROOM_HYPHAE = registerBlock("stripped_glowshroom_hyphae",
            () -> createGlowshroomStem(GLOWSHROOM_COLOR, GLOWSHROOM_COLOR), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> GLOWSHROOM_PLANKS = registerBlock("glowshroom_planks",
            () -> new Block(createGlowshroomMaterial(GLOWSHROOM_COLOR)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> GLOWSHROOM_SLAB = registerBlock("glowshroom_slab",
            () -> new SlabBlock(createGlowshroomMaterial(GLOWSHROOM_COLOR)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> GLOWSHROOM_STAIRS = registerBlock("glowshroom_stairs",
            () -> new StairBlock(() -> GLOWSHROOM_PLANKS.get().defaultBlockState(), createGlowshroomMaterial(GLOWSHROOM_COLOR)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> GLOWSHROOM_PRESSURE_PLATE = registerBlock("glowshroom_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING , createGlowshroomMaterial(GLOWSHROOM_COLOR)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> GLOWSHROOM_FENCE = registerBlock("glowshroom_fence",
            () -> new FenceBlock(createGlowshroomMaterial(GLOWSHROOM_COLOR)), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> GLOWSHROOM_FENCE_GATE = registerBlock("glowshroom_fence_gate",
            () -> new FenceGateBlock(createGlowshroomMaterial(GLOWSHROOM_COLOR)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> GLOWSHROOM_BUTTON = registerBlock("glowshroom_button",
            () -> new WoodButtonBlock(createGlowshroomMaterial(GLOWSHROOM_COLOR)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> GLOWSHROOM_TRAPDOOR = registerBlock("glowshroom_trapdoor",
            () -> new TrapDoorBlock(createGlowshroomMaterial(GLOWSHROOM_COLOR).noOcclusion()), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> GLOWSHROOM_DOOR = registerBlock("glowshroom_door",
            () -> new DoorBlock(createGlowshroomMaterial(GLOWSHROOM_COLOR).noOcclusion()), CreativeModeTab.TAB_REDSTONE);

    public static final RegistryObject<Block> GLOWSHROOM_WALL_SIGN = registerBlockWithoutBlockItem("glowshroom_door_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.GLOWSHROOM));

    public static final RegistryObject<Block> GLOWSHROOM_SIGN = registerBlockWithoutBlockItem("glowshroom_door_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.GLOWSHROOM));

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> SIGN_BLOCK_ENTITIES =
            BLOCK_ENTITIES.register("sign_block_entity", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            ECBlocks.GLOWSHROOM_WALL_SIGN.get(),
                            ECBlocks.GLOWSHROOM_SIGN.get()).build(null));


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
    }
}
