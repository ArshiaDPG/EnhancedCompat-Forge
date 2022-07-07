package net.digitalpear.enhanced_compat.common.datagens;


import net.digitalpear.enhanced_compat.EnhancedCompatMod;
import net.digitalpear.enhanced_compat.init.ECBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public static final Block GLOWSHROOM = ECBlocks.GLOWSHROOM_PLANKS.get();
    public static final Block TOADSTOOL = ECBlocks.TOADSTOOL_PLANKS.get();
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, EnhancedCompatMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ECBlocks.GLOWSHROOM_PLANKS.get());
        simpleBlock(ECBlocks.TOADSTOOL_PLANKS.get());

        logBlock((RotatedPillarBlock) ECBlocks.GLOWSHROOM_STEM.get());
        logBlock((RotatedPillarBlock) ECBlocks.TOADSTOOL_STEM.get());
        logBlock((RotatedPillarBlock) ECBlocks.STRIPPED_GLOWSHROOM_STEM.get());
        logBlock((RotatedPillarBlock) ECBlocks.STRIPPED_TOADSTOOL_STEM.get());

        hyphaeBlock((RotatedPillarBlock) ECBlocks.GLOWSHROOM_STEM.get());
        hyphaeBlock((RotatedPillarBlock) ECBlocks.TOADSTOOL_STEM.get());
        hyphaeBlock((RotatedPillarBlock) ECBlocks.STRIPPED_GLOWSHROOM_STEM.get());
        hyphaeBlock((RotatedPillarBlock) ECBlocks.STRIPPED_TOADSTOOL_STEM.get());

        stairsBlock((StairBlock) ECBlocks.GLOWSHROOM_STAIRS.get(), blockTexture(GLOWSHROOM));
        stairsBlock((StairBlock) ECBlocks.TOADSTOOL_STAIRS.get(), blockTexture(TOADSTOOL));

        slabBlock((SlabBlock)ECBlocks.GLOWSHROOM_SLAB.get(), blockTexture(GLOWSHROOM), blockTexture(GLOWSHROOM));
        slabBlock((SlabBlock)ECBlocks.TOADSTOOL_SLAB.get(), blockTexture(TOADSTOOL), blockTexture(TOADSTOOL));

        buttonBlock((ButtonBlock) ECBlocks.GLOWSHROOM_BUTTON.get(), blockTexture(GLOWSHROOM));
        buttonBlock((ButtonBlock) ECBlocks.TOADSTOOL_BUTTON.get(), blockTexture(TOADSTOOL));

        fenceBlock((FenceBlock) ECBlocks.TOADSTOOL_FENCE.get(), blockTexture(GLOWSHROOM));
        fenceBlock((FenceBlock) ECBlocks.TOADSTOOL_FENCE.get(), blockTexture(TOADSTOOL));

        fenceGateBlock((FenceGateBlock) ECBlocks.TOADSTOOL_FENCE_GATE.get(), blockTexture(GLOWSHROOM));
        fenceGateBlock((FenceGateBlock) ECBlocks.TOADSTOOL_FENCE_GATE.get(), blockTexture(TOADSTOOL));

        signBlock((StandingSignBlock) ECBlocks.GLOWSHROOM_SIGN.get(),(WallSignBlock) ECBlocks.GLOWSHROOM_WALL_SIGN.get(), blockTexture(ECBlocks.GLOWSHROOM_SIGN.get()));
        signBlock((StandingSignBlock) ECBlocks.TOADSTOOL_SIGN.get(),(WallSignBlock) ECBlocks.TOADSTOOL_WALL_SIGN.get(), blockTexture(ECBlocks.TOADSTOOL_SIGN.get()));

        trapdoorBlock((TrapDoorBlock) ECBlocks.GLOWSHROOM_TRAPDOOR.get(),blockTexture(ECBlocks.GLOWSHROOM_TRAPDOOR.get()), true);
        trapdoorBlock((TrapDoorBlock) ECBlocks.TOADSTOOL_TRAPDOOR.get(),blockTexture(ECBlocks.TOADSTOOL_TRAPDOOR.get()), true);

        doorBlock((DoorBlock) ECBlocks.GLOWSHROOM_DOOR.get(), blockTexture(ECBlocks.GLOWSHROOM_DOOR.get()), blockTexture(GLOWSHROOM));
        doorBlock((DoorBlock) ECBlocks.TOADSTOOL_DOOR.get(), blockTexture(ECBlocks.TOADSTOOL_DOOR.get()), blockTexture(TOADSTOOL));

    }
    public void hyphaeBlock(RotatedPillarBlock block) {
        axisBlock(block, blockTexture(block), blockTexture(block));
    }
}