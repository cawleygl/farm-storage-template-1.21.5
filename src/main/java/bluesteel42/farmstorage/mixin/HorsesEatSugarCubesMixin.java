package bluesteel42.farmstorage.mixin;

import bluesteel42.farmstorage.block.ModBlocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractHorseEntity.class)
public class HorsesEatSugarCubesMixin {
	private void setHorseFlag(AbstractHorseEntity thisObject, int bitmask, boolean flag) {
		DataTrackerAccessor dataTrackerAccessor = (DataTrackerAccessor) (Object) this;
		HorseFlagsAccessor horseFlagsAccessor = (HorseFlagsAccessor) (Object) this;

		DataTracker dataTracker = dataTrackerAccessor.getDataTracker();
		TrackedData<Byte> horseFlags = horseFlagsAccessor.getHORSE_FLAGS();

		byte b = (Byte)dataTracker.get(horseFlags);
		if (flag) {
			dataTracker.set(horseFlags, (byte)(b | bitmask));
		} else {
			dataTracker.set(horseFlags, (byte)(b & ~bitmask));
		}

	}

	private void setEating(AbstractHorseEntity thisObject) {
		EatingTicksAccessor eatingTicksAccessor = (EatingTicksAccessor) (Object) this;

		if (!thisObject.getWorld().isClient) {
			eatingTicksAccessor.setEatingTicks(1);
			setHorseFlag(thisObject, 64, true);
		}

	}



	@Inject(at = @At("HEAD"), method = "receiveFood", cancellable = true)
	private void init(PlayerEntity player, ItemStack item, CallbackInfoReturnable<Boolean> cir) {
		// This code is injected into the start of MinecraftServer.loadWorld()V
		if (item.isOf(ModBlocks.SUGAR_CUBE.asItem())) {
			AbstractHorseEntity thisObject = ((AbstractHorseEntity)(Object)this);

			boolean bl = false;
			float f = 0.0F;
			int i = 0;
			int j = 0;
			f = 3.0F;
			i = 60;
			j = 3;

			if (thisObject.getHealth() < thisObject.getMaxHealth() && f > 0.0F) {
				thisObject.heal(f);
				bl = true;
			}

			if (thisObject.isBaby() && i > 0) {
				thisObject.getWorld().addParticleClient(ParticleTypes.HAPPY_VILLAGER, thisObject.getParticleX((double) 1.0F), thisObject.getRandomBodyY() + (double) 0.5F, thisObject.getParticleZ((double) 1.0F), (double) 0.0F, (double) 0.0F, (double) 0.0F);
				if (!thisObject.getWorld().isClient) {
					thisObject.growUp(i);
					bl = true;
				}
			}

			if (j > 0 && (bl || !thisObject.isTame()) && thisObject.getTemper() < thisObject.getMaxTemper() && !thisObject.getWorld().isClient) {
				thisObject.addTemper(j);
				bl = true;
			}

			if (bl) {
				setEating(thisObject);
				if (!thisObject.isSilent()) {
					SoundEvent soundEvent = SoundEvents.ENTITY_HORSE_EAT;
					if (soundEvent != null) {
						RandomAccessor randomAccessor = (RandomAccessor) (Object) this;
						Random random = randomAccessor.getRandom();
						WorldAccessor worldAccessor = (WorldAccessor) (Object) this;
						World world = worldAccessor.getWorld();
						world.playSound((Entity)null, thisObject.getX(), thisObject.getY(), thisObject.getZ(), soundEvent, thisObject.getSoundCategory(), 1.0F, 1.0F + (random.nextFloat() - random.nextFloat()) * 0.2F);
					}
				}
				thisObject.emitGameEvent(GameEvent.EAT);
			}

			cir.setReturnValue(bl);
			cir.cancel();
		}

	}
}