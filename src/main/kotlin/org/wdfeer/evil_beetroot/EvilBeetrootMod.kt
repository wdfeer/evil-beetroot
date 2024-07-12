package org.wdfeer.evil_beetroot

import net.fabricmc.api.ModInitializer
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory
import org.wdfeer.evil_beetroot.entity.common.MobAttributes
import org.wdfeer.evil_beetroot.entity.common.ModEntityTypes
import org.wdfeer.evil_beetroot.entity.spawn.MobSpawnRules
import org.wdfeer.evil_beetroot.item.ModItems

object EvilBeetrootMod : ModInitializer {
	private const val MOD_ID = "evil_beetroot"

	private val LOGGER = LoggerFactory.getLogger(MOD_ID)

	fun getIdentifier(localName: String): Identifier = Identifier(MOD_ID, localName)

	override fun onInitialize() {
		ModItems.initialize()

		ModEntityTypes.initialize()
		MobAttributes.initialize()
		MobSpawnRules.initialize()

		LOGGER.info("Evil Beetroot initialized!")
	}
}