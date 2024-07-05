package org.wdfeer.evil_beetroot

import net.fabricmc.api.ClientModInitializer
import org.wdfeer.evil_beetroot.item.ClientItems
import org.wdfeer.evil_beetroot.model.EntityModelLayers
import org.wdfeer.evil_beetroot.renderer.EntityRenderers

object EvilBeetrootClient : ClientModInitializer {
	override fun onInitializeClient() {
		EntityRenderers.initialize()
		EntityModelLayers.initialize()

		ClientItems.initialize()
	}
}