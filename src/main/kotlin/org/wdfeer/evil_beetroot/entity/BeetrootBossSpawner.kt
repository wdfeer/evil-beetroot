package org.wdfeer.evil_beetroot.entity

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.minecraft.server.MinecraftServer
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.stat.Stats
import net.minecraft.text.Text
import org.wdfeer.evil_beetroot.entity.SmallBeetroot.Companion.TYPE

object BeetrootBossSpawner {
    fun onSmallBeetrootKilled(killer: ServerPlayerEntity) {
        val numberKilled: Int = killer.statHandler.getStat(Stats.KILLED, TYPE)
        if (numberKilled > 19 && numberKilled % 20 == 0){
            trigger(killer)
        }
    }

    fun trigger(player: ServerPlayerEntity) {
        val server: MinecraftServer = player.server

        server.sendMessage(Text.translatable("evil_beetroot.boss_triggered"))

        GlobalScope.launch {
            delay(30000)
            summon(player)
        }
    }

    private fun summon(target: ServerPlayerEntity) {
        val boss = BeetrootBoss(target.world)
        boss.setPos(target.pos.x, target.pos.y, target.pos.z)

        target.entityWorld.spawnEntity(boss)
    }
}

