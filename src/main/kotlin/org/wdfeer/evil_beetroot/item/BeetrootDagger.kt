package org.wdfeer.evil_beetroot.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem
import net.minecraft.item.ToolMaterials
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.world.World
import org.wdfeer.evil_beetroot.item.common.Identifiable

class BeetrootDagger : SwordItem(ToolMaterials.DIAMOND, 0, 2f - 4f, FabricItemSettings()), Identifiable {
    companion object {
        const val HEAL: Float = 1f
    }

    override fun getItemName(): String = "beetroot_dagger"

    override fun postHit(stack: ItemStack?, target: LivingEntity?, attacker: LivingEntity?): Boolean {
        if (target != null && attacker != null) {
            attacker.heal(HEAL)
        }

        return super.postHit(stack, target, attacker)
    }

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?
    ) {
        tooltip?.add(Text.translatable("tooltip.evil_beetroot.beetroot_dagger").formatted(Formatting.DARK_RED))
        super.appendTooltip(stack, world, tooltip, context)
    }
}
