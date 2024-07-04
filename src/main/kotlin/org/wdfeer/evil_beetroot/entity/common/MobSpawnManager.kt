package org.wdfeer.evil_beetroot.entity.common

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.CropBlock
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.Entity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random
import net.minecraft.world.World
import org.wdfeer.evil_beetroot.entity.BeetrootBoss
import org.wdfeer.evil_beetroot.entity.SmallBeetroot

object MobSpawnManager {
    fun initialize() {
        PlayerBlockBreakEvents.AFTER.register(::afterBlockBroken)
    }

    private var beetroots: Int = 0

    private fun afterBlockBroken(world: World, player: PlayerEntity, pos: BlockPos, state: BlockState, blockEntity: BlockEntity?) {
        if (state.block == Blocks.BEETROOTS && (Blocks.BEETROOTS as CropBlock).getAge(state) == 3)
            afterBeetrootHarvested(world, pos)
    }

    private var lastBossTime: Long = 0
    private const val BOSS_INTERVAL: Int = 1000

    private fun afterBeetrootHarvested(world: World, pos: BlockPos){
        if (beetroots > 1 && beetroots % 100 == 0 && world.time - lastBossTime > BOSS_INTERVAL)
        {
            summonEntity(BeetrootBoss(world) ,world, pos)
            lastBossTime = world.time
        }
        else if (Random.create().nextFloat() < getSmallBeetrootSpawnChance())
            summonEntity(SmallBeetroot(world) ,world, pos)

        beetroots++
    }

    private fun getSmallBeetrootSpawnChance(): Float = 0.05f

    private fun summonEntity(entity: Entity, world: World, pos: BlockPos) {
        entity.setPos(pos.x.toDouble(), pos.y + 0.5, pos.z.toDouble())
        world.spawnEntity(entity)
    }
}