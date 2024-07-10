package org.wdfeer.evil_beetroot.util

import net.minecraft.util.math.random.Random

fun Random.nextSign(): Int {
    return if (this.nextBoolean()) 1 else -1
}

fun Random.roll(chance: Float): Boolean {
    return this.nextFloat() < chance
}

fun kotlin.random.Random.roll(chance: Float): Boolean {
    return this.nextFloat() < chance
}