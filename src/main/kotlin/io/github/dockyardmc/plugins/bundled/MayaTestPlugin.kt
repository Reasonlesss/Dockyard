package io.github.dockyardmc.plugins.bundled

import io.github.dockyardmc.DockyardServer
import io.github.dockyardmc.ServerMetrics
import io.github.dockyardmc.extentions.truncate
import io.github.dockyardmc.periodic.Period
import io.github.dockyardmc.periodic.TickPeriod
import io.github.dockyardmc.plugins.DockyardPlugin
import io.github.dockyardmc.utils.MathUtils

class MayaTestPlugin: DockyardPlugin {
    override var name: String = "MayaTestPlugin"
    override var author: String = "LukynkaCZE"
    override var version: String = DockyardServer.versionInfo.dockyardVersion

    override fun load(server: DockyardServer) {

        Period.on<TickPeriod> {
            val runtime = Runtime.getRuntime()
            val mspt = ServerMetrics.millisecondsPerTick
            val memoryUsage = runtime.totalMemory() - runtime.freeMemory()
            val memUsagePercent = MathUtils.percent(runtime.totalMemory().toDouble(), memoryUsage.toDouble()).truncate(0)

            val fMem = (memoryUsage.toDouble() / 1000000).truncate(1)
            val fMax = (runtime.totalMemory().toDouble() / 1000000).truncate(1)
            DockyardServer.broadcastActionBar("<white>MSPT: <lime>$mspt <dark_gray>| <white>Memory Usage: <#ff6830>$memUsagePercent% <gray>(${fMem}mb / ${fMax}mb)")
        }
    }

    override fun unload(server: DockyardServer) {
        TODO("Not yet implemented")
    }
}