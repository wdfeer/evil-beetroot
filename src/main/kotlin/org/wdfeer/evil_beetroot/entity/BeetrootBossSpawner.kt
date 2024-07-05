package org.wdfeer.evil_beetroot.entity

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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
    fun onSmallBeetrootKilled(killer: ServerPlayerEntity) {
        val numberKilled: Int = killer.statHandler.getStat(Stats.KILLED, TYPE)
        if (numberKilled > 0 && numberKilled % BeetConfig.BOSS_TRIGGER_KILLS == 0){
            trigger(killer)
        }
    }
    
    @OptIn(DelicateCoroutinesApi::class)
    fun trigger(player: ServerPlayerEntity) {
        fun getText(): MutableText {
            return if (Random.createLocal().nextBoolean())
                Text.translatable("evil_beetroot.boss_triggered1")
            else
                Text.translatable("evil_beetroot.boss_triggered2")
        }
        
        val server: MinecraftServer = player.server

        server.playerManager.playerList.forEach {
            p -> p.sendMessage(getText().formatted(Formatting.DARK_RED))
        }

        GlobalScope.launch {
            delay(BeetConfig.BOSS_SUMMON_TIME)
            summon(player)
        }
    }

    private fun summon(target: ServerPlayerEntity) {
        val boss = BeetrootBoss(target.world)
        boss.setPos(target.pos.x, target.pos.y, target.pos.z)

        target.entityWorld.spawnEntity(boss)
    }
}

