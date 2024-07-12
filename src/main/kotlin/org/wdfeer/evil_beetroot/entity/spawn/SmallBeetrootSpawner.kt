package org.wdfeer.evil_beetroot.entity.spawn

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
import org.wdfeer.evil_beetroot.config.BeetConfig
import org.wdfeer.evil_beetroot.entity.SmallBeetroot

object SmallBeetrootSpawner {
    fun initialize() {
        PlayerBlockBreakEvents.AFTER.register(SmallBeetrootSpawner::afterBlockBroken)
    }

    private fun afterBlockBroken(world: World, player: PlayerEntity, pos: BlockPos, state: BlockState, blockEntity: BlockEntity?) {
        if (state.block == Blocks.BEETROOTS && (Blocks.BEETROOTS as CropBlock).getAge(state) == 3)
            afterBeetrootHarvested(world, pos)
    }

    private fun afterBeetrootHarvested(world: World, pos: BlockPos){
        if (Random.create().nextFloat() < BeetConfig.SMALL_BEETROOT_SPAWN_CHANCE)
            summonEntity(SmallBeetroot(world) ,world, pos)
    }

    private fun summonEntity(entity: Entity, world: World, pos: BlockPos) {
        entity.setPos(pos.x.toDouble(), pos.y + 0.5, pos.z.toDouble())
        world.spawnEntity(entity)
    }
}