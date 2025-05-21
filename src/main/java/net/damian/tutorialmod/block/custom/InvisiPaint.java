package net.damian.tutorialmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class InvisiPaint extends BaseEntityBlock {

    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16.0, 1.0, 16.0);

    public InvisiPaint(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public boolean isValidSpawn(BlockState state, BlockGetter level, BlockPos pos, SpawnPlacements.Type type, EntityType<?> entityType) {
        return false;
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public  BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return
    }
}

public class InvisiPaint extends Block {
    public invisipaint_block() {
        super(Properties.copy(Blocks.POLISHED_ANDESITE_SLAB)
                .noOcclusion()
                .noCollission()
                .strength(1.0f)
                .lightLevel(state->0)
                .isRedstoneConductor((state, world, pos) -> false));
    }
}
