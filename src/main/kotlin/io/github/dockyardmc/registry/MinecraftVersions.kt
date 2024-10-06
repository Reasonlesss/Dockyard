package io.github.dockyardmc.registry

object MinecraftVersions {
    val v1_21 = MinecraftVersion(767, "1.21")
    val v1_20_6 = MinecraftVersion(766, "1.20.6")
    val v1_20_5 = MinecraftVersion(766, "1.20.5")
    val v1_20_4 = MinecraftVersion(765, "1.20.4")
    val v1_20_3 = MinecraftVersion(765, "1.20.3")
    val v1_20_2 = MinecraftVersion(764, "1.20.2")
    val v1_20_1 = MinecraftVersion(763, "1.20.1")
    val v1_20 = MinecraftVersion(763, "1.20")
    val v1_19_4 = MinecraftVersion(762, "1.19.4")
    val v1_19_3 = MinecraftVersion(761, "1.19.3")
    val v1_19_2 = MinecraftVersion(760, "1.19.2")
    val v1_19_1 = MinecraftVersion(760, "1.19.1")
    val v1_19 = MinecraftVersion(759, "1.19")
    val v1_18_2 = MinecraftVersion(758, "1.18.2")
    val v1_18_1 = MinecraftVersion(757, "1.18.1")
    val v1_18 = MinecraftVersion(757, "1.18")
    val v1_17_1 = MinecraftVersion(756, "1.17.1")
    val v1_17 = MinecraftVersion(755, "1.17")
    val v1_16_5 = MinecraftVersion(754, "1.16.5")
    val v1_16_4 = MinecraftVersion(754, "1.16.4")
    val v1_16_3 = MinecraftVersion(753, "1.16.3")
    val v1_16_2 = MinecraftVersion(751, "1.16.2")
    val v1_16_1 = MinecraftVersion(736, "1.16.1")
    val v1_16 = MinecraftVersion(735, "1.16")
    val v1_15_2 = MinecraftVersion(578, "1.15.2")
    val v1_15_1 = MinecraftVersion(575, "1.15.1")
    val v1_15 = MinecraftVersion(573, "1.15")
    val v1_14_4 = MinecraftVersion(498, "1.14.4")
    val v1_14_3 = MinecraftVersion(490, "1.14.3")
    val v1_14_2 = MinecraftVersion(485, "1.14.2")
    val v1_14_1 = MinecraftVersion(480, "1.14.1")
    val v1_14 = MinecraftVersion(477, "1.14")
    val v1_13_2 = MinecraftVersion(404, "1.13.2")
    val v1_13_1 = MinecraftVersion(401, "1.13.1")
    val v1_13 = MinecraftVersion(393, "1.13")
    val v1_12_2 = MinecraftVersion(340, "1.12.2")
    val v1_12_1 = MinecraftVersion(338, "1.12.1")
    val v1_12 = MinecraftVersion(335, "1.12")
    val v1_11_2 = MinecraftVersion(316, "1.11.2")
    val v1_11_1 = MinecraftVersion(921, "1.11.1")
    val v1_11 = MinecraftVersion(315, "1.11")
    val v1_10_2 = MinecraftVersion(210, "1.10.2")
    val v1_10_1 = MinecraftVersion(511, "1.10.1")
    val v1_10 = MinecraftVersion(510, "1.10")
    val v1_9_4 = MinecraftVersion(110, "1.9.4")
    val v1_9_3 = MinecraftVersion(183, "1.9.3")
    val v1_9_2 = MinecraftVersion(176, "1.9.2")
    val v1_9_1 = MinecraftVersion(108, "1.9.1")
    val v1_9 = MinecraftVersion(169, "1.9")
    val v1_8_9 = MinecraftVersion( 47, "1.8.9")
}

data class MinecraftVersion(val protocolId: Int, val versionName: String)