package io.github.dockyardmc.protocol.packets.handshake

import io.github.dockyardmc.annotations.ServerboundPacketInfo
import io.github.dockyardmc.protocol.PacketProcessor
import io.github.dockyardmc.protocol.packets.ProtocolState
import io.github.dockyardmc.protocol.packets.ServerboundPacket
import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext

@ServerboundPacketInfo(1, ProtocolState.STATUS)
class ServerboundPingRequestPacket(val time: Long): ServerboundPacket {

    companion object {
        fun read(buf: ByteBuf): ServerboundPingRequestPacket {
            return ServerboundPingRequestPacket(buf.readLong())
        }
    }

    override fun handle(processor: PacketProcessor, connection: ChannelHandlerContext, size: Int, id: Int) {
        processor.statusHandler.handlePing(this, connection)
    }
}