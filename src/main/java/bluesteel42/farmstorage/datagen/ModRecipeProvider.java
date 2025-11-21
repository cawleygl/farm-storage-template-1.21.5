package bluesteel42.farmstorage.datagen;

import bluesteel42.farmstorage.FarmStorage;
import bluesteel42.farmstorage.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            private void offerFarmBlockCompactingRecipes(ItemConvertible baseItem, ItemConvertible compactItem) {
                offerReversibleCompactingRecipes(RecipeCategory.MISC, baseItem, RecipeCategory.BUILDING_BLOCKS, compactItem);
            }
            private void offerFarmBlockCompactingRecipesSpecifyingBaseItemRecipe(ItemConvertible baseItem, ItemConvertible compactItem) {
                offerReversibleCompactingRecipesWithReverseRecipeGroup(RecipeCategory.MISC, baseItem, RecipeCategory.BUILDING_BLOCKS, compactItem, convertBetween(baseItem, compactItem), getRecipeName(baseItem));
            }
            @Override
            public void generate() {
                offerFarmBlockCompactingRecipes(Items.APPLE, ModBlocks.APPLE_BUSHEL);
                offerFarmBlockCompactingRecipes(Items.BEETROOT, ModBlocks.BEETROOT_BOX);
                offerFarmBlockCompactingRecipes(Items.CARROT, ModBlocks.CARROT_CRATE);
                offerFarmBlockCompactingRecipes(Items.EGG, ModBlocks.EGG_BASKET);
                offerFarmBlockCompactingRecipes(Items.BROWN_EGG, ModBlocks.BROWN_EGG_BASKET);
                offerFarmBlockCompactingRecipes(Items.BLUE_EGG, ModBlocks.BLUE_EGG_BASKET);
                offerFarmBlockCompactingRecipes(Items.RED_MUSHROOM, ModBlocks.RED_MUSHROOM_BASKET);
                offerFarmBlockCompactingRecipes(Items.BROWN_MUSHROOM, ModBlocks.BROWN_MUSHROOM_BASKET);
                offerFarmBlockCompactingRecipes(Items.POTATO, ModBlocks.POTATO_SACK);
                offerFarmBlockCompactingRecipes(Items.POISONOUS_POTATO, ModBlocks.POISONOUS_POTATO_SACK);
                offerFarmBlockCompactingRecipes(Items.BEETROOT_SEEDS, ModBlocks.BEETROOT_SEED_PAIL);
                offerFarmBlockCompactingRecipes(Items.COCOA_BEANS, ModBlocks.COCOA_BEANS_PAIL);
                offerFarmBlockCompactingRecipes(Items.WHEAT_SEEDS, ModBlocks.WHEAT_SEED_PAIL);
                offerFarmBlockCompactingRecipes(Items.FEATHER, ModBlocks.FEATHER_BAG);
                offerFarmBlockCompactingRecipes(Items.LEATHER, ModBlocks.LEATHER_ROLL);

                offerFarmBlockCompactingRecipesSpecifyingBaseItemRecipe(Items.MELON_SEEDS, ModBlocks.MELON_SEED_PAIL);
                offerFarmBlockCompactingRecipesSpecifyingBaseItemRecipe(Items.PUMPKIN_SEEDS, ModBlocks.PUMPKIN_SEED_PAIL);
                offerFarmBlockCompactingRecipesSpecifyingBaseItemRecipe(Items.SUGAR, ModBlocks.SUGAR_CUBE);

            }
        };
    }

    @Override
    public String getName() {
        return FarmStorage.MOD_ID + "_recipes";
    }
}
