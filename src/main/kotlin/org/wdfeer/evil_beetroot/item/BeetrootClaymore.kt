package org.wdfeer.evil_beetroot.item

import org.wdfeer.evil_beetroot.item.common.HealingSword
import org.wdfeer.evil_beetroot.item.common.Identifiable

class BeetrootClaymore : HealingSword(5, 1f), Identifiable {
    override fun getItemName(): String = "beetroot_claymore"
}
