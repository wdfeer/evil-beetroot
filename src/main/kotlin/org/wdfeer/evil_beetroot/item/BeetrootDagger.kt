package org.wdfeer.evil_beetroot.item

import org.wdfeer.evil_beetroot.item.common.Identifiable

class BeetrootDagger : HealingSword(0, 2f), Identifiable {
    override fun getItemName(): String = "beetroot_dagger"
}
