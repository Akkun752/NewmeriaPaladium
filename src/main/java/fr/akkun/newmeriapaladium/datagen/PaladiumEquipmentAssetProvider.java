package fr.akkun.newmeriapaladium.datagen;

import fr.akkun.newmeriapaladium.NewmeriaPaladium;
import fr.akkun.newmeriapaladium.PaladiumMaterials;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/** How the Paladium armor looks when worn: equipment/paladium.json. */
public class PaladiumEquipmentAssetProvider implements DataProvider {
    private final PackOutput.PathProvider pathProvider;

    public PaladiumEquipmentAssetProvider(PackOutput packOutput) {
        this.pathProvider = packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "equipment");
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        Identifier texture = Identifier.fromNamespaceAndPath(NewmeriaPaladium.MOD_ID, "paladium");
        // Only the two layers the old Newmeria Mod had (textures/entity/equipment/humanoid and
        // humanoid_leggings). Not addHumanoidLayers(), which also asks for a humanoid_baby texture:
        // without one, baby zombies would wear a missing texture; this way they just don't show it.
        EquipmentClientInfo paladium = EquipmentClientInfo.builder()
                .addLayers(EquipmentClientInfo.LayerType.HUMANOID, new EquipmentClientInfo.Layer(texture))
                .addLayers(EquipmentClientInfo.LayerType.HUMANOID_LEGGINGS, new EquipmentClientInfo.Layer(texture))
                .build();
        return DataProvider.saveAll(cache, EquipmentClientInfo.CODEC, this.pathProvider::json,
                Map.of(PaladiumMaterials.PALADIUM_ASSET_ID, paladium));
    }

    @Override
    public String getName() {
        return "Newmeria Paladium Equipment Definitions";
    }
}
