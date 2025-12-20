package bluesteel42.farmstorage.item;

import bluesteel42.farmstorage.block.ModBlocks;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class ModItems {

    public static final FoodComponent CHOCOLATE_BLOCK_FOOD = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F).build();
    public static final Item CHOCOLATE_BLOCK = Items.register(ModBlocks.CHOCOLATE_BLOCK, BlockItem::new, new BlockItem.Settings().food(CHOCOLATE_BLOCK_FOOD));

    public static void initialize() {}
}
