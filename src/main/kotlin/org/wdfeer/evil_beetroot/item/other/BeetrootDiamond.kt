package org.wdfeer.evil_beetroot.item.other

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemGroups
import net.minecraft.registry.RegistryKey
import org.wdfeer.evil_beetroot.item.common.Groupable
import org.wdfeer.evil_beetroot.item.common.Identifiable

class BeetrootDiamond : Item(FabricItemSettings()), Identifiable, Groupable {
    override fun getItemName(): String {
        return "beetroot_diamond"
    }

    override fun getItemGroup(): RegistryKey<ItemGroup> {
        return ItemGroups.INGREDIENTS
    }

}