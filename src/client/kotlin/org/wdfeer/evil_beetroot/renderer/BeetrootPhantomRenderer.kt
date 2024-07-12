package org.wdfeer.evil_beetroot.renderer

import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.render.entity.model.PhantomEntityModel
import net.minecraft.util.Identifier
import org.wdfeer.evil_beetroot.EvilBeetrootMod
import org.wdfeer.evil_beetroot.entity.BeetrootPhantom
import org.wdfeer.evil_beetroot.model.BeetrootPhantomModel
import org.wdfeer.evil_beetroot.model.EntityModelLayers

class BeetrootPhantomRenderer(context: EntityRendererFactory.Context) : MobEntityRenderer<BeetrootPhantom, PhantomEntityModel<BeetrootPhantom>>(
    context, BeetrootPhantomModel(context.getPart(EntityModelLayers.BEETROOT_PHANTOM_MODEL_LAYER)), 0.75f
) {
    override fun getTexture(entity: BeetrootPhantom?): Identifier {
        return EvilBeetrootMod.getIdentifier("textures/entity/small_beetroot/beetroot_phantom.png")
    }

    init {
        this.addFeature(BeetrootPhantomEyesRenderer(this))
    }
}