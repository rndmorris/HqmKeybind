package dev.rndmorris.hqmkeybind.client;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import dev.rndmorris.hqmkeybind.common.CommonProxy;

public class ClientProxy extends CommonProxy {

    public KeyBindings keyBindings;

    // Override CommonProxy methods here, if you want a different behaviour on the client (e.g. registering renders).
    // Don't forget to call the super methods as well.

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        registerKeyBindings();
    }

    public void registerKeyBindings() {
        keyBindings = new KeyBindings();
        FMLCommonHandler.instance()
            .bus()
            .register(keyBindings);
    }
}
