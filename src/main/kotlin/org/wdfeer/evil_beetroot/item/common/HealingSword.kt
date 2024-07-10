package org.wdfeer.evil_beetroot.item.common

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.LivingEntity
import net.minecraft.item.*
import net.minecraft.registry.RegistryKey
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.world.World

abstract class HealingSword(damage: Int, speed: Float) : SwordItem(ToolMaterials.DIAMOND, damage, speed - 4f, FabricItemSettings()), Groupable {
    companion object {
        const val HEAL: Float = 1f
    }

    override fun getItemGroup(): RegistryKey<ItemGroup> = ItemGroups.COMBAT

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
        tooltip?.add(Text.translatable("tooltip.evil_beetroot.heal_on_hit").formatted(Formatting.DARK_RED))
        super.appendTooltip(stack, world, tooltip, context)
    }
}