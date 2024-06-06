package io.github.dockyardmc.protocol.packets.play.serverbound

import io.github.dockyardmc.DockyardServer
import io.github.dockyardmc.inventory.ItemStack
import io.github.dockyardmc.protocol.PacketProcessor
import io.github.dockyardmc.protocol.packets.ServerboundPacket
import io.github.dockyardmc.registry.Items
import io.github.dockyardmc.utils.MathUtils
import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext

class ServerboundSetCreativeModeSlotPacket(var slot: Int, var clickedItem: SlotData): ServerboundPacket {

    override fun handle(processor: PacketProcessor, connection: ChannelHandlerContext, size: Int, id: Int) {

        val player = processor.player
        val correctSlot = MathUtils.toCorrectSlotIndex(slot)
        // item removed if present is not set
        if(!clickedItem.present) {
            player.inventory.set(correctSlot, ItemStack.air)
            return
        }
        
        player.inventory.set(correctSlot, ItemStack(Items.getItemById(clickedItem.itemId!!), clickedItem.itemCount!!))

        DockyardServer.broadcastMessage("<yellow>$player<gray> clicked slot <lime>$correctSlot<gray> with <aqua>${clickedItem.itemId}")

    }

    companion object {
        fun read(buf: ByteBuf): ServerboundSetCreativeModeSlotPacket {
            val packet = ServerboundSetCreativeModeSlotPacket(buf.readShort().toInt(), buf.readSlotData());
            buf.clear()
            return packet
        }
    }
}