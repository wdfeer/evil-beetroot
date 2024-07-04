package org.wdfeer.evil_beetroot

import net.fabricmc.api.ClientModInitializer

object EvilBeetrootClient : ClientModInitializer {
	override fun onInitializeClient() {
		EntityRenderers.initialize()
		EntityModelLayers.initialize()
	}
}