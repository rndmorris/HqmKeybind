package dev.rndmorris.hqmkeybind.common.network.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.DimensionManager;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import dev.rndmorris.hqmkeybind.common.network.packets.PacketOpenQuestbook;
import hardcorequesting.items.ItemQuestBook;
import hardcorequesting.items.ModItems;

public class HandlerOpenQuestbook implements IMessageHandler<PacketOpenQuestbook, IMessage> {

    private static ItemQuestBook questbook;
    private static ItemStack questbookItemStack;

    private ItemQuestBook getQuestBook() {
        if (questbook == null) {
            questbook = (ItemQuestBook) ModItems.book;
        }
        return questbook;
    }

    private ItemStack getQuestbookItemStack() {
        if (questbookItemStack == null) {
            questbookItemStack = new ItemStack(getQuestBook(), 1, 0);
        }
        return questbookItemStack;
    }

    @Override
    public IMessage onMessage(PacketOpenQuestbook message, MessageContext ctx) {
        final var world = DimensionManager.getWorld(message.getDimensionId());
        if (world == null) {
            return null;
        }
        final var entity = world.getEntityByID(message.getPlayerId());
        if (!(entity instanceof EntityPlayer player)) {
            return null;
        }
        getQuestBook().onItemRightClick(getQuestbookItemStack(), world, player);
        return null;
    }
}
