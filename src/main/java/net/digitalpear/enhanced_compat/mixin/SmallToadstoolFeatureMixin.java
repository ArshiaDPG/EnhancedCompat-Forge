package net.digitalpear.enhanced_compat.mixin;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.common.util.SimpleBlockPredicate;
import biomesoplenty.common.worldgen.feature.misc.SmallToadstoolFeature;
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

@Mixin(SmallToadstoolFeature.class)
public class SmallToadstoolFeatureMixin extends Feature<NoneFeatureConfiguration> {
    protected SimpleBlockPredicate placeOn = (world, pos) -> {
        return world.getBlockState(pos).getBlock() == Blocks.GRASS_BLOCK || world.getBlockState(pos).getBlock() == Blocks.MYCELIUM;
    };
    protected SimpleBlockPredicate replace = (world, pos) -> {
        return TreeFeature.isAirOrLeaves(world, pos) || world.getBlockState(pos).getBlock() instanceof BushBlock;
    };

    public SmallToadstoolFeatureMixin(Codec<NoneFeatureConfiguration> deserializer) {
        super(deserializer);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
        WorldGenLevel world = featurePlaceContext.level();
        ChunkGenerator chunkGenerator = featurePlaceContext.chunkGenerator();
        Random rand = featurePlaceContext.random();
        BlockPos startPos = featurePlaceContext.origin();

        if (!this.placeOn.matches(world, startPos.offset(0, 0, 0))) {
            return false;
        } else if (!this.checkSpace(world, startPos.above())) {
            return false;
        } else {
            BlockPos pos = startPos.above();
            int height = 1 + rand.nextInt(1);

            for(int y = 0; y < height; ++y) {
                this.setBlock(world, pos.above(y), ECBlocks.TOADSTOOL_STEM.get().defaultBlockState());
            }

            this.setBlock(world, pos.offset(0, height, 0), BOPBlocks.TOADSTOOL_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.DOWN, false));
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
        for(int y = 0; y <= 4; ++y) {
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
