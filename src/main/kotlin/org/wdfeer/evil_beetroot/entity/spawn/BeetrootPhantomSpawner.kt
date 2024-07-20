package org.wdfeer.evil_beetroot.entity.spawn

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.CropBlock
import net.minecraft.entity.Entity
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.stat.Stats
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World
import org.wdfeer.evil_beetroot.config.BeetConfig
import org.wdfeer.evil_beetroot.entity.BeetrootPhantom
import org.wdfeer.evil_beetroot.entity.common.ModEntityTypes
import org.wdfeer.evil_beetroot.util.*
import kotlin.random.Random

object BeetrootPhantomSpawner {
    fun initialize() {
        PlayerBlockBreakEvents.AFTER.register { world, player, pos, state, _ ->
            if (world is ServerWorld && player is ServerPlayerEntity)
                afterBlockBroken(world, player, pos, state)
        }
    }

    private fun afterBlockBroken(world: ServerWorld, player: ServerPlayerEntity, pos: BlockPos, state: BlockState) {
        if (state.block == Blocks.BEETROOTS &&
            (Blocks.BEETROOTS as CropBlock).getAge(state) == 3 &&
            player.statHandler.getStat(Stats.KILLED.getOrCreateStat(ModEntityTypes.beetrootBoss)) > 0)
            afterBeetrootHarvested(world, pos)
    }

    private fun afterBeetrootHarvested(world: World, pos: BlockPos){
        if (Random.nextFloat() < BeetConfig.PHANTOM_SPAWN_CHANCE)
            trySummonEntity(BeetrootPhantom(world) ,world, pos)
    }

    private fun trySummonEntity(entity: Entity, world: World, blockPos: BlockPos) {
        val pos = getRandomSpawnPosition(blockPos.toVec3d(), world) ?: return

        entity.setPos(pos.x, pos.y, pos.z)
        world.spawnEntity(entity)
    }

    private const val SPAWN_DISTANCE: Int = 16
    private const val SPAWN_TRIES: Int = 16

    private fun getRandomSpawnPosition(origin: Vec3d, world: World): Vec3d? {
        for (i in 1..SPAWN_TRIES) {
            val x = origin.x + (Random.nextInt(SPAWN_DISTANCE) + SPAWN_DISTANCE) * Random.nextSign()
            val y = origin.y + 20 + Random.nextInt(21)
            val z = origin.z + (Random.nextInt(SPAWN_DISTANCE) + SPAWN_DISTANCE) * Random.nextSign()

            val pos = Vec3d(x,y,z)

            if (!world.isSolid(pos.toVec3i()))
                return pos
        }

        return null
    }
}