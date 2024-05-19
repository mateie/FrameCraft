package dev.mateie.mcframe.event;

import dev.mateie.mcframe.MCFrame;
import dev.mateie.mcframe.warframe.PlayerWarframe;
import dev.mateie.mcframe.warframe.PlayerWarframeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MCFrame.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            if (!event.getObject().getCapability(PlayerWarframeProvider.PLAYER_WARFRAME).isPresent()) {
                event.addCapability(new ResourceLocation(MCFrame.MOD_ID, "properties"), new PlayerWarframeProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            event.getOriginal().getCapability(PlayerWarframeProvider.PLAYER_WARFRAME).ifPresent(oldWarframe -> {
                event.getOriginal().getCapability(PlayerWarframeProvider.PLAYER_WARFRAME).ifPresent(newWarframe -> {
                    newWarframe.setCurrentWarframe(oldWarframe.getCurrentWarframe());
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerWarframe.class);
    }
}
