package org.wdfeer.evil_beetroot.item.tool

import org.wdfeer.evil_beetroot.item.common.HealingSword
import org.wdfeer.evil_beetroot.item.common.Identifiable

class BeetrootRapier : HealingSword(2, 1.8f), Identifiable {
    override fun getItemName(): String = "beetroot_rapier"
}
