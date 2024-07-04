package org.wdfeer.evil_beetroot

import net.fabricmc.api.ModInitializer
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory

class EvilBeetrootMod : ModInitializer {
	companion object {
		const val MOD_ID = "evil_beetroot"

		fun getIdentifier(localName: String): Identifier = Identifier(MOD_ID, localName)
	}
    private val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		ModEntityTypes.initialize()
		ModMobAttributes.initialize()
	}
}