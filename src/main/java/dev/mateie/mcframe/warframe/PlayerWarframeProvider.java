package dev.mateie.mcframe.warframe;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerWarframeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    public static Capability<PlayerWarframe> PLAYER_WARFRAME = CapabilityManager.get(new CapabilityToken<PlayerWarframe>() {
    });

    private PlayerWarframe playerWarframe = null;
    private final LazyOptional<PlayerWarframe> optional = LazyOptional.of(this::createPlayerWarframe);

    private PlayerWarframe createPlayerWarframe() {
        if (playerWarframe == null) {
            playerWarframe = new PlayerWarframe();
        }
        return playerWarframe;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PLAYER_WARFRAME) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerWarframe().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerWarframe().loadNBTData(nbt);
    }
}
