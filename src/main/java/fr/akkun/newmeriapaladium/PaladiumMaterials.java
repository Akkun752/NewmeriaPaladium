package fr.akkun.newmeriapaladium;

import com.google.common.collect.Maps;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

/** The Paladium tool and armor materials, with the stats of the old Newmeria Mod. */
public class PaladiumMaterials {
    /** What repairs Paladium tools and armor on an anvil: the Paladium Ingot. */
    public static final TagKey<Item> PALADIUM_TOOL_MATERIALS =
            TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(NewmeriaPaladium.MOD_ID, "paladium_tool_materials"));

    // Between diamond and netherite: 1800 durability, 8.5 mining speed, +3.5 attack damage,
    // enchantability 12. Same mining level as diamond (and netherite).
    public static final ToolMaterial PALADIUM_TOOL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1800, 8.5F, 3.5F, 12, PALADIUM_TOOL_MATERIALS);

    public static final ResourceKey<EquipmentAsset> PALADIUM_ASSET_ID =
            ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(NewmeriaPaladium.MOD_ID, "paladium"));

    // Durability multiplier 34, armor 3/6/8/3, enchantability 12, toughness 2.5, knockback resistance 0.05.
    public static final ArmorMaterial PALADIUM_ARMOR = new ArmorMaterial(
            34, makeDefense(3, 6, 8, 3, 11), 12, SoundEvents.ARMOR_EQUIP_NETHERITE,
            2.5F, 0.05F, PALADIUM_TOOL_MATERIALS, PALADIUM_ASSET_ID);

    private static Map<ArmorType, Integer> makeDefense(int boots, int legs, int chest, int helm, int body) {
        return Maps.newEnumMap(
                Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, legs, ArmorType.CHESTPLATE, chest, ArmorType.HELMET, helm, ArmorType.BODY, body)
        );
    }
}
