package dev.mateie.mcframe.datagen;

import dev.mateie.mcframe.MCFrame;
import dev.mateie.mcframe.item.Items;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MCFrame.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        Items.ITEMS.getEntries().forEach(this::simpleItem);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(
                item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MCFrame.MOD_ID, "item/" + item.getId().getPath()));
    }
}
