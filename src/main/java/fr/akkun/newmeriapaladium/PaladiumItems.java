package fr.akkun.newmeriapaladium;

import fr.akkun.newmeriacore.item.HammerItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static fr.akkun.newmeriapaladium.PaladiumMaterials.PALADIUM_ARMOR;
import static fr.akkun.newmeriapaladium.PaladiumMaterials.PALADIUM_TOOL;

/** The Paladium items, with the stats of the old Newmeria Mod. They belong to this mod, not to NewmeriaCore. */
public class PaladiumItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NewmeriaPaladium.MOD_ID);

    public static final DeferredItem<Item> PALADIUM_INGOT = ITEMS.registerItem("paladium_ingot", Item::new);

    public static final DeferredItem<Item> PALADIUM_ORE = ITEMS.registerItem("paladium_ore",
            properties -> new BlockItem(PaladiumBlocks.PALADIUM_ORE.get(), properties.useBlockDescriptionPrefix()));
    public static final DeferredItem<Item> PALADIUM_BLOCK = ITEMS.registerItem("paladium_block",
            properties -> new BlockItem(PaladiumBlocks.PALADIUM_BLOCK.get(), properties.useBlockDescriptionPrefix()));

    public static final DeferredItem<Item> PALADIUM_SWORD = ITEMS.registerItem("paladium_sword",
            properties -> new Item(properties.sword(PALADIUM_TOOL, 3.0F, -2.4F)));
    public static final DeferredItem<Item> PALADIUM_PICKAXE = ITEMS.registerItem("paladium_pickaxe",
            properties -> new Item(properties.pickaxe(PALADIUM_TOOL, 1.0F, -2.8F)));
    public static final DeferredItem<Item> PALADIUM_SHOVEL = ITEMS.registerItem("paladium_shovel",
            properties -> new Item(properties.shovel(PALADIUM_TOOL, 1.25F, -3.0F)));
    public static final DeferredItem<Item> PALADIUM_AXE = ITEMS.registerItem("paladium_axe",
            properties -> new Item(properties.axe(PALADIUM_TOOL, 4.5F, -3.0F)));
    public static final DeferredItem<Item> PALADIUM_HOE = ITEMS.registerItem("paladium_hoe",
            properties -> new Item(properties.hoe(PALADIUM_TOOL, -3.0F, 0.0F)));
    // A NewmeriaCore hammer, so it mines 3x3 (see fr.akkun.newmeriacore.item.HammerEvents).
    // Slower and a little weaker than the pickaxe.
    public static final DeferredItem<Item> PALADIUM_HAMMER = ITEMS.registerItem("paladium_hammer",
            properties -> new HammerItem(properties.pickaxe(PALADIUM_TOOL, 0.5F, -3.2F)));

    public static final DeferredItem<Item> PALADIUM_HELMET = ITEMS.registerItem("paladium_helmet",
            properties -> new Item(properties.humanoidArmor(PALADIUM_ARMOR, ArmorType.HELMET)));
    public static final DeferredItem<Item> PALADIUM_CHESTPLATE = ITEMS.registerItem("paladium_chestplate",
            properties -> new Item(properties.humanoidArmor(PALADIUM_ARMOR, ArmorType.CHESTPLATE)));
    public static final DeferredItem<Item> PALADIUM_LEGGINGS = ITEMS.registerItem("paladium_leggings",
            properties -> new Item(properties.humanoidArmor(PALADIUM_ARMOR, ArmorType.LEGGINGS)));
    public static final DeferredItem<Item> PALADIUM_BOOTS = ITEMS.registerItem("paladium_boots",
            properties -> new Item(properties.humanoidArmor(PALADIUM_ARMOR, ArmorType.BOOTS)));

    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }
}
