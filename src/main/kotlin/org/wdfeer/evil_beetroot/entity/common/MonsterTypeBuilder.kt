package org.wdfeer.evil_beetroot.entity.common

import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.world.World

object MonsterTypeBuilder {
    private fun <T : Entity> build(dimensions: EntityDimensions, factory: (world: World) -> T): EntityType<T>{
        return FabricEntityTypeBuilder.create(SpawnGroup.MONSTER) {
            _, world -> factory(world)
        }.dimensions(dimensions).build()
    }

    fun <T : Entity> build(fixedWidth: Float, fixedHeight: Float, factory: (world: World) -> T): EntityType<T>{
        return build(EntityDimensions.fixed(fixedWidth, fixedHeight), factory)
    }
}