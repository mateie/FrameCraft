package dev.mateie.framecraft;

import com.mojang.logging.LogUtils;
import dev.mateie.framecraft.block.Blocks;
import dev.mateie.framecraft.item.CreativeModeTabs;
import dev.mateie.framecraft.item.Items;
import dev.mateie.framecraft.networking.Packets;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(FrameCraft.MOD_ID)
public class FrameCraft {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "framecraft";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    public FrameCraft() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CreativeModeTabs.register(modEventBus);
        Items.register(modEventBus);
        Blocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
    }

    public static Logger getLogger() {
        return LOGGER;
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        Packets.register();
    }
}
