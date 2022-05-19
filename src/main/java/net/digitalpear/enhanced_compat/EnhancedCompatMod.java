package net.digitalpear.enhanced_compat;

import net.digitalpear.enhanced_compat.common.block.entity.ModWoodTypes;
import net.digitalpear.enhanced_compat.init.ECBlocks;
import net.digitalpear.enhanced_compat.init.ECData;
import net.digitalpear.enhanced_compat.init.ECItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EnhancedCompatMod.MOD_ID)
public class EnhancedCompatMod {
    public static final String MOD_ID = "enhanced_compat";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();


    public EnhancedCompatMod() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the setup method for modloading

        ECBlocks.init(bus);
        ECItems.init(bus);

        bus.addListener(this::setup);
        bus.addListener(this::clientSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ECData.registerFlammables();
            ECData.registerStrippables();
            Sheets.addWoodType(ModWoodTypes.GLOWSHROOM);
            Sheets.addWoodType(ModWoodTypes.TOADSTOOL);
        });
    }

    private void clientSetup(final FMLClientSetupEvent event){
        ItemBlockRenderTypes.setRenderLayer(ECBlocks.GLOWSHROOM_DOOR.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ECBlocks.GLOWSHROOM_TRAPDOOR.get(), RenderType.cutoutMipped());

        WoodType.register(ModWoodTypes.GLOWSHROOM);
        WoodType.register(ModWoodTypes.TOADSTOOL);
        BlockEntityRenderers.register(ECBlocks.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
    }

}
