package org.wdfeer.evil_beetroot.entity

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.minecraft.server.MinecraftServer
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.stat.Stats
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import org.wdfeer.evil_beetroot.entity.SmallBeetroot.Companion.TYPE
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration

object BeetrootBossSpawner {
    fun onSmallBeetrootKilled(killer: ServerPlayerEntity) {
        val numberKilled: Int = killer.statHandler.getStat(Stats.KILLED, TYPE)
        if (numberKilled > 19 && numberKilled % 20 == 0){
            trigger(killer)
        }
    }

    private val SUMMON_TIME: Duration = 30.toDuration(DurationUnit.SECONDS);

    fun trigger(player: ServerPlayerEntity) {
        val server: MinecraftServer = player.server

        server.playerManager.playerList.forEach {
            p -> p.sendMessage(Text.translatable("evil_beetroot.boss_triggered")
                .formatted(Formatting.DARK_RED))
        }

        GlobalScope.launch {
            delay(SUMMON_TIME)
            summon(player)
        }
    }

    private fun summon(target: ServerPlayerEntity) {
        val boss = BeetrootBoss(target.world)
        boss.setPos(target.pos.x, target.pos.y, target.pos.z)

        target.entityWorld.spawnEntity(boss)
    }
}

