package org.wdfeer.evil_beetroot.config

import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration

object BeetConfig { // TODO: Make this an actual Config
    const val SMALL_BEETROOT_SPAWN_CHANCE: Float = 0.04f
    const val SMALL_BEETROOT_SENTIENT_DROP_CHANCE: Float = 0.2f

    const val PHANTOM_SPAWN_CHANCE: Float = 1f // TODO: set to a reasonable value
    const val PHANTOM_SENTIENT_DROP_CHANCE: Float = 0.4f

    const val BOSS_TRIGGER_KILLS: Int = 20
    val BOSS_SUMMON_TIME: Duration = 30.toDuration(DurationUnit.SECONDS)

    val BOSS_SENTIENT_DROP_COUNT: IntRange = 0..2
    const val BOSS_HEART_DROP_CHANCE: Float = 1f

    const val SWORDS_HEAL: Float = 1f
    const val TOOLS_FEED_CHANCE: Float = 0.1f
    const val REPAIR_PER_BEETROOT: Int = 10
}
