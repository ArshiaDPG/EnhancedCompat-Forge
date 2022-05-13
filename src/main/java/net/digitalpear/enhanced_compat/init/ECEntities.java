package net.digitalpear.enhanced_compat.init;

import gg.moonflower.pollen.api.PollenRegistries;
import gg.moonflower.pollen.api.entity.PollinatedBoatType;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.digitalpear.enhanced_compat.EnhancedCompatMod;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public class ECEntities {
    public static final PollinatedRegistry<PollinatedBoatType> BOATS = PollinatedRegistry.create(PollenRegistries.BOAT_TYPE_REGISTRY, EnhancedCompatMod.MOD_ID);

    public static final Supplier<PollinatedBoatType> GLOWSHROOM_BOAT = BOATS.register("glowshroom_boat", () -> new PollinatedBoatType(new ResourceLocation(EnhancedCompatMod.MOD_ID, "textures/entity/boat/glowshroom.png")));
}
