package org.wdfeer.evil_beetroot

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.minecraft.client.render.entity.model.EntityModelLayer
import org.wdfeer.evil_beetroot.entity.BeetrootBoss
import org.wdfeer.evil_beetroot.entity.SmallBeetroot
import org.wdfeer.evil_beetroot.model.BeetrootBossModel
import org.wdfeer.evil_beetroot.model.SmallBeetrootModel

object EntityModelLayers {
    val SMALL_BEETROOT_MODEL_LAYER: EntityModelLayer = EntityModelLayer(SmallBeetroot.getIdentifier(), "main")
    val BEETROOT_BOSS_MODEL_LAYER: EntityModelLayer = EntityModelLayer(BeetrootBoss.getIdentifier(), "main")

    fun initialize() {
        EntityModelLayerRegistry.registerModelLayer(SMALL_BEETROOT_MODEL_LAYER) { SmallBeetrootModel.texturedModelData }
        EntityModelLayerRegistry.registerModelLayer(BEETROOT_BOSS_MODEL_LAYER) { BeetrootBossModel.texturedModelData }
    }
}