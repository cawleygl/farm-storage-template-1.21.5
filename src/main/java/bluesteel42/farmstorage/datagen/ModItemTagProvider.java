package bluesteel42.farmstorage.datagen;

import bluesteel42.farmstorage.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.HORSE_FOOD).add(ModBlocks.SUGAR_CUBE.asItem());

        getOrCreateTagBuilder(ItemTags.DAMPENS_VIBRATIONS).add(ModBlocks.LEATHER_ROLL.asItem());
        getOrCreateTagBuilder(ItemTags.DAMPENS_VIBRATIONS).add(ModBlocks.FEATHER_BAG.asItem());
    }
}
