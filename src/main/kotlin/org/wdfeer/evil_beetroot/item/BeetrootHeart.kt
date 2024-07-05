package org.wdfeer.evil_beetroot.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.entity.attribute.EntityAttributeModifier
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World
import org.wdfeer.evil_beetroot.item.common.Identifiable
import java.util.*

class BeetrootHeart : Item(FabricItemSettings()), Identifiable {
    companion object {
        val MAX_HP_MODIFIER_UUID: UUID = UUID.fromString("123e4567-e89b-12d3-a456-426614174000")
    }

    override fun getItemName(): String = "beetroot_heart"

    override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        if (world == null || user == null) {
            return TypedActionResult.pass(user?.getStackInHand(hand))
        }

        val attributeInstance = user.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)

        if (attributeInstance != null && attributeInstance.getModifier(MAX_HP_MODIFIER_UUID) == null) {
            val maxHpModifier = EntityAttributeModifier(
                MAX_HP_MODIFIER_UUID,
                "Beetroot Heart Max HP Boost",
                2.0,
                EntityAttributeModifier.Operation.ADDITION
            )

            // Apply the max HP modifier
            attributeInstance.addPersistentModifier(maxHpModifier)

            // Reduce the item stack size
            user.getStackInHand(hand).decrement(1)

            return TypedActionResult.success(user.getStackInHand(hand), world.isClient)
        }

        return TypedActionResult.fail(user.getStackInHand(hand))
    }
}