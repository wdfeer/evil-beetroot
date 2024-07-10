package org.wdfeer.evil_beetroot.item.tool

import org.wdfeer.evil_beetroot.item.common.HealingSword
import org.wdfeer.evil_beetroot.item.common.Identifiable

class BeetrootClaymore : HealingSword(5, 1.3f), Identifiable {
    override fun getItemName(): String = "beetroot_claymore"
}
