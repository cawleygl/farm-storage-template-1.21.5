package bluesteel42.farmstorage.registries;

import bluesteel42.farmstorage.block.ModBlocks;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class ModRegistries {
    public static void registerCompostables() {
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.APPLE_BUSHEL, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.BEETROOT_BOX, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.CARROT_CRATE, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.POTATO_SACK, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.RED_MUSHROOM_BASKET, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.BROWN_MUSHROOM_BASKET, 0.85F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.BEETROOT_SEED_PAIL, 0.50F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.MELON_SEED_PAIL, 0.50F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.PUMPKIN_SEED_PAIL, 0.50F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.WHEAT_SEED_PAIL, 0.50F);
    }

    public static void registerFlammables() {
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.APPLE_BUSHEL, 60, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BEETROOT_BOX, 60, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.CARROT_CRATE, 60, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.EGG_BASKET, 60, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BROWN_EGG_BASKET, 60, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLUE_EGG_BASKET, 60, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SPOTTED_EGG_BASKET, 60, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.UMAMI_EGG_BASKET, 60, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.RED_MUSHROOM_BASKET, 60, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BROWN_MUSHROOM_BASKET, 60, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.POTATO_SACK, 60, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.POISONOUS_POTATO_SACK, 60, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.LEATHER_ROLL, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.FEATHER_BAG, 30, 60);
    }
}
