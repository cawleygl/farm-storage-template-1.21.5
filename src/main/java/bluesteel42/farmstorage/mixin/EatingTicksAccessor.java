package bluesteel42.farmstorage.mixin;

import net.minecraft.entity.passive.AbstractHorseEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AbstractHorseEntity.class)
public interface EatingTicksAccessor {
    @Accessor("eatingTicks")
    int getEatingTicks();
    @Accessor("eatingTicks")
    void setEatingTicks(int eatingTicksValue);
}

