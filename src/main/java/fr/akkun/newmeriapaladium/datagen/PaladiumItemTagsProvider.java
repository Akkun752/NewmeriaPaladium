package fr.akkun.newmeriapaladium.datagen;

import fr.akkun.newmeriapaladium.NewmeriaPaladium;
import fr.akkun.newmeriapaladium.PaladiumItems;
import fr.akkun.newmeriapaladium.PaladiumMaterials;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.concurrent.CompletableFuture;

public class PaladiumItemTagsProvider extends ItemTagsProvider {
    public PaladiumItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, NewmeriaPaladium.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(PaladiumMaterials.PALADIUM_TOOL_MATERIALS).add(rk(PaladiumItems.PALADIUM_INGOT));

        // The vanilla tool and armor tags decide which enchantments the items take.
        tag(ItemTags.SWORDS).add(rk(PaladiumItems.PALADIUM_SWORD));
        tag(ItemTags.PICKAXES).add(rk(PaladiumItems.PALADIUM_PICKAXE), rk(PaladiumItems.PALADIUM_HAMMER));
        tag(ItemTags.SHOVELS).add(rk(PaladiumItems.PALADIUM_SHOVEL));
        tag(ItemTags.AXES).add(rk(PaladiumItems.PALADIUM_AXE));
        tag(ItemTags.HOES).add(rk(PaladiumItems.PALADIUM_HOE));
        tag(ItemTags.HEAD_ARMOR).add(rk(PaladiumItems.PALADIUM_HELMET));
        tag(ItemTags.CHEST_ARMOR).add(rk(PaladiumItems.PALADIUM_CHESTPLATE));
        tag(ItemTags.LEG_ARMOR).add(rk(PaladiumItems.PALADIUM_LEGGINGS));
        tag(ItemTags.FOOT_ARMOR).add(rk(PaladiumItems.PALADIUM_BOOTS));
    }

    private static net.minecraft.resources.ResourceKey<Item> rk(DeferredItem<Item> item) {
        return PaladiumItems.getRK(item.get());
    }
}
