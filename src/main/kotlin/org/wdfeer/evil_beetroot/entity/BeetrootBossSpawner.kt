package org.wdfeer.evil_beetroot.entity

import kotlinx.coroutines.*
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
import net.minecraft.server.MinecraftServer
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.stat.Stats
import net.minecraft.text.MutableText
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.math.random.Random
import org.wdfeer.evil_beetroot.config.BeetConfig
import org.wdfeer.evil_beetroot.entity.SmallBeetroot.Companion.TYPE

object BeetrootBossSpawner {
    fun initialize() {
        ServerLifecycleEvents.SERVER_STOPPED.register { coroutineScope?.cancel() }
    }

    fun onSmallBeetrootKilled(killer: ServerPlayerEntity) {
        val numberKilled: Int = killer.statHandler.getStat(Stats.KILLED, TYPE)
        if (numberKilled > 0 && numberKilled % BeetConfig.BOSS_TRIGGER_KILLS == 0){
            trigger(killer)
        }
    }

    fun trigger(player: ServerPlayerEntity) {
        fun getText(): MutableText {
            return (if (Random.createLocal().nextBoolean())
                Text.translatable("evil_beetroot.boss_triggered1")
            else
                Text.translatable("evil_beetroot.boss_triggered2")).formatted(Formatting.DARK_RED)
        }

        val server: MinecraftServer = player.server
        val text: Text = getText()
        server.playerManager.playerList.forEach { p ->
            p.sendMessage(text)
        }

        summonWithTimer(server, player)
    }

    private var coroutineScope: CoroutineScope? = null

    private fun summonWithTimer(server: MinecraftServer, target: ServerPlayerEntity) {
        coroutineScope = CoroutineScope(server.asCoroutineDispatcher() + SupervisorJob())
        coroutineScope!!.launch {
            delay(BeetConfig.BOSS_SUMMON_TIME)
            summon(target)
        }
    }

    private fun summon(target: ServerPlayerEntity) {
        val boss = BeetrootBoss(target.world)
        boss.setPos(target.pos.x, target.pos.y, target.pos.z)

        target.entityWorld.spawnEntity(boss)
    }
}

