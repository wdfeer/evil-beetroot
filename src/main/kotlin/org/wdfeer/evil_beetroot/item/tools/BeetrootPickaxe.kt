package org.wdfeer.evil_beetroot.item.tools

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.BlockState
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.*
import net.minecraft.registry.RegistryKey
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random
import net.minecraft.world.World
import org.wdfeer.evil_beetroot.item.common.Groupable
import org.wdfeer.evil_beetroot.item.common.Identifiable

class BeetrootPickaxe : PickaxeItem(ToolMaterials.DIAMOND, 1, 1.2f - 4f, FabricItemSettings()), Identifiable, Groupable {
    companion object {
        const val FEED_CHANCE: Float = 0.1f
    }

    override fun getItemGroup(): RegistryKey<ItemGroup> = ItemGroups.TOOLS
    override fun getItemName(): String = "beetroot_pickaxe"

    override fun postMine(
        stack: ItemStack?,
        world: World?,
        state: BlockState?,
        pos: BlockPos?,
        miner: LivingEntity?
    ): Boolean {
        if (miner is PlayerEntity && Random.createLocal().nextFloat() < FEED_CHANCE){
            miner.hungerManager.add(1, 1f)
        }
        return super.postMine(stack, world, state, pos, miner)
    }

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?
    ) {
        tooltip?.add(Text.translatable("tooltip.evil_beetroot.feed_on_mine").formatted(Formatting.DARK_RED))
        super.appendTooltip(stack, world, tooltip, context)
    }
}