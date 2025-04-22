package bluesteel42.farmstorage.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Entity.class)
public interface RandomAccessor {
    @Accessor("random")
    Random getRandom();
    @Accessor("random")
    void setRandom(Random randomValue);
}

