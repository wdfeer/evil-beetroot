package org.wdfeer.evil_beetroot.item

import net.minecraft.client.MinecraftClient
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import org.wdfeer.evil_beetroot.item.BeetrootHeart.Companion.hasHpIncreaseModifier

object BeetrootHeartClient {
    fun initialize() {
        BeetrootHeart.appendTooltip = ::appendTooltip
    }

    private fun appendTooltip(
        tooltip: MutableList<Text>?
    ) {
        val player: PlayerEntity? = MinecraftClient.getInstance().player
        if (tooltip != null && player != null) {
            val text: Text = if (hasHpIncreaseModifier(player))
                Text.translatable("tooltip.evil_beetroot.beetroot_heart_used").formatted(Formatting.GRAY)
            else
                Text.translatable("tooltip.evil_beetroot.beetroot_heart").formatted(Formatting.RED)

            tooltip.add(text)
        }
    }
}