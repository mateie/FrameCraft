package dev.mateie.framecraft.item;

import dev.mateie.framecraft.FrameCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeModeTabs {
    public static final DeferredRegister<net.minecraft.world.item.CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FrameCraft.MOD_ID);

    public static final RegistryObject<net.minecraft.world.item.CreativeModeTab> FRAMECRAFT_TAB = CREATIVE_MODE_TABS.register("framecraft_tab",
            () -> net.minecraft.world.item.CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.FERRITE.get()))
                    .title(Component.translatable("creativetab.framecraft"))
                    .displayItems(((pParameters, pOutput) -> {
                        Items.ITEMS.getEntries().forEach((pItem) -> {
                            pOutput.accept(pItem.get());
                        });
                    }))
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
