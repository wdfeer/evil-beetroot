package org.wdfeer.evil_beetroot

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object EvilBeetroot : ModInitializer {
    private val logger = LoggerFactory.getLogger("evil_beetroot")

	override fun onInitialize() {
		logger.info("Hello Fabric world!")
	}
}