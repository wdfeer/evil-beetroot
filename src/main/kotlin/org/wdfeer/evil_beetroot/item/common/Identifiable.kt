package org.wdfeer.evil_beetroot.item.common

import net.minecraft.util.Identifier
import org.wdfeer.evil_beetroot.EvilBeetrootMod

interface Identifiable {
    fun getItemName(): String

    fun getIdentifier(): Identifier {
        return EvilBeetrootMod.getIdentifier(getItemName())
    }
}