package net.digitalpear.enhanced_compat.common.datagens;

import net.digitalpear.enhanced_compat.EnhancedCompatMod;
import net.digitalpear.enhanced_compat.init.ECItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, EnhancedCompatMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ECItems.GLOWSHROOM_BOAT_ITEM.get());
        simpleItem(ECItems.TOADSTOOL_BOAT_ITEM.get());
        simpleItem(ECItems.GLOWSHROOM_SIGN.get());
        simpleItem(ECItems.TOADSTOOL_SIGN.get());


    }
    private ItemModelBuilder simpleItem(Item item) {
        return withExistingParent(item.getRegistryName().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(EnhancedCompatMod.MOD_ID,"item/" + item.getRegistryName().getPath()));
    }
}
