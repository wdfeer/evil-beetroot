package org.wdfeer.evil_beetroot

import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricDefaultAttributeRegistry
import org.wdfeer.evil_beetroot.entity.SmallBeetroot

class MobAttributes {
    companion object {
        fun initialize() {
            FabricDefaultAttributeRegistry.register(SmallBeetroot.TYPE, SmallBeetroot.createMobAttributes())
        }
    }
}