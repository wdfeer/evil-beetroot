package org.wdfeer.evil_beetroot.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.FoodComponents
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.world.World
import org.wdfeer.evil_beetroot.entity.BeetrootBossSpawner
import org.wdfeer.evil_beetroot.item.common.Identifiable

class SentientBeetroot() : Item(FabricItemSettings().food(FoodComponents.BEETROOT)), Identifiable {
    override fun getItemName(): String = "sentient_beetroot"

    override fun finishUsing(stack: ItemStack?, world: World?, user: LivingEntity?): ItemStack {
        if (user is ServerPlayerEntity)
            BeetrootBossSpawner.trigger(user)
        return super.finishUsing(stack, world, user)
    }
}