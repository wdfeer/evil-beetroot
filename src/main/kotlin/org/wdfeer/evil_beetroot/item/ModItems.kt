package org.wdfeer.evil_beetroot.item

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.wdfeer.evil_beetroot.item.common.Groupable
import org.wdfeer.evil_beetroot.item.common.Identifiable
import org.wdfeer.evil_beetroot.item.other.BeetrootDiamond
import org.wdfeer.evil_beetroot.item.other.BeetrootHeart
import org.wdfeer.evil_beetroot.item.other.SentientBeetroot
import org.wdfeer.evil_beetroot.item.tool.BeetrootClaymore
import org.wdfeer.evil_beetroot.item.tool.BeetrootDagger
import org.wdfeer.evil_beetroot.item.tool.BeetrootPickaxe
import org.wdfeer.evil_beetroot.item.tool.BeetrootShovel

object ModItems {
    val SENTIENT_BEETROOT = SentientBeetroot()
    val BEETROOT_HEART = BeetrootHeart()

    fun initialize() {
        val items: Array<Item> = arrayOf(
            SENTIENT_BEETROOT,
            BEETROOT_HEART,
            BeetrootDiamond(),
            BeetrootDagger(),
            BeetrootClaymore(),
            BeetrootPickaxe(),
            BeetrootShovel()
        )

        for (i in items) {
            Registry.register(Registries.ITEM, (i as Identifiable).getIdentifier(), i)
            if (i is Groupable)
                ItemGroupEvents.modifyEntriesEvent(i.getItemGroup()).register { content -> content.add(i) }
        }

        BeetrootHeart.initialize()
    }
}