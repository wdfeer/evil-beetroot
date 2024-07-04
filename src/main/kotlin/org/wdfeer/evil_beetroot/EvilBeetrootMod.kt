package org.wdfeer.evil_beetroot

import net.fabricmc.api.ModInitializer
import net.minecraft.util.Identifier
import org.wdfeer.evil_beetroot.entity.common.MobAttributes
import org.wdfeer.evil_beetroot.entity.SmallBeetrootSpawner
import org.wdfeer.evil_beetroot.entity.common.ModEntityTypes

object EvilBeetrootMod : ModInitializer {
	private const val MOD_ID = "evil_beetroot"

	fun getIdentifier(localName: String): Identifier = Identifier(MOD_ID, localName)

	override fun onInitialize() {
		ModEntityTypes.initialize()
		MobAttributes.initialize()
		SmallBeetrootSpawner.initialize()
	}
}