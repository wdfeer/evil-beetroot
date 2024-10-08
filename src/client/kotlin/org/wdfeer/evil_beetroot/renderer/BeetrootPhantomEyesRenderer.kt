package org.wdfeer.evil_beetroot.renderer

import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.entity.feature.FeatureRendererContext
import net.minecraft.client.render.entity.feature.PhantomEyesFeatureRenderer
import net.minecraft.client.render.entity.model.PhantomEntityModel
import org.wdfeer.evil_beetroot.EvilBeetrootMod
import org.wdfeer.evil_beetroot.entity.BeetrootPhantom

class BeetrootPhantomEyesRenderer(context: FeatureRendererContext<BeetrootPhantom, PhantomEntityModel<BeetrootPhantom>>?) : PhantomEyesFeatureRenderer<BeetrootPhantom>(context) {
    companion object {
        val TEXTURE: RenderLayer = RenderLayer.getEyes(EvilBeetrootMod.getIdentifier("textures/entity/beetroot_phantom_eyes.png"))
    }

    override fun getEyesTexture(): RenderLayer {
        return TEXTURE
    }
}