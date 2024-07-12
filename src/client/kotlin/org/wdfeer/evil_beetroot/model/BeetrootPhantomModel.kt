package org.wdfeer.evil_beetroot.model

import net.minecraft.client.model.*
import net.minecraft.client.render.entity.model.PhantomEntityModel
import org.wdfeer.evil_beetroot.entity.BeetrootPhantom

class BeetrootPhantomModel(root: ModelPart) : PhantomEntityModel<BeetrootPhantom>(root) {
    companion object {
        val texturedModelData: TexturedModelData
            get() {
                return getTexturedModelData()
            }
    }
}