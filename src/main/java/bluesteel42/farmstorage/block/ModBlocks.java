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

    public static final Block APPLE_BUSHEL = registerCropBlock("apple_bushel", Block::new, MapColor.RED);
    public static final Block BEETROOT_BOX = registerCropBlock("beetroot_box", Block::new, MapColor.TERRACOTTA_RED);
    public static final Block CARROT_CRATE = registerCropBlock("carrot_crate", GlazedTerracottaBlock::new, MapColor.ORANGE);
    public static final Block EGG_BASKET = registerCropBlock("egg_basket", GlazedTerracottaBlock::new, MapColor.PALE_YELLOW);
    public static final Block POTATO_SACK = registerCropBlock("potato_sack", GlazedTerracottaBlock::new, MapColor.YELLOW);
    public static final Block POISONOUS_POTATO_SACK = registerCropBlock("poisonous_potato_sack", GlazedTerracottaBlock::new, MapColor.PALE_GREEN);

    public static final Block BEETROOT_SEED_PAIL = registerCropBlock("beetroot_seed_pail", PailBlock::new, MapColor.PALE_YELLOW);
    public static final Block COCOA_BEANS_PAIL = registerCropBlock("cocoa_beans_pail", PailBlock::new, MapColor.BROWN);
    public static final Block MELON_SEED_PAIL = registerCropBlock("melon_seed_pail", PailBlock::new, MapColor.TERRACOTTA_BLACK);
    public static final Block PUMPKIN_SEED_PAIL = registerCropBlock("pumpkin_seed_pail", PailBlock::new, MapColor.OFF_WHITE);
    public static final Block WHEAT_SEED_PAIL = registerCropBlock("wheat_seed_pail", PailBlock::new, MapColor.GREEN);

    private static Block registerCropBlock(String path, Function<AbstractBlock.Settings, Block> factory, MapColor mapColor) {
        AbstractBlock.Settings settings = AbstractBlock.Settings.create().mapColor(mapColor).instrument(NoteBlockInstrument.BANJO).strength(0.5F).sounds(BlockSoundGroup.GRASS);

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
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.PUMPKIN_SEED_PAIL);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.BEETROOT_SEED_PAIL);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.WHEAT_SEED_PAIL);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.POISONOUS_POTATO_SACK);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.POTATO_SACK);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.EGG_BASKET);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.CARROT_CRATE);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.BEETROOT_BOX);
                    itemGroup.addAfter(Items.HAY_BLOCK, ModBlocks.APPLE_BUSHEL);
                });
    }

}
