package dev.mateie.mcframe.item;

import dev.mateie.mcframe.MCFrame;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MCFrame.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MCFRAME_TAB = CREATIVE_MODE_TABS.register("mcframe_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.POLYMER_BUNDLE.get()))
                    .title(Component.translatable("creativetab.mcframe"))
                    .displayItems(((pParameters, pOutput) -> {
                        ModItems.ITEMS.getEntries().forEach((pItem) -> {
                            pOutput.accept(pItem.get());
                        });
                    }))
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
