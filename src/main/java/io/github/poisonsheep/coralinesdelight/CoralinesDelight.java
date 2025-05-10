package io.github.poisonsheep.coralinesdelight;

import com.mojang.logging.LogUtils;
import io.github.poisonsheep.coralinesdelight.registry.BlockRegistry;
import io.github.poisonsheep.coralinesdelight.registry.ItemRegistry;
import io.github.poisonsheep.coralinesdelight.registry.TabRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CoralinesDelight.MODID)
public class CoralinesDelight
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "coralines_delight";

    public static final Logger LOGGER = LogManager.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public CoralinesDelight() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        TabRegistry.TABS.register(modEventBus);
        ItemRegistry.ITEMS.register(modEventBus);
        BlockRegistry.BLOCKS.register(modEventBus);
    }

}
