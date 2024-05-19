package dev.mateie.mcframe.warframe;

import net.minecraft.nbt.CompoundTag;

public class PlayerWarframe {
    private String currentWarframe;

    public String getCurrentWarframe() {
        return this.currentWarframe;
    }

    public void setCurrentWarframe(String warframe) {
        this.currentWarframe = warframe;
    }

    public void saveNBTData(CompoundTag nbt) {
        if (this.currentWarframe != null) {
            nbt.putString("currentWarframe", this.currentWarframe);
        }
    }

    public void loadNBTData(CompoundTag nbt) {
        this.currentWarframe = nbt.getString("currentWarframe");
    }
}
