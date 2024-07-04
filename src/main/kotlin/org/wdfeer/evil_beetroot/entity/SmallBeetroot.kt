package org.wdfeer.evil_beetroot.entity

import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.entity.mob.HostileEntity
import net.minecraft.util.Identifier
import net.minecraft.world.World
import org.wdfeer.evil_beetroot.EvilBeetrootMod

class SmallBeetroot(world: World?) : HostileEntity(TYPE, world) {
    companion object {
        val TYPE: EntityType<SmallBeetroot> = FabricEntityTypeBuilder.create<SmallBeetroot>(
            SpawnGroup.CREATURE
        ) { type, world -> SmallBeetroot(world) }
            .dimensions(EntityDimensions.fixed(0.75f, 0.75f))
            .build()
        
        fun getIdentifier(): Identifier = EvilBeetrootMod.getIdentifier("small_beetroot")
    }
}