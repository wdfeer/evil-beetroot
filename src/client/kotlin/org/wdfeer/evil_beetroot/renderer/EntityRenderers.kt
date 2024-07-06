package org.wdfeer.evil_beetroot.renderer

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
import org.wdfeer.evil_beetroot.entity.common.ModEntityTypes

object EntityRenderers {
    fun initialize() {
        EntityRendererRegistry.register(ModEntityTypes.smallBeetroot) { context -> SmallBeetrootRenderer(context) }
        EntityRendererRegistry.register(ModEntityTypes.beetrootBoss) { context -> BeetrootBossRenderer(context) }
    }
}