package org.wdfeer.evil_beetroot.renderer

import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.util.Identifier
import org.wdfeer.evil_beetroot.EntityModelLayers
import org.wdfeer.evil_beetroot.EvilBeetrootMod
import org.wdfeer.evil_beetroot.entity.BeetrootBoss
import org.wdfeer.evil_beetroot.model.BeetrootBossModel

class BeetrootBossRenderer(context: EntityRendererFactory.Context) : MobEntityRenderer<BeetrootBoss, BeetrootBossModel>(
    context, BeetrootBossModel(context.getPart(EntityModelLayers.BEETROOT_BOSS_MODEL_LAYER)), 0.5f
) {
    override fun getTexture(entity: BeetrootBoss?): Identifier {
        return EvilBeetrootMod.getIdentifier("textures/entity/small_beetroot/beetroot_boss.png")
    }
}