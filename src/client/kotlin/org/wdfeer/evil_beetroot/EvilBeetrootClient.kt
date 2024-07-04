package org.wdfeer.evil_beetroot

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
import net.minecraft.client.render.entity.model.EntityModelLayer
import org.wdfeer.evil_beetroot.entity.SmallBeetroot
import org.wdfeer.evil_beetroot.model.SmallBeetrootModel
import org.wdfeer.evil_beetroot.renderer.SmallBeetrootRenderer


object EvilBeetrootClient : ClientModInitializer {
	val SMALL_BEETROOT_MODEL_LAYER: EntityModelLayer = EntityModelLayer(SmallBeetroot.getIdentifier(), "main")
	override fun onInitializeClient() {
		EntityRendererRegistry.register(ModEntityTypes.SMALL_BEETROOT) { context -> SmallBeetrootRenderer(context) }

		EntityModelLayerRegistry.registerModelLayer(SMALL_BEETROOT_MODEL_LAYER, SmallBeetrootModel::getTexturedModelData)
	}
}