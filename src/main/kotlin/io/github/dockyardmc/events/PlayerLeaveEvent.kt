package io.github.dockyardmc.events

import io.github.dockyardmc.annotations.EventDocumentation
import io.github.dockyardmc.player.Player

@EventDocumentation("when player leaves the server (during PLAY phase)", false)
class PlayerLeaveEvent(val player: Player): Event {
    override val context = elements(player)
}