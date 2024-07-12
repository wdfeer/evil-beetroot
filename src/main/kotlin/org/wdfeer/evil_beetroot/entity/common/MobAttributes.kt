package org.wdfeer.evil_beetroot.entity.common

import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricDefaultAttributeRegistry
import org.wdfeer.evil_beetroot.entity.BeetrootBoss
import org.wdfeer.evil_beetroot.entity.BeetrootPhantom
import org.wdfeer.evil_beetroot.entity.SmallBeetroot

object MobAttributes {
    fun initialize() {
        FabricDefaultAttributeRegistry.register(SmallBeetroot.TYPE, SmallBeetroot.createMobAttributes())
        FabricDefaultAttributeRegistry.register(BeetrootBoss.TYPE, BeetrootBoss.createMobAttributes())
        FabricDefaultAttributeRegistry.register(BeetrootPhantom.TYPE, BeetrootPhantom.createMobAttributes())
    }
}