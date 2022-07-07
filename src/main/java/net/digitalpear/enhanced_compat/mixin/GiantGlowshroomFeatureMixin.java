package net.digitalpear.enhanced_compat.mixin;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.common.util.SimpleBlockPredicate;
import biomesoplenty.common.worldgen.feature.misc.GiantGlowshroomFeature;
import com.mojang.serialization.Codec;
import net.digitalpear.enhanced_compat.init.ECBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Random;

@Mixin(GiantGlowshroomFeature.class)
public class GiantGlowshroomFeatureMixin extends Feature<NoneFeatureConfiguration> {
    protected SimpleBlockPredicate placeOn = (world, pos) -> {
        return world.getBlockState(pos).getBlock() == Blocks.GRASS_BLOCK || world.getBlockState(pos).getBlock() == Blocks.MYCELIUM || world.getBlockState(pos).getBlock() == Blocks.STONE || world.getBlockState(pos).getBlock() == Blocks.DEEPSLATE || world.getBlockState(pos).getBlock() == BOPBlocks.GLOWING_MOSS_BLOCK || world.getBlockState(pos).getBlock() == BOPBlocks.MUD;
    };
    protected SimpleBlockPredicate replace = (world, pos) -> {
        return TreeFeature.isAirOrLeaves(world, pos) || world.getBlockState(pos).getBlock() instanceof BushBlock || world.getBlockState(pos).getBlock() == BOPBlocks.GLOWING_MOSS_CARPET || world.getBlockState(pos).getBlock() == Blocks.MOSS_CARPET;
    };

    public GiantGlowshroomFeatureMixin(Codec<NoneFeatureConfiguration> deserializer) {
        super(deserializer);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
        WorldGenLevel world = featurePlaceContext.level();
        Random rand = featurePlaceContext.random();
        BlockPos startPos = featurePlaceContext.origin();

        for (NoneFeatureConfiguration var6 = featurePlaceContext.config(); startPos.getY() > -64 && this.replace.matches(world, startPos); startPos = startPos.below()) {
        }

        if (!this.placeOn.matches(world, startPos.offset(0, 0, 0))) {
            return false;
        } else if (!this.checkSpace(world, startPos.above())) {
            return false;
        } else {
            BlockPos pos = startPos.above();
            int height = 15 + rand.nextInt(10);
            int radius = 3 + rand.nextInt(3);

            int x;
            for (x = 0; x < height; ++x) {
                this.setBlock(world, pos.above(x), ECBlocks.GLOWSHROOM_STEM.get().defaultBlockState());
            }

            int z;
            for (x = -(radius - 1); x <= radius - 1; ++x) {
                for (z = -(radius - 1); z <= radius - 1; ++z) {
                    this.setBlock(world, pos.offset(x, height, z), BOPBlocks.GLOWSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.DOWN, false));
                }
            }

            for (x = -radius; x <= radius; ++x) {
                for (z = -radius; z <= radius; ++z) {
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

    public boolean setBlock(WorldGenLevel world, BlockPos pos, BlockState state) {
        if (this.replace.matches(world, pos)) {
            super.setBlock(world, pos, state);
            return true;
        } else {
            return false;
        }
    }

    public boolean checkSpace(WorldGenLevel world, BlockPos pos) {
        for (int y = 0; y <= 25; ++y) {
            for (int x = -2; x <= 2; ++x) {
                for (int z = -2; z <= 2; ++z) {
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