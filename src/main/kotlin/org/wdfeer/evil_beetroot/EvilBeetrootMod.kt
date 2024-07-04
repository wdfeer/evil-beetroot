package org.wdfeer.evil_beetroot

import net.fabricmc.api.ModInitializer
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory
import org.wdfeer.evil_beetroot.entity.common.MobAttributes
import org.wdfeer.evil_beetroot.entity.common.MobSpawnManager
import org.wdfeer.evil_beetroot.entity.common.ModEntityTypes

class EvilBeetrootMod : ModInitializer {
	companion object {
		const val MOD_ID = "evil_beetroot"

		fun getIdentifier(localName: String): Identifier = Identifier(MOD_ID, localName)
	}
    private val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		ModEntityTypes.initialize()
		MobAttributes.initialize()
		MobSpawnManager.initialize()
	}
}