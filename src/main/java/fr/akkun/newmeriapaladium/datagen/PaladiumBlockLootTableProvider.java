package fr.akkun.newmeriapaladium.datagen;

import fr.akkun.newmeriapaladium.PaladiumBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.Set;

public class PaladiumBlockLootTableProvider extends BlockLootSubProvider {
    public PaladiumBlockLootTableProvider(LootTableSubProvider.Context output) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), output);
    }

    @Override
    protected void generate() {
        // As in the old Newmeria Mod, the ore drops itself: it is smelted into an ingot.
        dropSelf(PaladiumBlocks.PALADIUM_ORE.get());
        dropSelf(PaladiumBlocks.PALADIUM_BLOCK.get());
    }

    /** Only our blocks: by default every registered block (NewmeriaCore's too) would need a loot table here. */
    @Override
    protected Iterable<Block> getKnownBlocks() {
        List<Block> blocks = PaladiumBlocks.BLOCKS.getEntries().stream().map(Holder::value).map(Block.class::cast).toList();
        return blocks;
    }
}
