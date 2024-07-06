package org.wdfeer.evil_beetroot.item

import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.wdfeer.evil_beetroot.item.common.Identifiable

object ModItems {
    val SENTIENT_BEETROOT = SentientBeetroot()
    val BEETROOT_HEART = BeetrootHeart()

    fun initialize() {
        val items: Array<Item> = arrayOf(
            SENTIENT_BEETROOT,
            BEETROOT_HEART,
            BeetrootDagger()
        )

        for (i in items) {
            Registry.register(Registries.ITEM, (i as Identifiable).getIdentifier(), i)
        }

        BeetrootHeart.initialize()
    }
}