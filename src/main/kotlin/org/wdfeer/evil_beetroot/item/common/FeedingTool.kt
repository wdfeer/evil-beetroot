package org.wdfeer.evil_beetroot.item.common

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import org.wdfeer.evil_beetroot.config.BeetConfig
import org.wdfeer.evil_beetroot.util.roll
import kotlin.random.Random

object FeedingTool {
    fun postMine(miner: LivingEntity?) {
        if (miner is ServerPlayerEntity && Random.roll(BeetConfig.TOOLS_FEED_CHANCE)){
            miner.hungerManager.add(1, 1f)
        }
    }

    fun appendTooltip(tooltip: MutableList<Text>?, ) {
        tooltip?.add(Text.translatable("tooltip.evil_beetroot.feed_on_mine").formatted(Formatting.DARK_RED))
    }
}