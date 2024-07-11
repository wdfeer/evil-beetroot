package org.wdfeer.evil_beetroot.item.armor

import net.minecraft.item.ArmorItem

object BeetrootArmor {
    private val helmet = BeetrootArmorItem(ArmorItem.Type.HELMET, "beetroot_helmet")
    private val chestplate = BeetrootArmorItem(ArmorItem.Type.CHESTPLATE, "beetroot_chestplate")
    private val leggings = BeetrootArmorItem(ArmorItem.Type.LEGGINGS, "beetroot_leggings")
    private val boots = BeetrootArmorItem(ArmorItem.Type.BOOTS, "beetroot_boots")

    val items: Array<ArmorItem> = arrayOf(
        helmet,
        chestplate,
        leggings,
        boots
    )
}