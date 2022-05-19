package net.digitalpear.enhanced_compat.init;

import net.digitalpear.enhanced_compat.EnhancedCompatMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ECTags {
    public static final TagKey<Item> TOADSTOOL_STEMS = bind("toadstool_stems");
    public static final TagKey<Item> GLOWSHROOM_STEMS = bind("glowshroom_stems");


    private static TagKey<Item> bindItem(String name) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(EnhancedCompatMod.MOD_ID, name));
    }

    private static TagKey<Block> bindBlock(String name) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(EnhancedCompatMod.MOD_ID, name));
    }

    private static TagKey<Item> bind(String name) {
        bindBlock(name);
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(EnhancedCompatMod.MOD_ID, name));
    }
}
