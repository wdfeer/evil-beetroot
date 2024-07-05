package org.wdfeer.evil_beetroot.renderer

import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.util.Identifier
import org.wdfeer.evil_beetroot.model.EntityModelLayers
import org.wdfeer.evil_beetroot.EvilBeetrootMod
import org.wdfeer.evil_beetroot.entity.SmallBeetroot
import org.wdfeer.evil_beetroot.model.SmallBeetrootModel

class SmallBeetrootRenderer(context: EntityRendererFactory.Context) : MobEntityRenderer<SmallBeetroot, SmallBeetrootModel>(
    context, SmallBeetrootModel(context.getPart(EntityModelLayers.SMALL_BEETROOT_MODEL_LAYER)), 0.5f
) {
    override fun getTexture(entity: SmallBeetroot?): Identifier {
        return EvilBeetrootMod.getIdentifier("textures/entity/small_beetroot/small_beetroot.png")
    }
}