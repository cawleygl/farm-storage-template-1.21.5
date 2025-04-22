package bluesteel42.farmstorage.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.passive.AbstractHorseEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Entity.class)
public interface DataTrackerAccessor {
    @Accessor("dataTracker")
    DataTracker getDataTracker();
    @Accessor("dataTracker")
    void setDataTracker(DataTracker eatingTicksValue);
}

