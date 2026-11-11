package fr.akkun.newmeriapaladium;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

/**
 * Newmeria's Paladium: ore, ingot, block, tools, hammer and armor, taken over from the old Newmeria Mod.
 * Installed on the server and on the players' computers.
 *
 * <p>Unlike the other Newmeria mods, whose items are registered by NewmeriaCore, the Paladium items
 * belong to this mod (namespace {@value #MOD_ID}). They are shown in their own creative tab (see
 * {@link PaladiumCreativeModeTabs}).
 */
// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(NewmeriaPaladium.MOD_ID)
public class NewmeriaPaladium {
    public static final String MOD_ID = "newmeriapaladium";
    public static final Logger LOGGER = LogUtils.getLogger();

    public NewmeriaPaladium(IEventBus modEventBus, ModContainer modContainer) {
        PaladiumBlocks.BLOCKS.register(modEventBus);
        PaladiumItems.ITEMS.register(modEventBus);
        PaladiumCreativeModeTabs.CREATIVE_MODE_TABS.register(modEventBus);
    }
}
