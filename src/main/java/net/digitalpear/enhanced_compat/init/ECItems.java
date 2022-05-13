package net.digitalpear.enhanced_compat.init;

import gg.moonflower.pollen.api.item.PollinatedBoatItem;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.digitalpear.enhanced_compat.EnhancedCompatMod;
import net.minecraft.core.Registry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ECItems {
    public static final PollinatedRegistry<Item> POLLEN_ITEMS = PollinatedRegistry.create(Registry.ITEM, EnhancedCompatMod.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EnhancedCompatMod.MOD_ID);

    public static final Supplier<Item> GLOWSHROOM_BOAT_ITEM = ITEMS.register("glowshroom_boat", () -> new PollinatedBoatItem(ECEntities.GLOWSHROOM_BOAT, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_TRANSPORTATION)));
    public static final RegistryObject<Item> GLOWSHROOM_SIGN = ITEMS.register("glowshroom_sign",
            () -> new SignItem(new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS).stacksTo(16),
                    ECBlocks.GLOWSHROOM_SIGN.get(), ECBlocks.GLOWSHROOM_WALL_SIGN.get()));

    public static void init(IEventBus bus){
        ITEMS.register(bus);
    }
}
