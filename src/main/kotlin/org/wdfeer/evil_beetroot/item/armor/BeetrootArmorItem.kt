package org.wdfeer.evil_beetroot.item.armor

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.Entity
import net.minecraft.item.*
import net.minecraft.registry.RegistryKey
import net.minecraft.text.Text
import net.minecraft.world.World
import org.wdfeer.evil_beetroot.item.common.Groupable
import org.wdfeer.evil_beetroot.item.common.Identifiable
import org.wdfeer.evil_beetroot.item.common.RepairingTool
import org.wdfeer.evil_beetroot.material.BeetrootArmorMaterial

class BeetrootArmorItem(
    type: Type,
    private val name: String
) : ArmorItem(BeetrootArmorMaterial.INSTANCE, type, FabricItemSettings()), Identifiable, Groupable {
    override fun getItemName(): String = name
    override fun getItemGroup(): RegistryKey<ItemGroup> = ItemGroups.COMBAT

    override fun inventoryTick(stack: ItemStack?, world: World?, entity: Entity?, slot: Int, selected: Boolean) {
        RepairingTool.inventoryTick(stack, world, entity)
        super.inventoryTick(stack, world, entity, slot, selected)
    }

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?
    ) {
        RepairingTool.appendTooltip(tooltip)
        super.appendTooltip(stack, world, tooltip, context)
    }
}