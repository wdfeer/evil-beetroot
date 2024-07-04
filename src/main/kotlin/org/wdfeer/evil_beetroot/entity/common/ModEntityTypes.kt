package org.wdfeer.evil_beetroot.entity.common

import net.minecraft.entity.EntityType
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.wdfeer.evil_beetroot.entity.SmallBeetroot


class ModEntityTypes {
    companion object {
        val SMALL_BEETROOT: EntityType<SmallBeetroot> = Registry.register(
            Registries.ENTITY_TYPE,
            SmallBeetroot.getIdentifier(),
            SmallBeetroot.TYPE
        )

        fun initialize() {

        }
    }
}