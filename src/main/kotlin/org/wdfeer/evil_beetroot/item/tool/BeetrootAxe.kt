package org.wdfeer.evil_beetroot.item.tool

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.BlockState
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.LivingEntity
import net.minecraft.item.*
import net.minecraft.registry.RegistryKey
import net.minecraft.text.Text
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import org.wdfeer.evil_beetroot.item.common.FeedingTool
import org.wdfeer.evil_beetroot.item.common.Groupable
import org.wdfeer.evil_beetroot.item.common.Identifiable

class BeetrootAxe : AxeItem(ToolMaterials.DIAMOND, 5f, 1f - 4f, FabricItemSettings()), Identifiable, Groupable {
    override fun getItemGroup(): RegistryKey<ItemGroup> = ItemGroups.TOOLS
    override fun getItemName(): String = "beetroot_axe"

    override fun postMine(
        stack: ItemStack?,
        world: World?,
        state: BlockState?,
        pos: BlockPos?,
        miner: LivingEntity?
    ): Boolean {
        FeedingTool.postMine(miner)

        return super.postMine(stack, world, state, pos, miner)
    }

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?
    ) {
        FeedingTool.appendTooltip(tooltip)

        super.appendTooltip(stack, world, tooltip, context)
    }
}