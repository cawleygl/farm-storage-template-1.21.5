package bluesteel42.farmstorage.mixin;

import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.passive.AbstractHorseEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AbstractHorseEntity.class)
public interface HorseFlagsAccessor {
    @Accessor("HORSE_FLAGS")
    TrackedData<Byte> getHORSE_FLAGS();
}

