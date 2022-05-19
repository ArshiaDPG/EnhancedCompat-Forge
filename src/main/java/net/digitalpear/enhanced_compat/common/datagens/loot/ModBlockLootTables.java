package net.digitalpear.enhanced_compat.common.datagens.loot;

import net.digitalpear.enhanced_compat.init.ECBlocks;
import net.digitalpear.enhanced_compat.init.ECItems;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot{
    @Override
    protected void addTables(){
        this.dropSelf(ECBlocks.GLOWSHROOM_PLANKS.get());
        this.dropSelf(ECBlocks.GLOWSHROOM_STAIRS.get());
        this.add(ECBlocks.GLOWSHROOM_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ECBlocks.GLOWSHROOM_STEM.get());
        this.dropSelf(ECBlocks.STRIPPED_GLOWSHROOM_STEM.get());
        this.dropSelf(ECBlocks.GLOWSHROOM_HYPHAE.get());
        this.dropSelf(ECBlocks.STRIPPED_GLOWSHROOM_HYPHAE.get());
        this.dropSelf(ECBlocks.GLOWSHROOM_FENCE.get());
        this.dropSelf(ECBlocks.GLOWSHROOM_FENCE_GATE.get());
        this.dropSelf(ECBlocks.GLOWSHROOM_PRESSURE_PLATE.get());
        this.dropSelf(ECBlocks.GLOWSHROOM_BUTTON.get());
        this.dropSelf(ECBlocks.GLOWSHROOM_TRAPDOOR.get());
        this.add(ECBlocks.GLOWSHROOM_DOOR.get(), BlockLoot::createDoorTable);
        this.dropOther(ECBlocks.GLOWSHROOM_SIGN.get(), ECItems.GLOWSHROOM_SIGN.get());
        this.dropOther(ECBlocks.GLOWSHROOM_WALL_SIGN.get(), ECItems.GLOWSHROOM_SIGN.get());

        this.dropSelf(ECBlocks.TOADSTOOL_PLANKS.get());
        this.dropSelf(ECBlocks.TOADSTOOL_STAIRS.get());
        this.add(ECBlocks.TOADSTOOL_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ECBlocks.TOADSTOOL_STEM.get());
        this.dropSelf(ECBlocks.STRIPPED_TOADSTOOL_STEM.get());
        this.dropSelf(ECBlocks.TOADSTOOL_HYPHAE.get());
        this.dropSelf(ECBlocks.STRIPPED_TOADSTOOL_HYPHAE.get());
        this.dropSelf(ECBlocks.TOADSTOOL_FENCE.get());
        this.dropSelf(ECBlocks.TOADSTOOL_FENCE_GATE.get());
        this.dropSelf(ECBlocks.TOADSTOOL_PRESSURE_PLATE.get());
        this.dropSelf(ECBlocks.TOADSTOOL_BUTTON.get());
        this.dropSelf(ECBlocks.TOADSTOOL_TRAPDOOR.get());
        this.add(ECBlocks.TOADSTOOL_DOOR.get(), BlockLoot::createDoorTable);
        this.dropOther(ECBlocks.TOADSTOOL_SIGN.get(), ECItems.TOADSTOOL_SIGN.get());
        this.dropOther(ECBlocks.TOADSTOOL_WALL_SIGN.get(), ECItems.TOADSTOOL_SIGN.get());
    }

    //Add all blocks into list of blocks
    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ECBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
