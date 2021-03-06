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

public class HugeGlowshroomFeatureOverride extends Feature<NoneFeatureConfiguration> {

    private static final Block GLOWSHROOM_STEM = ECBlocks.GLOWSHROOM_STEM.get();
    public HugeGlowshroomFeatureOverride(Codec<NoneFeatureConfiguration> p_65786_) {
        super(p_65786_);
    }

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
            int height = 6 + rand.nextInt(10);
            int radius = 2 + rand.nextInt(2);

            int x;
            for(x = 0; x < height; ++x) {
                this.setBlock(world, pos.above(x), GLOWSHROOM_STEM.defaultBlockState());
            }

            int z;
            for(x = -(radius - 1); x <= radius - 1; ++x) {
                for(z = -(radius - 1); z <= radius - 1; ++z) {
                    this.setBlock(world, pos.offset(x, height, z), BOPBlocks.GLOWSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.DOWN, false));
                }
            }

            for(x = -radius; x <= radius; ++x) {
                for(z = -radius; z <= radius; ++z) {
                    if (x != -radius && x != radius || z != -radius && z != radius) {
                        if (x == radius) {
                            this.setBlock(world, pos.offset(x, height - 1, z), BOPBlocks.GLOWSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.WEST, false));
                            this.setBlock(world, pos.offset(x, height - 2, z), BOPBlocks.GLOWSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.WEST, false));
                        }

                        if (x == -radius) {
                            this.setBlock(world, pos.offset(x, height - 1, z), BOPBlocks.GLOWSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.EAST, false));
                            this.setBlock(world, pos.offset(x, height - 2, z), BOPBlocks.GLOWSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.EAST, false));
                        }

                        if (z == radius) {
                            this.setBlock(world, pos.offset(x, height - 1, z), BOPBlocks.GLOWSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.NORTH, false));
                            this.setBlock(world, pos.offset(x, height - 2, z), BOPBlocks.GLOWSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.NORTH, false));
                        }

                        if (z == -radius) {
                            this.setBlock(world, pos.offset(x, height - 1, z), BOPBlocks.GLOWSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.SOUTH, false));
                            this.setBlock(world, pos.offset(x, height - 2, z), BOPBlocks.GLOWSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.SOUTH, false));
                        }
                    }
                }
            }

            return true;
        }
    }
    public boolean checkSpace(WorldGenLevel world, BlockPos pos) {
        for(int y = 0; y <= 12; ++y) {
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
    public boolean setBlock(WorldGenLevel world, BlockPos pos, BlockState state) {
        if (this.replace.matches(world, pos)) {
            super.setBlock(world, pos, state);
            return true;
        } else {
            return false;
        }
    }
    protected SimpleBlockPredicate placeOn = (world, pos) -> {
        return world.getBlockState(pos).getBlock() == Blocks.GRASS_BLOCK || world.getBlockState(pos).getBlock() == Blocks.MYCELIUM || world.getBlockState(pos).getBlock() == Blocks.STONE || world.getBlockState(pos).getBlock() == Blocks.DEEPSLATE || world.getBlockState(pos).getBlock() == BOPBlocks.GLOWING_MOSS_BLOCK || world.getBlockState(pos).getBlock() == BOPBlocks.MUD;
    };
    protected SimpleBlockPredicate replace = (world, pos) -> {
        return TreeFeature.isAirOrLeaves(world, pos) || world.getBlockState(pos).getBlock() instanceof BushBlock || world.getBlockState(pos).getBlock() == BOPBlocks.GLOWING_MOSS_CARPET || world.getBlockState(pos).getBlock() == Blocks.MOSS_CARPET;
    };
}
