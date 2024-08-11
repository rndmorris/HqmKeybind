package dev.rndmorris.hqmkeybind.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import dev.rndmorris.hqmkeybind.common.network.PacketManager;
import dev.rndmorris.hqmkeybind.common.network.packets.PacketOpenQuestbook;

public class KeyBindings {

    public final static int BACKTICK_KEYCODE = 41;

    public final KeyBinding questbookKey = new KeyBinding("Open Questbook", BACKTICK_KEYCODE, "key.categories.misc");

    public KeyBindings() {
        ClientRegistry.registerKeyBinding(questbookKey);
    }

    @SubscribeEvent
    public void onKeyPressed(InputEvent.KeyInputEvent event) {
        if (!questbookKey.isPressed()) {
            return;
        }
        final var player = Minecraft.getMinecraft().thePlayer;
        PacketManager.INSTANCE
            .sendToServer(new PacketOpenQuestbook(player.getEntityId(), player.worldObj.provider.dimensionId));
    }
}
