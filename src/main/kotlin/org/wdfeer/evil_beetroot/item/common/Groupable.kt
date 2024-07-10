package org.wdfeer.evil_beetroot.item.common

import net.minecraft.item.ItemGroup
import net.minecraft.registry.RegistryKey

interface Groupable {
    fun getItemGroup(): RegistryKey<ItemGroup>
}