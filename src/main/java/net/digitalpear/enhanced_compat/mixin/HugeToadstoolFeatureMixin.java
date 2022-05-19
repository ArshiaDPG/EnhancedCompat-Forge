package net.digitalpear.enhanced_compat.mixin;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.common.util.SimpleBlockPredicate;
import biomesoplenty.common.worldgen.feature.misc.HugeToadstoolFeature;
import com.mojang.serialization.Codec;
import net.digitalpear.enhanced_compat.init.ECBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Random;

@Mixin(HugeToadstoolFeature.class)
public class HugeToadstoolFeatureMixin extends Feature<NoneFeatureConfiguration> {
    protected SimpleBlockPredicate placeOn = (world, pos) -> {
        return world.getBlockState(pos).getBlock() == Blocks.GRASS_BLOCK || world.getBlockState(pos).getBlock() == Blocks.MYCELIUM;
    };
    protected SimpleBlockPredicate replace = (world, pos) -> {
        return TreeFeature.isAirOrLeaves(world, pos) || world.getBlockState(pos).getBlock() instanceof BushBlock;
    };

    public HugeToadstoolFeatureMixin(Codec<NoneFeatureConfiguration> deserializer) {
        super(deserializer);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
        WorldGenLevel world = featurePlaceContext.level();
        ChunkGenerator chunkGenerator = featurePlaceContext.chunkGenerator();
        Random rand = featurePlaceContext.random();
        BlockPos startPos = featurePlaceContext.origin();

        for(NoneFeatureConfiguration var6 = (NoneFeatureConfiguration)featurePlaceContext.config(); startPos.getY() > 1 && this.replace.matches(world, startPos); startPos = startPos.below()) {
        }

        if (!this.placeOn.matches(world, startPos.offset(0, 0, 0))) {
            return false;
        } else if (!this.checkSpace(world, startPos.above())) {
            return false;
        } else {
            BlockPos pos = startPos.above();
            int height = 2 + rand.nextInt(13);
            int radius = 2;

            int x;
            for(x = 0; x < height; ++x) {
                this.setBlock(world, pos.above(x), ECBlocks.TOADSTOOL_STEM.get().defaultBlockState());
            }

            for(x = -(radius - 1); x <= radius - 1; ++x) {
                for(int z = -(radius - 1); z <= radius - 1; ++z) {
                    this.setBlock(world, pos.offset(x, height, z), (BlockState) BOPBlocks.TOADSTOOL_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.DOWN, false));
                    this.setBlock(world, pos.offset(x, height + 1, z), (BlockState)BOPBlocks.TOADSTOOL_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.DOWN, false));
                    this.setBlock(world, pos.offset(x, height + 2, z), (BlockState)BOPBlocks.TOADSTOOL_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.DOWN, false));
                }
            }

            this.setBlock(world, pos.offset(0, height + 3, 0), (BlockState)BOPBlocks.TOADSTOOL_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.DOWN, false));
            this.setBlock(world, pos.offset(1, height + 3, 0), (BlockState)BOPBlocks.TOADSTOOL_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.DOWN, false));
            this.setBlock(world, pos.offset(-1, height + 3, 0), (BlockState)BOPBlocks.TOADSTOOL_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.DOWN, false));
            this.setBlock(world, pos.offset(0, height + 3, 1), (BlockState)BOPBlocks.TOADSTOOL_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.DOWN, false));
            this.setBlock(world, pos.offset(0, height + 3, -1), (BlockState)BOPBlocks.TOADSTOOL_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.DOWN, false));
            return true;
        }
    }

    public boolean setBlock(WorldGenLevel world, BlockPos pos, BlockState state) {
        if (this.replace.matches(world, pos)) {
            super.setBlock(world, pos, state);
            return true;
        } else {
            return false;
        }
    }

    public boolean checkSpace(WorldGenLevel world, BlockPos pos) {
        for(int y = 0; y <= 8; ++y) {
            for(int x = -2; x <= 2; ++x) {
                for(int z = -2; z <= 2; ++z) {
                    BlockPos pos1 = pos.offset(x, y, z);
                    if (pos1.getY() >= 255 || !this.replace.matches(world, pos1)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
