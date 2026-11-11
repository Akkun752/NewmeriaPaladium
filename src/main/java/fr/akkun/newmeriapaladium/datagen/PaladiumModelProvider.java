package fr.akkun.newmeriapaladium.datagen;

import fr.akkun.newmeriapaladium.NewmeriaPaladium;
import fr.akkun.newmeriapaladium.PaladiumBlocks;
import fr.akkun.newmeriapaladium.PaladiumItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class PaladiumModelProvider extends ModelProvider {
    public PaladiumModelProvider(PackOutput output) {
        super(output, NewmeriaPaladium.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        blockModels.createTrivialCube(PaladiumBlocks.PALADIUM_ORE.get());
        blockModels.createTrivialCube(PaladiumBlocks.PALADIUM_BLOCK.get());

        itemModels.generateFlatItem(PaladiumItems.PALADIUM_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PaladiumItems.PALADIUM_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PaladiumItems.PALADIUM_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PaladiumItems.PALADIUM_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PaladiumItems.PALADIUM_BOOTS.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(PaladiumItems.PALADIUM_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PaladiumItems.PALADIUM_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PaladiumItems.PALADIUM_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PaladiumItems.PALADIUM_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PaladiumItems.PALADIUM_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(PaladiumItems.PALADIUM_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
    }
}
