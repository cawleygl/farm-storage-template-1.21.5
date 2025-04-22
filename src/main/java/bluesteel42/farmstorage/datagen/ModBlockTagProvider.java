package bluesteel42.farmstorage.datagen;

import bluesteel42.farmstorage.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.APPLE_BUSHEL);
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.BEETROOT_BOX);
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.CARROT_CRATE);
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.EGG_BASKET);
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.BROWN_EGG_BASKET);
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.BLUE_EGG_BASKET);
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.POTATO_SACK);
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.POISONOUS_POTATO_SACK);
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.LEATHER_ROLL);
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.FEATHER_BAG);
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.BEETROOT_SEED_PAIL);
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.COCOA_BEANS_PAIL);
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.MELON_SEED_PAIL);
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.PUMPKIN_SEED_PAIL);
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.WHEAT_SEED_PAIL);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.SUGAR_CUBE);
    }
}
