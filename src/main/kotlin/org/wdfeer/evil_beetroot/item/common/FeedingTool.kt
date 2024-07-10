package org.wdfeer.evil_beetroot.item.common

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import kotlin.random.Random

object FeedingTool {
    private const val FEED_CHANCE: Float = 0.1f

    fun postMine(miner: LivingEntity?) {
        if (miner is PlayerEntity && Random.nextFloat() < FEED_CHANCE){
            miner.hungerManager.add(1, 1f)
        }
    }

    fun appendTooltip(tooltip: MutableList<Text>?, ) {
        tooltip?.add(Text.translatable("tooltip.evil_beetroot.feed_on_mine").formatted(Formatting.DARK_RED))
    }
}