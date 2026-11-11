package fr.akkun.newmeriapaladium;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PaladiumBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(NewmeriaPaladium.MOD_ID);

    // Drops itself, to be smelted into an ingot. Generated in stone only, between Y=8 and Y=40, never in
    // deepslate (there is no deepslate variant): see data/newmeriapaladium/worldgen.
    public static final DeferredBlock<Block> PALADIUM_ORE = BLOCKS.registerBlock("paladium_ore",
            properties -> new Block(properties.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops().strength(4.0F, 6.0F).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> PALADIUM_BLOCK = BLOCKS.registerBlock("paladium_block",
            properties -> new Block(properties.mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BIT)
                    .requiresCorrectToolForDrops().strength(5.5F, 7.0F).sound(SoundType.METAL)));

    public static ResourceKey<Block> getRK(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }
}
