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
        valueLookupBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.APPLE_BUSHEL);
        valueLookupBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.BEETROOT_BOX);
        valueLookupBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.CARROT_CRATE);
        valueLookupBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.EGG_BASKET);
        valueLookupBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.BROWN_EGG_BASKET);
        valueLookupBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.BLUE_EGG_BASKET);
        valueLookupBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.SPOTTED_EGG_BASKET);
        valueLookupBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.UMAMI_EGG_BASKET);
        valueLookupBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.RED_MUSHROOM_BASKET);
        valueLookupBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.BROWN_MUSHROOM_BASKET);
        valueLookupBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.POTATO_SACK);
        valueLookupBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.POISONOUS_POTATO_SACK);
        valueLookupBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.BEETROOT_SEED_PAIL);
        valueLookupBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.MELON_SEED_PAIL);
        valueLookupBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.PUMPKIN_SEED_PAIL);
        valueLookupBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.GREEN_PUMPKIN_SEED_PAIL);
        valueLookupBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.WHITE_PUMPKIN_SEED_PAIL);
        valueLookupBuilder(BlockTags.HOE_MINEABLE).add(ModBlocks.WHEAT_SEED_PAIL);
        valueLookupBuilder(BlockTags.SHOVEL_MINEABLE).add(ModBlocks.CHOCOLATE_BLOCK);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.SUGAR_CUBE);
        valueLookupBuilder(BlockTags.WOOL).add(ModBlocks.LEATHER_ROLL);
        valueLookupBuilder(BlockTags.WOOL).add(ModBlocks.FEATHER_BAG);

    }
}
