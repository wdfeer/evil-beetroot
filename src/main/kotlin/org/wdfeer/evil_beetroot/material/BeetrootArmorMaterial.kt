package org.wdfeer.evil_beetroot.material

import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.ArmorMaterials
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent

class BeetrootArmorMaterial : ArmorMaterial {
    companion object {
        val INSTANCE: BeetrootArmorMaterial = BeetrootArmorMaterial()
    }

    override fun getDurability(type: ArmorItem.Type?): Int {
        return ArmorMaterials.DIAMOND.getDurability(type)
    }

    override fun getProtection(type: ArmorItem.Type?): Int {
        return ArmorMaterials.DIAMOND.getProtection(type)
    }

    override fun getEnchantability(): Int {
        return ArmorMaterials.DIAMOND.enchantability
    }

    override fun getEquipSound(): SoundEvent {
        return ArmorMaterials.DIAMOND.equipSound
    }

    override fun getRepairIngredient(): Ingredient {
        return ArmorMaterials.DIAMOND.repairIngredient
    }

    override fun getName(): String {
        return "beetroot"
    }

    override fun getToughness(): Float {
        return ArmorMaterials.DIAMOND.toughness
    }

    override fun getKnockbackResistance(): Float {
        return ArmorMaterials.DIAMOND.knockbackResistance
    }
}