package io.github.dockyardmc.protocol.packets.play.clientbound

import io.github.dockyardmc.entity.Entity
import io.github.dockyardmc.extentions.writeVarInt
import io.github.dockyardmc.location.Location
import io.github.dockyardmc.protocol.packets.ClientboundPacket
import io.github.dockyardmc.utils.MathUtils

class ClientboundUpdateEntityPositionPacket(val entity: Entity, previousLocation: Location): ClientboundPacket(0x2C) {

    init {
        val current = entity.location

        data.writeVarInt(entity.entityId)
        data.writeShort(MathUtils.getRelativeCoords(current.x, previousLocation.x))
        data.writeShort(MathUtils.getRelativeCoords(current.y, previousLocation.y))
        data.writeShort(MathUtils.getRelativeCoords(current.z, previousLocation.z))
        data.writeBoolean(entity.isOnGround)
    }
}