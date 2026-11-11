package fr.akkun.newmeriapaladium;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class PaladiumCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NewmeriaPaladium.MOD_ID);

    /**
     * Admin tab of the Paladium items. Always shown: the creative inventory is only reachable in creative
     * mode, which only admins can switch to on the server.
     */
    public static final Supplier<CreativeModeTab> PALADIUM_ADMIN_TAB = CREATIVE_MODE_TABS.register("paladium_admin_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(PaladiumItems.PALADIUM_INGOT.get()))
                    .title(Component.translatable("creativetab.newmeriapaladium.paladium_admin"))
                    .withTabsBefore(Identifier.fromNamespaceAndPath("newmeriacore", "newmeria_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(PaladiumItems.PALADIUM_INGOT);
                        output.accept(PaladiumItems.PALADIUM_ORE);
                        output.accept(PaladiumItems.PALADIUM_BLOCK);

                        output.accept(PaladiumItems.PALADIUM_SWORD);
                        output.accept(PaladiumItems.PALADIUM_PICKAXE);
                        output.accept(PaladiumItems.PALADIUM_SHOVEL);
                        output.accept(PaladiumItems.PALADIUM_AXE);
                        output.accept(PaladiumItems.PALADIUM_HOE);
                        output.accept(PaladiumItems.PALADIUM_HAMMER);

                        output.accept(PaladiumItems.PALADIUM_HELMET);
                        output.accept(PaladiumItems.PALADIUM_CHESTPLATE);
                        output.accept(PaladiumItems.PALADIUM_LEGGINGS);
                        output.accept(PaladiumItems.PALADIUM_BOOTS);
                    }).build());
}
