package net.digitalpear.enhanced_compat.common.datagens.loot;

import net.digitalpear.enhanced_compat.init.ECBlocks;
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
        this.dropSelf(ECBlocks.GLOWSHROOM_SIGN.get());
    }

    //Add all blocks into list of blocks
    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ECBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
