package dev.mateie.mcframe;

import com.mojang.logging.LogUtils;
import dev.mateie.mcframe.block.ModBlocks;
import dev.mateie.mcframe.item.ModCreativeModeTabs;
import dev.mateie.mcframe.item.ModItems;
import dev.mateie.mcframe.networking.ModPackets;
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

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
    }

    public static Logger getLogger() {
        return LOGGER;
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        ModPackets.register();
    }
}
