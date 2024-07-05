package org.wdfeer.evil_beetroot.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import org.wdfeer.evil_beetroot.item.common.Identifiable

class BeetrootHeart : Item(FabricItemSettings()), Identifiable {
    override fun getItemName(): String = "beetroot_heart"

    // TODO: Make it usable!
}