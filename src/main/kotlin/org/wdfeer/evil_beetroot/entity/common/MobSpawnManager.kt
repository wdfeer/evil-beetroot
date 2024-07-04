package org.wdfeer.evil_beetroot.entity.common

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.CropBlock
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random
import net.minecraft.world.World
import org.wdfeer.evil_beetroot.entity.SmallBeetroot

object MobSpawnManager {
    fun initialize() {
        PlayerBlockBreakEvents.AFTER.register(::afterBlockBroken)
    }

    private fun afterBlockBroken(world: World, player: PlayerEntity, pos: BlockPos, state: BlockState, blockEntity: BlockEntity?) {
        if (state.block == Blocks.BEETROOTS && (Blocks.BEETROOTS as CropBlock).getAge(state) == 3)
            afterBeetrootHarvested(world, pos)
    }

    private fun afterBeetrootHarvested(world: World, pos: BlockPos){
        if (Random.create().nextFloat() < getSmallBeetrootSpawnChance())
            summonSmallBeetroot(world, pos)
    }

    private fun getSmallBeetrootSpawnChance(): Float = 0.05f

    private fun summonSmallBeetroot(world: World, pos: BlockPos) {
        val beetroot = SmallBeetroot(world)
        beetroot.setPos(pos.x.toDouble(), pos.y + 0.5, pos.z.toDouble())
        world.spawnEntity(beetroot)
    }
}