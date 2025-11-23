package bluesteel42.farmstorage.block;

import bluesteel42.farmstorage.FarmStorage;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {

    public static final Block APPLE_BUSHEL = registerCropBlock("apple_bushel", Block::new, MapColor.RED, BlockSoundGroup.GRASS);
    public static final Block BEETROOT_BOX = registerCropBlock("beetroot_box", Block::new, MapColor.TERRACOTTA_RED, BlockSoundGroup.GRASS);
    public static final Block CARROT_CRATE = registerCropBlock("carrot_crate", GlazedTerracottaBlock::new, MapColor.ORANGE, BlockSoundGroup.GRASS);

    public static final Block EGG_BASKET = registerCropBlock("egg_basket", GlazedTerracottaBlock::new, MapColor.PALE_YELLOW, BlockSoundGroup.GRASS);
    public static final Block BROWN_EGG_BASKET = registerCropBlock("brown_egg_basket", GlazedTerracottaBlock::new, MapColor.PALE_YELLOW, BlockSoundGroup.GRASS);
    public static final Block BLUE_EGG_BASKET = registerCropBlock("blue_egg_basket", GlazedTerracottaBlock::new, MapColor.PALE_YELLOW, BlockSoundGroup.GRASS);
    public static final Block SPOTTED_EGG_BASKET = registerCropBlock("spotted_egg_basket", GlazedTerracottaBlock::new, MapColor.PALE_YELLOW, BlockSoundGroup.GRASS);
    public static final Block UMAMI_EGG_BASKET = registerCropBlock("umami_egg_basket", GlazedTerracottaBlock::new, MapColor.PALE_YELLOW, BlockSoundGroup.GRASS);
    public static final Block RED_MUSHROOM_BASKET = registerCropBlock("red_mushroom_basket", GlazedTerracottaBlock::new, MapColor.RED, BlockSoundGroup.GRASS);
    public static final Block BROWN_MUSHROOM_BASKET = registerCropBlock("brown_mushroom_basket", GlazedTerracottaBlock::new, MapColor.SPRUCE_BROWN, BlockSoundGroup.GRASS);

    public static final Block POTATO_SACK = registerCropBlock("potato_sack", GlazedTerracottaBlock::new, MapColor.YELLOW, BlockSoundGroup.GRASS);
    public static final Block POISONOUS_POTATO_SACK = registerCropBlock("poisonous_potato_sack", GlazedTerracottaBlock::new, MapColor.YELLOW, BlockSoundGroup.GRASS);

    public static final Block BEETROOT_SEED_PAIL = registerCropBlock("beetroot_seed_pail", PailBlock::new, MapColor.TERRACOTTA_WHITE, BlockSoundGroup.GRASS);
    public static final Block COCOA_BEANS_PAIL = registerCropBlock("cocoa_beans_pail", PailBlock::new, MapColor.SPRUCE_BROWN, BlockSoundGroup.GRASS);
    public static final Block MELON_SEED_PAIL = registerCropBlock("melon_seed_pail", PailBlock::new, MapColor.TERRACOTTA_BLACK, BlockSoundGroup.GRASS);
    public static final Block PUMPKIN_SEED_PAIL = registerCropBlock("pumpkin_seed_pail", PailBlock::new, MapColor.PALE_YELLOW, BlockSoundGroup.GRASS);
    public static final Block GREEN_PUMPKIN_SEED_PAIL = registerCropBlock("green_pumpkin_seed_pail", PailBlock::new, MapColor.PALE_GREEN, BlockSoundGroup.GRASS);
    public static final Block WHITE_PUMPKIN_SEED_PAIL = registerCropBlock("white_pumpkin_seed_pail", PailBlock::new, MapColor.OFF_WHITE, BlockSoundGroup.GRASS);
    public static final Block WHEAT_SEED_PAIL = registerCropBlock("wheat_seed_pail", PailBlock::new, MapColor.EMERALD_GREEN, BlockSoundGroup.GRASS);

    public static final Block SUGAR_CUBE = register("sugar_cube", Block::new,
            AbstractBlock.Settings.create()
            .mapColor(MapColor.WHITE)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .sounds(BlockSoundGroup.CALCITE)
            .strength(0.75F));

    public static final Block FEATHER_BAG = register("feather_bag", FeatherBagBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.WHITE).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sounds(BlockSoundGroup.WOOL).burnable());
    public static final Block LEATHER_ROLL = register("leather_roll", PillarBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sounds(BlockSoundGroup.WOOL).burnable());


    private static Block registerCropBlock(String path, Function<AbstractBlock.Settings, Block> factory, MapColor mapColor, BlockSoundGroup sounds) {
        AbstractBlock.Settings settings = AbstractBlock.Settings.create().mapColor(mapColor).instrument(NoteBlockInstrument.BANJO).strength(0.5F).sounds(sounds);

        final Identifier identifier = Identifier.of(FarmStorage.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);

        return block;
    }

    private static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(FarmStorage.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);

        return block;
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.COCOA_BEANS_PAIL);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.MELON_SEED_PAIL);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.WHITE_PUMPKIN_SEED_PAIL);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.GREEN_PUMPKIN_SEED_PAIL);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.PUMPKIN_SEED_PAIL);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.BEETROOT_SEED_PAIL);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.WHEAT_SEED_PAIL);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.FEATHER_BAG);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.LEATHER_ROLL);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.SUGAR_CUBE);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.BROWN_MUSHROOM_BASKET);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.RED_MUSHROOM_BASKET);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.POISONOUS_POTATO_SACK);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.POTATO_SACK);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.UMAMI_EGG_BASKET);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.SPOTTED_EGG_BASKET);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.BLUE_EGG_BASKET);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.BROWN_EGG_BASKET);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.EGG_BASKET);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.CARROT_CRATE);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.BEETROOT_BOX);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.APPLE_BUSHEL);
                });
    }

}
