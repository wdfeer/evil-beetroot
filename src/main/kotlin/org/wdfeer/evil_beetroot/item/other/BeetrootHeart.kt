package org.wdfeer.evil_beetroot.item.other

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.attribute.EntityAttributeModifier
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemGroups
import net.minecraft.item.ItemStack
import net.minecraft.registry.RegistryKey
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.stat.Stats
import net.minecraft.text.Text
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World
import org.wdfeer.evil_beetroot.item.common.Groupable
import org.wdfeer.evil_beetroot.item.common.Identifiable
import java.util.*

open class BeetrootHeart : Item(FabricItemSettings()), Identifiable, Groupable {
    companion object {
        private val MAX_HP_MODIFIER_UUID: UUID = UUID.nameUUIDFromBytes("beetroot_heart_max_hp_increase".toByteArray())

        fun initialize() {
            ServerPlayerEvents.COPY_FROM.register { old, new, _ -> afterRespawn(old, new) }
        }

        private fun afterRespawn(oldPlayer: ServerPlayerEntity, newPlayer: ServerPlayerEntity){
            if (hasHpIncreaseModifier(oldPlayer)) {
                applyHealthModifier(newPlayer)
            }
        }

        fun hasHpIncreaseModifier(player: PlayerEntity?): Boolean {
            val attributeInstance = player?.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)
            return attributeInstance?.getModifier(MAX_HP_MODIFIER_UUID) != null
        }

        private fun applyHealthModifier(player: PlayerEntity) {
            val maxHpModifier = EntityAttributeModifier(
                MAX_HP_MODIFIER_UUID,
                "Beetroot Heart Max HP Boost",
                2.0,
                EntityAttributeModifier.Operation.ADDITION
            )

            val attributeInstance = player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)
            attributeInstance?.addPersistentModifier(maxHpModifier)
        }

        var appendTooltip: (MutableList<Text>?) -> Unit = {}
    }

    override fun getItemGroup(): RegistryKey<ItemGroup> = ItemGroups.INGREDIENTS

    override fun getItemName(): String = "beetroot_heart"

    override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        if (world == null || user == null) {
            return TypedActionResult.pass(user?.getStackInHand(hand))
        }

        if (!hasHpIncreaseModifier(user)) {
            applyHealthModifier(user)

            user.incrementStat(Stats.USED.getOrCreateStat(this))

            user.getStackInHand(hand).decrement(1)

            return TypedActionResult.success(user.getStackInHand(hand), world.isClient)
        }

        return TypedActionResult.fail(user.getStackInHand(hand))
    }

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?
    ) {
        appendTooltip(tooltip)

        super.appendTooltip(stack, world, tooltip, context)
    }
}