package dev.mateie.mcframe;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

@Mod(MCFrame.MOD_ID)
public class MCFrame {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "mcframe";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();



    public MCFrame() {
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

    }

    public static Logger getLogger() {
        return LOGGER;
    }
}
