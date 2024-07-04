package org.wdfeer.evil_beetroot

import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricDefaultAttributeRegistry
import net.minecraft.entity.mob.MobEntity
import org.wdfeer.evil_beetroot.entity.SmallBeetroot

class ModMobAttributes {
    companion object {
        fun initialize() {
            FabricDefaultAttributeRegistry.register(SmallBeetroot.TYPE, MobEntity.createMobAttributes())
        }
    }
}