package dev.rndmorris.hqmkeybind.common.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import dev.rndmorris.hqmkeybind.HqmKeybind;
import dev.rndmorris.hqmkeybind.common.network.handlers.HandlerOpenQuestbook;
import dev.rndmorris.hqmkeybind.common.network.packets.PacketOpenQuestbook;

public abstract class PacketManager {

    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE
        .newSimpleChannel(HqmKeybind.NAME.toLowerCase());

    public static void init() {
        INSTANCE.registerMessage(HandlerOpenQuestbook.class, PacketOpenQuestbook.class, 0, Side.SERVER);
    }
}
