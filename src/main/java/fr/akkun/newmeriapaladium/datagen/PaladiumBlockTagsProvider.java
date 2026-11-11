package fr.akkun.newmeriapaladium.datagen;

import fr.akkun.newmeriapaladium.NewmeriaPaladium;
import fr.akkun.newmeriapaladium.PaladiumBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class PaladiumBlockTagsProvider extends BlockTagsProvider {
    public PaladiumBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, NewmeriaPaladium.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        Block ore = PaladiumBlocks.PALADIUM_ORE.get();
        Block block = PaladiumBlocks.PALADIUM_BLOCK.get();

        addBoth(BlockTags.MINEABLE_WITH_PICKAXE, ore, block);
        addBoth(BlockTags.NEEDS_DIAMOND_TOOL, ore, block);
        // Since 26.3 a block only "blocks motion" (heightmaps, suffocation, stopping fluids...) if tagged so.
        addBoth(BlockTags.BLOCKS_MOTION_NO_LEAVES, ore, block);
        tag(BlockTags.ORES).add(PaladiumBlocks.getRK(ore));
        tag(BlockTags.BEACON_BASE_BLOCKS).add(PaladiumBlocks.getRK(block));
    }

    private void addBoth(TagKey<Block> tag, Block first, Block second) {
        tag(tag).add(PaladiumBlocks.getRK(first), PaladiumBlocks.getRK(second));
    }
}
