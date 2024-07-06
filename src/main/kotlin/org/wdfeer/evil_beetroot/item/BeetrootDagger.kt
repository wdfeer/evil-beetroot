package org.wdfeer.evil_beetroot.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.damage.DamageType
import net.minecraft.entity.damage.DamageTypes
import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem
import net.minecraft.item.ToolMaterials
import net.minecraft.registry.Registries
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.entry.RegistryEntry
import org.wdfeer.evil_beetroot.item.common.Identifiable

class BeetrootDagger : SwordItem(ToolMaterials.DIAMOND, 0, 2f - 4f, FabricItemSettings()), Identifiable {
    companion object {
        const val DRAIN: Float = 1f
    }

    override fun getItemName(): String = "beetroot_dagger"

    override fun postHit(stack: ItemStack?, target: LivingEntity?, attacker: LivingEntity?): Boolean {
        if (target != null && attacker != null) {
            val damageTypeRegistry = Registries.REGISTRIES.get(RegistryKeys.DAMAGE_TYPE.value)
            val damageTypeEntry = (damageTypeRegistry?.get(DamageTypes.MAGIC.value) as? RegistryEntry<DamageType>)

            if (damageTypeEntry != null) {
                val customDamageSource = DamageSource(damageTypeEntry)

                target.damage(customDamageSource, DRAIN)
                attacker.heal(DRAIN)
            }
        }

        return super.postHit(stack, target, attacker)
    }
}
