package org.wdfeer.evil_beetroot.item.common

import net.minecraft.entity.Entity
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.world.World
import org.wdfeer.evil_beetroot.config.BeetConfig

object RepairingTool {
    fun inventoryTick(tool: ItemStack?, world: World?, entity: Entity?) {
        // Do repair checks every 10 ticks
        if (world == null || (world.time % 10).toInt() != 0) return

        if (entity !is ServerPlayerEntity || tool == null || tool.damage < BeetConfig.REPAIR_PER_BEETROOT) return

        val player: ServerPlayerEntity = entity
        for (i in 0 until player.inventory.size()){
            val stack = player.inventory.getStack(i)
            if (stack.isOf(Items.BEETROOT))
            {
                stack.decrement(1)
                tool.damage -= BeetConfig.REPAIR_PER_BEETROOT
                break
            }
        }
    }

    fun appendTooltip(tooltip: MutableList<Text>?) {
        tooltip?.add(Text.translatable("tooltip.evil_beetroot.beetroot_repair").formatted(Formatting.DARK_RED))
    }
}