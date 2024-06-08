package io.github.dockyardmc

import CustomLogType
import io.github.dockyardmc.annotations.AnnotationProcessor
import io.github.dockyardmc.events.Events
import io.github.dockyardmc.events.PlayerJoinEvent
import io.github.dockyardmc.events.PlayerLeaveEvent
import io.github.dockyardmc.events.PlayerMoveEvent
import io.github.dockyardmc.player.*
import io.github.dockyardmc.protocol.PacketParser
import io.github.dockyardmc.protocol.packets.play.clientbound.ClientboundUpdateEntityPositionPacket

val TCP = CustomLogType("\uD83E\uDD1D TCP", AnsiPair.GRAY)

object Main {
    lateinit var instance: DockyardServer
}

fun main(args: Array<String>) {
    val port = (args.getOrNull(0) ?: "25565").toInt()
//    ResourceLeakDetector.setLevel(ResourceLeakDetector.Level.ADVANCED)

    val packetClasses = AnnotationProcessor.getServerboundPacketClassInfo()
    PacketParser.idAndStatePairToPacketClass = packetClasses

    Main.instance = DockyardServer(port)


    //TODO: Move to different class (probably player)
    Events.on<PlayerJoinEvent> {
        DockyardServer.broadcastMessage("<lime>→ <yellow>${it.player}")

        // send this player to existing players
        PlayerManager.players.forEach { loopPlayer ->
            if(loopPlayer.username == it.player.username) return@forEach
            it.player.addViewer(loopPlayer)
            loopPlayer.addViewer(it.player)
        }
    }

    //TODO: Move to different class (probably player)
    Events.on<PlayerLeaveEvent> {
        DockyardServer.broadcastMessage("<red>← <yellow>${it.player}")
    }

    //TODO: Move to somewhere else (probably player class)
    Events.on<PlayerMoveEvent> { event ->
        val player = event.player
        val packet = ClientboundUpdateEntityPositionPacket(player, event.oldLocation)
        player.viewers.forEach { it.sendPacket(packet) }
    }

    Main.instance.start()
}

