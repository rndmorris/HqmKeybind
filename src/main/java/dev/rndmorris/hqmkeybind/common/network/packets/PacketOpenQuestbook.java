package dev.rndmorris.hqmkeybind.common.network.packets;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class PacketOpenQuestbook implements IMessage {

    private int playerId;
    private int dimensionId;

    public PacketOpenQuestbook() {}

    public PacketOpenQuestbook(int playerId, int worldId) {
        this.playerId = playerId;
        this.dimensionId = worldId;
    }

    public int getPlayerId() {
        return this.playerId;
    }

    public int getDimensionId() {
        return this.dimensionId;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.playerId = buf.readInt();
        this.dimensionId = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.playerId);
        buf.writeInt(this.dimensionId);
    }
}
