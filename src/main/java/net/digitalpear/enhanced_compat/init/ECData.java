package net.digitalpear.enhanced_compat.init;


import gg.moonflower.pollen.api.registry.StrippingRegistry;
import gg.moonflower.pollen.api.registry.content.FlammabilityRegistry;

public class ECData {
    public static void registerFlammables() {
        //Glowshrooms
        FlammabilityRegistry.register(ECBlocks.GLOWSHROOM_STEM.get(), 5, 5);
        FlammabilityRegistry.register(ECBlocks.GLOWSHROOM_HYPHAE.get(), 5, 5);
        FlammabilityRegistry.register(ECBlocks.STRIPPED_GLOWSHROOM_STEM.get(), 5, 5);
        FlammabilityRegistry.register(ECBlocks.STRIPPED_GLOWSHROOM_HYPHAE.get(), 5, 5);
        FlammabilityRegistry.register(ECBlocks.GLOWSHROOM_PLANKS.get(), 5, 20);
        FlammabilityRegistry.register(ECBlocks.GLOWSHROOM_SLAB.get(), 5, 20);
        FlammabilityRegistry.register(ECBlocks.GLOWSHROOM_STAIRS.get(), 5, 20);
        FlammabilityRegistry.register(ECBlocks.GLOWSHROOM_FENCE.get(), 5, 20);
        FlammabilityRegistry.register(ECBlocks.GLOWSHROOM_FENCE_GATE.get(), 5, 20);

        //Toadstools
        FlammabilityRegistry.register(ECBlocks.TOADSTOOL_STEM.get(), 5, 5);
        FlammabilityRegistry.register(ECBlocks.TOADSTOOL_HYPHAE.get(), 5, 5);
        FlammabilityRegistry.register(ECBlocks.STRIPPED_TOADSTOOL_STEM.get(), 5, 5);
        FlammabilityRegistry.register(ECBlocks.STRIPPED_TOADSTOOL_HYPHAE.get(), 5, 5);
        FlammabilityRegistry.register(ECBlocks.TOADSTOOL_PLANKS.get(), 5, 20);
        FlammabilityRegistry.register(ECBlocks.TOADSTOOL_SLAB.get(), 5, 20);
        FlammabilityRegistry.register(ECBlocks.TOADSTOOL_STAIRS.get(), 5, 20);
        FlammabilityRegistry.register(ECBlocks.TOADSTOOL_FENCE.get(), 5, 20);
        FlammabilityRegistry.register(ECBlocks.TOADSTOOL_FENCE_GATE.get(), 5, 20);
    }

    public static void registerStrippables() {
        StrippingRegistry.register(ECBlocks.GLOWSHROOM_STEM.get(), ECBlocks.STRIPPED_GLOWSHROOM_STEM.get());
        StrippingRegistry.register(ECBlocks.GLOWSHROOM_HYPHAE.get(), ECBlocks.STRIPPED_GLOWSHROOM_HYPHAE.get());

        StrippingRegistry.register(ECBlocks.TOADSTOOL_STEM.get(), ECBlocks.STRIPPED_TOADSTOOL_STEM.get());
        StrippingRegistry.register(ECBlocks.TOADSTOOL_HYPHAE.get(), ECBlocks.STRIPPED_TOADSTOOL_HYPHAE.get());
    }
}
