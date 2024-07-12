package org.wdfeer.evil_beetroot.entity.common

import net.minecraft.entity.EntityType
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.wdfeer.evil_beetroot.entity.BeetrootBoss
import org.wdfeer.evil_beetroot.entity.BeetrootPhantom
import org.wdfeer.evil_beetroot.entity.SmallBeetroot


object ModEntityTypes {
    lateinit var smallBeetroot: EntityType<SmallBeetroot>

    lateinit var beetrootBoss: EntityType<BeetrootBoss>

    lateinit var beetrootPhantom: EntityType<BeetrootPhantom>
    fun initialize() {
        smallBeetroot = Registry.register(
            Registries.ENTITY_TYPE,
            SmallBeetroot.getIdentifier(),
            SmallBeetroot.TYPE
        )

        beetrootBoss = Registry.register(
            Registries.ENTITY_TYPE,
            BeetrootBoss.getIdentifier(),
            BeetrootBoss.TYPE
        )

        beetrootPhantom = Registry.register(
            Registries.ENTITY_TYPE,
            BeetrootPhantom.getIdentifier(),
            BeetrootPhantom.TYPE
        )
    }
}