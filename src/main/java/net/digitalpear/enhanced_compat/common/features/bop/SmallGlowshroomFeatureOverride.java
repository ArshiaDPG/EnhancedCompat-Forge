package net.digitalpear.enhanced_compat.common.features.bop;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.common.util.SimpleBlockPredicate;
import com.mojang.serialization.Codec;
import net.digitalpear.enhanced_compat.init.ECBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Random;

public class SmallGlowshroomFeatureOverride extends Feature<NoneFeatureConfiguration> {
    private static final Block GLOWSHROOM_STEM = ECBlocks.GLOWSHROOM_STEM.get();

    public SmallGlowshroomFeatureOverride(Codec<NoneFeatureConfiguration> p_65786_) {
        super(p_65786_);
    }
    protected SimpleBlockPredicate placeOn = (world, pos) -> {
        return world.getBlockState(pos).getBlock() == Blocks.GRASS_BLOCK || world.getBlockState(pos).getBlock() == Blocks.MYCELIUM || world.getBlockState(pos).getBlock() == Blocks.STONE || world.getBlockState(pos).getBlock() == Blocks.DEEPSLATE || world.getBlockState(pos).getBlock() == BOPBlocks.GLOWING_MOSS_BLOCK || world.getBlockState(pos).getBlock() == BOPBlocks.MUD;
    };
    protected SimpleBlockPredicate replace = (world, pos) -> {
        return TreeFeature.isAirOrLeaves(world, pos) || world.getBlockState(pos).getBlock() instanceof BushBlock || world.getBlockState(pos).getBlock() == BOPBlocks.GLOWING_MOSS_CARPET || world.getBlockState(pos).getBlock() == Blocks.MOSS_CARPET;
    };
    @Override
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
            int height = 1 + rand.nextInt(4);

            int x;
            for(x = 0; x < height; ++x) {
                this.setBlock(world, pos.above(x), GLOWSHROOM_STEM.defaultBlockState());
            }

            for(x = -1; x <= 1; ++x) {
                for(int z = -1; z <= 1; ++z) {
                    this.setBlock(world, pos.offset(x, height, z), BOPBlocks.GLOWSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.DOWN, false));
                }
            }

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
