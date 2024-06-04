package io.github.dockyardmc.events

import io.github.dockyardmc.annotations.EventDocumentation
import io.github.dockyardmc.location.Location
import io.github.dockyardmc.player.Player
import io.github.dockyardmc.registry.Block

@EventDocumentation("when player places a block", true)
class PlayerBlockPlaceEvent(val player: Player, var block: Block, var location: Location): Event