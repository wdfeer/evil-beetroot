package org.wdfeer.evil_beetroot.model

import net.minecraft.client.model.ModelPart
import kotlin.math.PI
import kotlin.math.cos

object ModelRotationHelper {
    fun rotateHead(head: ModelPart, netHeadYaw: Float, headPitch: Float) {
        head.yaw = netHeadYaw * (PI.toFloat() / 180f)
        head.pitch = headPitch * (PI.toFloat() / 180f)
    }

    fun rotateLegs(left: ModelPart, right: ModelPart, limbSwing: Float, swingMult: Float) {
        left.pitch = cos(limbSwing * 0.6662f + PI.toFloat()) * swingMult
        right.pitch = cos(limbSwing * 0.6662f) * swingMult
    }
}