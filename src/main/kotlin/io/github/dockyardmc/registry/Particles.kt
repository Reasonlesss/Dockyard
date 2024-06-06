package io.github.dockyardmc.registry
import io.github.dockyardmc.utils.Resources
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
// THIS CLASS IS AUTO-GENERATED
// DATA FROM MINECRAFT 1.20.4
// https://github.com/DockyardMC/RegistryClassesGenerators

object Particles {
    private val idToParticleMap by lazy {
        val json = Json { ignoreUnknownKeys = true }
        val particles = json.decodeFromString<MutableList<Particle>>(Resources.getText("./data/particles.json"))
        particles.associateBy { it.id }
    }
    fun getParticleById(id: Int): Particle {
        return idToParticleMap[id] ?: error("Particle ID $id not found")
    }
    val AMBIENT_ENTITY_EFFECT = getParticleById(0)
    val ANGRY_VILLAGER = getParticleById(1)
    val BLOCK = getParticleById(2)
    val BLOCK_MARKER = getParticleById(3)
    val BUBBLE = getParticleById(4)
    val CLOUD = getParticleById(5)
    val CRIT = getParticleById(6)
    val DAMAGE_INDICATOR = getParticleById(7)
    val DRAGON_BREATH = getParticleById(8)
    val DRIPPING_LAVA = getParticleById(9)
    val FALLING_LAVA = getParticleById(10)
    val LANDING_LAVA = getParticleById(11)
    val DRIPPING_WATER = getParticleById(12)
    val FALLING_WATER = getParticleById(13)
    val DUST = getParticleById(14)
    val DUST_COLOR_TRANSITION = getParticleById(15)
    val EFFECT = getParticleById(16)
    val ELDER_GUARDIAN = getParticleById(17)
    val ENCHANTED_HIT = getParticleById(18)
    val ENCHANT = getParticleById(19)
    val END_ROD = getParticleById(20)
    val ENTITY_EFFECT = getParticleById(21)
    val EXPLOSION_EMITTER = getParticleById(22)
    val EXPLOSION = getParticleById(23)
    val GUST = getParticleById(24)
    val GUST_EMITTER = getParticleById(25)
    val SONIC_BOOM = getParticleById(26)
    val FALLING_DUST = getParticleById(27)
    val FIREWORK = getParticleById(28)
    val FISHING = getParticleById(29)
    val FLAME = getParticleById(30)
    val CHERRY_LEAVES = getParticleById(31)
    val SCULK_SOUL = getParticleById(32)
    val SCULK_CHARGE = getParticleById(33)
    val SCULK_CHARGE_POP = getParticleById(34)
    val SOUL_FIRE_FLAME = getParticleById(35)
    val SOUL = getParticleById(36)
    val FLASH = getParticleById(37)
    val HAPPY_VILLAGER = getParticleById(38)
    val COMPOSTER = getParticleById(39)
    val HEART = getParticleById(40)
    val INSTANT_EFFECT = getParticleById(41)
    val ITEM = getParticleById(42)
    val VIBRATION = getParticleById(43)
    val ITEM_SLIME = getParticleById(44)
    val ITEM_SNOWBALL = getParticleById(45)
    val LARGE_SMOKE = getParticleById(46)
    val LAVA = getParticleById(47)
    val MYCELIUM = getParticleById(48)
    val NOTE = getParticleById(49)
    val POOF = getParticleById(50)
    val PORTAL = getParticleById(51)
    val RAIN = getParticleById(52)
    val SMOKE = getParticleById(53)
    val WHITE_SMOKE = getParticleById(54)
    val SNEEZE = getParticleById(55)
    val SPIT = getParticleById(56)
    val SQUID_INK = getParticleById(57)
    val SWEEP_ATTACK = getParticleById(58)
    val TOTEM_OF_UNDYING = getParticleById(59)
    val UNDERWATER = getParticleById(60)
    val SPLASH = getParticleById(61)
    val WITCH = getParticleById(62)
    val BUBBLE_POP = getParticleById(63)
    val CURRENT_DOWN = getParticleById(64)
    val BUBBLE_COLUMN_UP = getParticleById(65)
    val NAUTILUS = getParticleById(66)
    val DOLPHIN = getParticleById(67)
    val CAMPFIRE_COSY_SMOKE = getParticleById(68)
    val CAMPFIRE_SIGNAL_SMOKE = getParticleById(69)
    val DRIPPING_HONEY = getParticleById(70)
    val FALLING_HONEY = getParticleById(71)
    val LANDING_HONEY = getParticleById(72)
    val FALLING_NECTAR = getParticleById(73)
    val FALLING_SPORE_BLOSSOM = getParticleById(74)
    val ASH = getParticleById(75)
    val CRIMSON_SPORE = getParticleById(76)
    val WARPED_SPORE = getParticleById(77)
    val SPORE_BLOSSOM_AIR = getParticleById(78)
    val DRIPPING_OBSIDIAN_TEAR = getParticleById(79)
    val FALLING_OBSIDIAN_TEAR = getParticleById(80)
    val LANDING_OBSIDIAN_TEAR = getParticleById(81)
    val REVERSE_PORTAL = getParticleById(82)
    val WHITE_ASH = getParticleById(83)
    val SMALL_FLAME = getParticleById(84)
    val SNOWFLAKE = getParticleById(85)
    val DRIPPING_DRIPSTONE_LAVA = getParticleById(86)
    val FALLING_DRIPSTONE_LAVA = getParticleById(87)
    val DRIPPING_DRIPSTONE_WATER = getParticleById(88)
    val FALLING_DRIPSTONE_WATER = getParticleById(89)
    val GLOW_SQUID_INK = getParticleById(90)
    val GLOW = getParticleById(91)
    val WAX_ON = getParticleById(92)
    val WAX_OFF = getParticleById(93)
    val ELECTRIC_SPARK = getParticleById(94)
    val SCRAPE = getParticleById(95)
    val SHRIEK = getParticleById(96)
    val EGG_CRACK = getParticleById(97)
    val DUST_PLUME = getParticleById(98)
    val GUST_DUST = getParticleById(99)
    val TRIAL_SPAWNER_DETECTION = getParticleById(100)
}
@Serializable
data class Particle(
    val id: Int,
    @SerialName("name")
    val namespace: String
)