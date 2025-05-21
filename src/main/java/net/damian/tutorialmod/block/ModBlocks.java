package net.damian.tutorialmod.block;

import net.damian.tutorialmod.item.ModItems;
import net.damian.tutorialmod.unsee;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Display;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.FireworkRocketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.Tags;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;


import java.awt.*;
import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, unsee.MOD_ID);

    public static final RegistryObject<Block> INVISILINE_BLOCK = registerBlock("invisiline_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_DIORITE_SLAB).sound(SoundType.WOOD).noOcclusion().noCollission()));

    public static final RegistryObject<Block> INVISIPAINT_BLOCK = registerBlock("invisipaint_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_ANDESITE_SLAB).sound(SoundType.WOOD).noOcclusion().noCollission()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public class invisiline_block extends Block {
        public invisiline_block() {
            super(Properties.copy(Blocks.POLISHED_DIORITE_SLAB).noOcclusion().strength(1.0f)
                    .lightLevel(state -> 0).noCollission()
                    .isRedstoneConductor((state, world, pos) -> false));
        }
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}