package net.digitalpear.enhanced_compat.init;

import net.digitalpear.enhanced_compat.EnhancedCompatMod;
import net.digitalpear.enhanced_compat.common.features.bop.GiantGlowshroomFeatureOverride;
import net.digitalpear.enhanced_compat.common.features.bop.HugeGlowshroomFeatureOverride;
import net.digitalpear.enhanced_compat.common.features.bop.MediumGlowshroomFeatureOverride;
import net.digitalpear.enhanced_compat.common.features.bop.SmallGlowshroomFeatureOverride;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;


@SuppressWarnings("unused")
public class ECFeatures {
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> GIANT_GLOWSHROOM = FeatureUtils.register(id("giant_glowshroom"), new GiantGlowshroomFeatureOverride(NoneFeatureConfiguration.CODEC));
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> HUGE_GLOWSHROOM = FeatureUtils.register(id("huge_glowshroom"), new HugeGlowshroomFeatureOverride(NoneFeatureConfiguration.CODEC));
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> MEDIUM_GLOWSHROOM = FeatureUtils.register(id("medium_glowshroom"), new MediumGlowshroomFeatureOverride(NoneFeatureConfiguration.CODEC));
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> SMALL_GLOWSHROOM = FeatureUtils.register(id("small_glowshroom"), new SmallGlowshroomFeatureOverride(NoneFeatureConfiguration.CODEC));


    public static String id(String id){
        return EnhancedCompatMod.MOD_ID + ":" + id;
    }
    public static void init(){}


}
