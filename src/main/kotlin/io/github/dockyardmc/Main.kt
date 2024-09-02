package io.github.dockyardmc

import io.github.dockyardmc.commands.Commands
import io.github.dockyardmc.commands.getCommandList
import io.github.dockyardmc.datagen.EventsDocumentationGenerator
import io.github.dockyardmc.datagen.VerifyPacketIds
import io.github.dockyardmc.events.Events
import io.github.dockyardmc.events.PlayerJoinEvent
import io.github.dockyardmc.player.*
import io.github.dockyardmc.protocol.packets.play.clientbound.ClientboundCommandsPacket
import io.github.dockyardmc.registry.*
import io.github.dockyardmc.utils.DebugScoreboard

// This is just maya testing env.. do not actually run this
fun main(args: Array<String>) {

    if(args.contains("validate-packets")) {
        VerifyPacketIds()
        return
    }

    if(args.contains("event-documentation")) {
        EventsDocumentationGenerator()
        return
    }

//    val testWorld = WorldManager.create("test", FlatWorldGenerator(), DimensionTypes.OVERWORLD)
//    testWorld.defaultSpawnLocation = Location(0, 201, 0, testWorld)
//
//    Events.on<PlayerPreSpawnWorldSelectionEvent> {
//        it.world = testWorld
//    }

    Events.on<PlayerJoinEvent> {
        val player = it.player
        player.gameMode.value = GameMode.CREATIVE
        player.inventory[0] = Items.CHERRY_TRAPDOOR.toItemStack()
        DebugScoreboard.sidebar.viewers.add(player)
        player.addPotionEffect(PotionEffects.NIGHT_VISION, 99999, 0, false)
        player.addPotionEffect(PotionEffects.SPEED, 99999, 3, false)
        if(player.username == "LukynkaCZE") {
            player.permissions.add("dockyard.all")
        }
    }

    Commands.add("/test") {
        it.execute { ctx ->
            val player = ctx.playerOrThrow()
            player.sendPacket(ClientboundCommandsPacket(getCommandList()))
        }
    }

    val server = DockyardServer()
    server.start()
}