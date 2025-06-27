package bluesteel42.farmstorage.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FeatherBagBlock extends HorizontalFacingBlock {
    public static final MapCodec<FeatherBagBlock> CODEC = createCodec(FeatherBagBlock::new);

    @Override
    public MapCodec<FeatherBagBlock> getCodec() {
        return CODEC;
    }

    public FeatherBagBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
    
    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, double fallDistance) {
        entity.handleFallDamage(fallDistance, 0.2F, world.getDamageSources().fall());
    }
}
