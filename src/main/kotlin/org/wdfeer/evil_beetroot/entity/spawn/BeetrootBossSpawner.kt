package org.wdfeer.evil_beetroot.entity.spawn

import kotlinx.coroutines.*
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
import net.minecraft.server.MinecraftServer
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.stat.Stats
import net.minecraft.text.MutableText
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World
import org.wdfeer.evil_beetroot.config.BeetConfig
import org.wdfeer.evil_beetroot.entity.BeetrootBoss
import org.wdfeer.evil_beetroot.entity.SmallBeetroot.Companion.TYPE
import org.wdfeer.evil_beetroot.util.*
import kotlin.math.max
import kotlin.random.Random

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
            return (if (Random.nextBoolean())
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
        setBossPosition(boss, target)
        target.entityWorld.spawnEntity(boss)
    }

    private fun setBossPosition(boss: BeetrootBoss, player: ServerPlayerEntity) {
        val world = player.world
        val pos = getRandomSpawnPosition(player.pos, world)
        boss.setPos(pos.x, pos.y, pos.z)
    }

    private const val SPAWN_DISTANCE: Int = 10
    private const val SPAWN_TRIES: Int = 16

    private fun getRandomSpawnPosition(origin: Vec3d, world: World): Vec3d {
        for (i in 1..SPAWN_TRIES){
            val x = origin.x + (Random.nextInt(SPAWN_DISTANCE) + SPAWN_DISTANCE) * Random.nextSign()
            val y = origin.y + Random.nextInt(max(SPAWN_DISTANCE - i, 1)) * Random.nextSign()
            val z = origin.z + (Random.nextInt(SPAWN_DISTANCE) + SPAWN_DISTANCE) * Random.nextSign()

            val pos = Vec3d(x,y,z)
            if (canSpawnAt(world, BlockPos(pos.toVec3i())))
                return pos
        }
        return origin
    }

    private fun canSpawnAt(world: World, pos: BlockPos): Boolean {
        if (!world.isSolid(pos.down())) {
            return false
        }

        val areaSize = 5
        val halfAreaSize = areaSize / 2

        // Check the 5x5x5 area above the given position
        for (x in -halfAreaSize..halfAreaSize) {
            for (y in 0 until areaSize) {
                for (z in -halfAreaSize..halfAreaSize) {
                    if (world.isSolid(pos.add(x, y, z))) {
                        return false
                    }
                }
            }
        }

        return true
    }
}

