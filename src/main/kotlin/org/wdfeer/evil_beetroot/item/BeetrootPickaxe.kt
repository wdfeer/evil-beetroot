package org.wdfeer.evil_beetroot.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.item.ItemStack
import net.minecraft.item.PickaxeItem
import net.minecraft.item.ToolMaterials
import net.minecraft.util.Identifier

class BeetrootPickaxe : PickaxeItem(ToolMaterials.DIAMOND, 2, 1.2f - 4f, FabricItemSettings()) {
    override fun getDefaultStack(): ItemStack {
        val stack = super.getDefaultStack()
        stack.enchantments.add(EnchantmentHelper.createNbt(Identifier("minecraft:fortune"), 3))
        return stack
    }
}