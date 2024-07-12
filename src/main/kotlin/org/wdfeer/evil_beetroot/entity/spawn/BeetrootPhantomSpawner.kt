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
import org.wdfeer.evil_beetroot.entity.BeetrootPhantom

object BeetrootPhantomSpawner {
    fun initialize() {
        PlayerBlockBreakEvents.AFTER.register(BeetrootPhantomSpawner::afterBlockBroken)
    }

    private fun afterBlockBroken(world: World, player: PlayerEntity, pos: BlockPos, state: BlockState, blockEntity: BlockEntity?) {
        if (state.block == Blocks.BEETROOTS && (Blocks.BEETROOTS as CropBlock).getAge(state) == 3)
            afterBeetrootHarvested(world, pos)
    }

    private fun afterBeetrootHarvested(world: World, pos: BlockPos){
        if (Random.create().nextFloat() < BeetConfig.PHANTOM_SPAWN_CHANCE)
            summonEntity(BeetrootPhantom(world) ,world, pos)
    }

    private fun summonEntity(entity: Entity, world: World, blockBrokenPos: BlockPos) {
        entity.setPos(blockBrokenPos.x.toDouble(), blockBrokenPos.y + 50.0, blockBrokenPos.z.toDouble())
        world.spawnEntity(entity)
    }
}