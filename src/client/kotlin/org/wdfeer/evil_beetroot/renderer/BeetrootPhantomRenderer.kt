package org.wdfeer.evil_beetroot.renderer

import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.render.entity.model.PhantomEntityModel
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier
import net.minecraft.util.math.RotationAxis
import org.wdfeer.evil_beetroot.EvilBeetrootMod
import org.wdfeer.evil_beetroot.entity.BeetrootPhantom
import org.wdfeer.evil_beetroot.model.BeetrootPhantomModel
import org.wdfeer.evil_beetroot.model.EntityModelLayers

class BeetrootPhantomRenderer(context: EntityRendererFactory.Context) : MobEntityRenderer<BeetrootPhantom, PhantomEntityModel<BeetrootPhantom>>(
    context, BeetrootPhantomModel(context.getPart(EntityModelLayers.BEETROOT_PHANTOM_MODEL_LAYER)), 0.75f
) {
    override fun getTexture(entity: BeetrootPhantom?): Identifier {
        return EvilBeetrootMod.getIdentifier("textures/entity/beetroot_phantom.png")
    }

    init {
        this.addFeature(BeetrootPhantomEyesRenderer(this))
    }

    override fun scale(entity: BeetrootPhantom?, matrixStack: MatrixStack?, f: Float) {
        if (entity == null || matrixStack == null) return

        val i = entity.phantomSize
        val g = 1.0f + 0.15f * i.toFloat()
        matrixStack.scale(g, g, g)
        matrixStack.translate(0.0f, 1.3125f, 0.1875f)
    }

    override fun setupTransforms(
        entity: BeetrootPhantom,
        matrixStack: MatrixStack,
        f: Float,
        g: Float,
        h: Float
    ) {
        super.setupTransforms(entity, matrixStack, f, g, h)
        matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(entity.pitch))
    }
}