package org.wdfeer.evil_beetroot.item.tool

import org.wdfeer.evil_beetroot.item.common.HealingSword
import org.wdfeer.evil_beetroot.item.common.Identifiable

class BeetrootDagger : HealingSword(0, 2.5f), Identifiable {
    override fun getItemName(): String = "beetroot_dagger"
}
