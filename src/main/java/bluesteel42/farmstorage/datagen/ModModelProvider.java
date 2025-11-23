package bluesteel42.farmstorage.datagen;

import bluesteel42.farmstorage.FarmStorage;
import bluesteel42.farmstorage.block.ModBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.client.data.*;
import net.minecraft.util.Identifier;

import java.util.Optional;

import static net.minecraft.client.data.TextureMap.getSubId;
import static net.minecraft.client.data.TexturedModel.makeFactory;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    private static final Model CUBE_BOTTOM_TOP_PARTICLE_MODEL = vanillaBlock("cube_bottom_top", TextureKey.TOP, TextureKey.BOTTOM, TextureKey.SIDE, TextureKey.PARTICLE);
    private static final TexturedModel.Factory CUBE_BOTTOM_TOP_PARTICLE = makeFactory(ModModelProvider::sideTopBottomWithTopParticles, CUBE_BOTTOM_TOP_PARTICLE_MODEL);

    private static final Model PAIL_TEMPLATE_MODEL = modBlock("template_pail_block", TextureKey.TOP, TextureKey.FRONT);
    private static final TexturedModel.Factory PAIL = makeFactory(ModModelProvider::pail, PAIL_TEMPLATE_MODEL);

    private static final TexturedModel.Factory BASKET = makeFactory(ModModelProvider::basket, Models.CUBE);
    private static final TexturedModel.Factory SACK = makeFactory(ModModelProvider::sack, Models.CUBE);
    private static final TexturedModel.Factory BAG = makeFactory(ModModelProvider::bag, Models.CUBE);
    private static final TexturedModel.Factory CUBE_WITH_TOP_PARTICLES = makeFactory(ModModelProvider::cubeWithTopParticles, Models.CUBE);

    private static TextureMap sideTopBottomWithTopParticles(Block block) {
        return new TextureMap()
                .put(TextureKey.SIDE, getSubId(block, "_side"))
                .put(TextureKey.TOP, getSubId(block, "_top"))
                .put(TextureKey.BOTTOM, getSubId(block, "_bottom"))
                .put(TextureKey.PARTICLE, getSubId(block, "_top"));
    }
    private static TextureMap pail(Block block) {
        return new TextureMap()
                .put(TextureKey.TOP, getSubId(block, "_top"))
                .put(TextureKey.FRONT, getSubId(block, "_front"));
    }
    private static TextureMap basket(Block block) {
        return new TextureMap()
                .put(TextureKey.NORTH, getSubId(ModBlocks.EGG_BASKET, "_front"))
                .put(TextureKey.SOUTH, getSubId(ModBlocks.EGG_BASKET, "_front"))
                .put(TextureKey.EAST, getSubId(ModBlocks.EGG_BASKET, "_side"))
                .put(TextureKey.WEST, getSubId(ModBlocks.EGG_BASKET, "_side"))
                .put(TextureKey.UP, getSubId(block, "_top"))
                .put(TextureKey.DOWN, getSubId(ModBlocks.EGG_BASKET, "_bottom"))
                .put(TextureKey.PARTICLE, getSubId(block, "_top"));
    }
    private static TextureMap sack(Block block) {
        return new TextureMap()
                .put(TextureKey.NORTH, getSubId(block, "_front"))
                .put(TextureKey.SOUTH, getSubId(ModBlocks.POTATO_SACK, "_side"))
                .put(TextureKey.EAST, getSubId(ModBlocks.POTATO_SACK, "_side"))
                .put(TextureKey.WEST, getSubId(ModBlocks.POTATO_SACK, "_side"))
                .put(TextureKey.UP, getSubId(block, "_top"))
                .put(TextureKey.DOWN, getSubId(ModBlocks.POTATO_SACK, "_bottom"))
                .put(TextureKey.PARTICLE, getSubId(block, "_top"));
    }
    private static TextureMap bag(Block block) {
        return new TextureMap()
                .put(TextureKey.NORTH, getSubId(block, "_front"))
                .put(TextureKey.SOUTH, getSubId(block, "_side"))
                .put(TextureKey.EAST, getSubId(block, "_side"))
                .put(TextureKey.WEST, getSubId(block, "_side"))
                .put(TextureKey.UP, getSubId(block, "_top"))
                .put(TextureKey.DOWN, getSubId(block, "_bottom"))
                .put(TextureKey.PARTICLE, getSubId(block, "_top"));
    }
    private static TextureMap cubeWithTopParticles(Block block) {
        return new TextureMap()
                .put(TextureKey.NORTH, getSubId(block, "_front"))
                .put(TextureKey.SOUTH, getSubId(block, "_back"))
                .put(TextureKey.EAST, getSubId(block, "_right"))
                .put(TextureKey.WEST, getSubId(block, "_left"))
                .put(TextureKey.UP, getSubId(block, "_top"))
                .put(TextureKey.DOWN, getSubId(block, "_bottom"))
                .put(TextureKey.PARTICLE, getSubId(block, "_top"));
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSingleton(ModBlocks.APPLE_BUSHEL, CUBE_BOTTOM_TOP_PARTICLE);
        blockStateModelGenerator.registerSingleton(ModBlocks.BEETROOT_BOX, CUBE_BOTTOM_TOP_PARTICLE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.CARROT_CRATE, CUBE_WITH_TOP_PARTICLES);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.EGG_BASKET, BASKET);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.BROWN_EGG_BASKET, BASKET);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.BLUE_EGG_BASKET, BASKET);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.SPOTTED_EGG_BASKET, BASKET);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.UMAMI_EGG_BASKET, BASKET);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.RED_MUSHROOM_BASKET, BASKET);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.BROWN_MUSHROOM_BASKET, BASKET);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.POTATO_SACK, SACK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.POISONOUS_POTATO_SACK, SACK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.FEATHER_BAG, BAG);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SUGAR_CUBE);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.LEATHER_ROLL, TexturedModel.CUBE_COLUMN);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.BEETROOT_SEED_PAIL, PAIL);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.COCOA_BEANS_PAIL, PAIL);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.MELON_SEED_PAIL, PAIL);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.PUMPKIN_SEED_PAIL, PAIL);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.GREEN_PUMPKIN_SEED_PAIL, PAIL);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.WHITE_PUMPKIN_SEED_PAIL, PAIL);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModBlocks.WHEAT_SEED_PAIL, PAIL);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {}

    private static Model vanillaBlock(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(Identifier.ofVanilla("block/" + parent)), Optional.empty(), requiredTextureKeys);
    }
    private static Model modBlock(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(Identifier.of(FarmStorage.MOD_ID, "block/" + parent)), Optional.empty(), requiredTextureKeys);
    }
}
