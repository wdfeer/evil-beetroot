package org.wdfeer.evil_beetroot.util

import net.minecraft.util.math.Vec3d
import net.minecraft.util.math.Vec3i

fun Vec3d.toVec3i(): Vec3i{
    return Vec3i(this.x.toInt(), this.y.toInt(), this.z.toInt())
}

fun Vec3i.toVec3d(): Vec3d{
    return Vec3d(this.x.toDouble(), this.y.toDouble(), this.z.toDouble())
}