package bluesteel42.farmstorage.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Entity.class)
public interface WorldAccessor {
    @Accessor("world")
    World getWorld();
    @Accessor("world")
    void setWorld(World worldValue);
}

