package dev.rndmorris.hqmkeybind;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import dev.rndmorris.hqmkeybind.common.CommonProxy;

@Mod(
    modid = HqmKeybind.MODID,
    version = HqmKeybind.VERSION,
    name = HqmKeybind.NAME,
    dependencies = HqmKeybind.DEPS,
    acceptedMinecraftVersions = "[1.7.10]")
public class HqmKeybind {

    public static final String DEPS = "after:HardcoreQuesting";
    public static final String MODID = "hqmkeybind";
    public static final String NAME = "HQM Keybind";
    public static final String VERSION = "1.7.10-A2";
    public static final Logger LOG = LogManager.getLogger(MODID);

    @SidedProxy(
        clientSide = "dev.rndmorris.hqmkeybind.client.ClientProxy",
        serverSide = "dev.rndmorris.hqmkeybind.common.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }
}
