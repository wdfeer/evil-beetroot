package org.wdfeer.evil_beetroot.entity.common

import net.minecraft.entity.EntityType
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.wdfeer.evil_beetroot.entity.BeetrootBoss
import org.wdfeer.evil_beetroot.entity.SmallBeetroot


object ModEntityTypes {
    val SMALL_BEETROOT: EntityType<SmallBeetroot> = Registry.register(
        Registries.ENTITY_TYPE,
        SmallBeetroot.getIdentifier(),
        SmallBeetroot.TYPE
    )

    val BEETROOT_BOSS: EntityType<BeetrootBoss> = Registry.register(
        Registries.ENTITY_TYPE,
        BeetrootBoss.getIdentifier(),
        BeetrootBoss.TYPE
    )
}