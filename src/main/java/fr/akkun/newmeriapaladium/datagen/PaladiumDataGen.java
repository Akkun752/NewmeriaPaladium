package fr.akkun.newmeriapaladium.datagen;

import fr.akkun.newmeriapaladium.NewmeriaPaladium;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Set;

/** Run with the "data" Gradle run: writes into src/generated/resources. */
@EventBusSubscriber(modid = NewmeriaPaladium.MOD_ID)
public class PaladiumDataGen {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        event.createProvider(PaladiumModelProvider::new);
        event.createProvider(PaladiumEquipmentAssetProvider::new);

        // Loot tables, recipes and the advancements unlocking them are "reloadable registry" content since 26.3.
        event.createReloadableRegistryObjects(new RegistrySetBuilder()
                .add(Registries.LOOT_TABLE, new LootTableProvider(Set.of(), List.of(
                        new LootTableProvider.SubProviderEntry(PaladiumBlockLootTableProvider::new, LootContextParamSets.BLOCK))))
                .add(RecipeProvider.asBootstrap(PaladiumRecipeProvider::new)),
                Set.of(NewmeriaPaladium.MOD_ID));

        event.createBlockAndItemTags(PaladiumBlockTagsProvider::new, (output, lookup, blockTags) -> new PaladiumItemTagsProvider(output, lookup));
    }
}
