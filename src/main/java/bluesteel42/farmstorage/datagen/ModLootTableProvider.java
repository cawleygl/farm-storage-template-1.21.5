package bluesteel42.farmstorage.datagen;

import bluesteel42.farmstorage.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.APPLE_BUSHEL);
        addDrop(ModBlocks.BEETROOT_BOX);
        addDrop(ModBlocks.CARROT_CRATE);
        addDrop(ModBlocks.EGG_BASKET);
        addDrop(ModBlocks.BROWN_EGG_BASKET);
        addDrop(ModBlocks.BLUE_EGG_BASKET);
        addDrop(ModBlocks.POTATO_SACK);
        addDrop(ModBlocks.POISONOUS_POTATO_SACK);
        addDrop(ModBlocks.SUGAR_CUBE);
        addDrop(ModBlocks.LEATHER_ROLL);
        addDrop(ModBlocks.FEATHER_BAG);
        addDrop(ModBlocks.BEETROOT_SEED_PAIL);
        addDrop(ModBlocks.COCOA_BEANS_PAIL);
        addDrop(ModBlocks.MELON_SEED_PAIL);
        addDrop(ModBlocks.PUMPKIN_SEED_PAIL);
        addDrop(ModBlocks.WHEAT_SEED_PAIL);
    }
}
