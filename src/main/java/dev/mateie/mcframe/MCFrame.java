package dev.mateie.mcframe;

import com.mojang.logging.LogUtils;
import dev.mateie.mcframe.block.Blocks;
import dev.mateie.mcframe.item.CreativeModeTabs;
import dev.mateie.mcframe.item.Items;
import dev.mateie.mcframe.networking.Packets;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(MCFrame.MOD_ID)
public class MCFrame {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "mcframe";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    public MCFrame() {
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
