package org.wdfeer.evil_beetroot.model

import net.minecraft.client.model.*
import net.minecraft.client.render.VertexConsumer
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.util.math.MatrixStack
import org.wdfeer.evil_beetroot.entity.BeetrootBoss
import kotlin.math.PI
import kotlin.math.cos

// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
class BeetrootBossModel(root: ModelPart) : EntityModel<BeetrootBoss?>() {
    private val head: ModelPart = root.getChild("head")
    private val rightLeg: ModelPart = root.getChild("right_leg")
    private val leftLeg: ModelPart = root.getChild("left_leg")
    override fun setAngles(
        entity: BeetrootBoss?,
        limbSwing: Float,
        limbSwingAmount: Float,
        ageInTicks: Float,
        netHeadYaw: Float,
        headPitch: Float
    ) {
        // Set head angles based on input parameters
        head.yaw = netHeadYaw * (PI.toFloat() / 180f)
        head.pitch = headPitch * (PI.toFloat() / 180f)

        // Calculate the walking animation angles for the legs
        val rightLegRotation = cos(limbSwing * 0.6662f) * 0.7f * limbSwingAmount
        val leftLegRotation = cos(limbSwing * 0.6662f + Math.PI.toFloat()) * 0.7f * limbSwingAmount

        // Set leg angles
        rightLeg.pitch = rightLegRotation
        leftLeg.pitch = leftLegRotation
    }

    override fun render(
        matrices: MatrixStack,
        vertexConsumer: VertexConsumer,
        light: Int,
        overlay: Int,
        red: Float,
        green: Float,
        blue: Float,
        alpha: Float
    ) {
        head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha)
        rightLeg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha)
        leftLeg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha)
    }

    companion object {
        fun getTexturedModelData(): TexturedModelData {
            val modelData = ModelData()
            val modelPartData = modelData.root
            modelPartData.addChild(
                "head",
                ModelPartBuilder.create().uv(0, 0).cuboid(-39.0f, -56.0f, -24.0f, 48.0f, 48.0f, 48.0f, Dilation(0.0f)),
                ModelTransform.pivot(15.0f, 16.0f, 0.0f)
            )

            modelPartData.addChild(
                "left_leg",
                ModelPartBuilder.create().uv(64, 96).cuboid(7.0f, -20.0f, -8.0f, 16.0f, 20.0f, 16.0f, Dilation(0.0f)),
                ModelTransform.pivot(0.0f, 24.0f, 0.0f)
            )

            modelPartData.addChild(
                "right_leg",
                ModelPartBuilder.create().uv(0, 96).cuboid(-23.0f, -20.0f, -8.0f, 16.0f, 20.0f, 16.0f, Dilation(0.0f)),
                ModelTransform.pivot(0.0f, 24.0f, 0.0f)
            )
            return TexturedModelData.of(modelData, 256, 256)
        }
    }
}