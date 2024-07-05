package org.wdfeer.evil_beetroot.model

import net.minecraft.client.model.*
import net.minecraft.client.render.VertexConsumer
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.util.math.MatrixStack
import org.wdfeer.evil_beetroot.entity.BeetrootBoss
import kotlin.math.cos
import kotlin.math.sin

// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
class BeetrootBossModel(root: ModelPart) : EntityModel<BeetrootBoss?>() {
    private val head: ModelPart = root.getChild("head")
    private val leftLeg: ModelPart = root.getChild("left_leg")
    private val rightLeg: ModelPart = root.getChild("right_leg")
    private val leftArm: ModelPart = root.getChild("left_arm")
    private val rightArm: ModelPart = root.getChild("right_arm")
    override fun setAngles(
        entity: BeetrootBoss?,
        limbSwing: Float,
        limbSwingAmount: Float,
        ageInTicks: Float,
        netHeadYaw: Float,
        headPitch: Float
    ) {
        ModelRotationHelper.rotateHead(head, netHeadYaw, headPitch)

        ModelRotationHelper.rotateLegs(leftLeg, rightLeg, limbSwing, limbSwingAmount * 0.6f)

        rotateArms(limbSwing)
    }

    private fun rotateArms(limbSwing: Float) {
        leftArm.yaw = sin(limbSwing) * 0.5f
        rightArm.yaw = cos(limbSwing) * 0.5f
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
        leftLeg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha)
        rightLeg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha)
        leftArm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha)
        rightArm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha)
    }

    companion object {
        val texturedModelData: TexturedModelData
            get() {
                val modelData = ModelData()
                val modelPartData = modelData.root
                modelPartData.addChild(
                    "head",
                    ModelPartBuilder.create().uv(0, 0)
                        .cuboid(-39.0f, -56.0f, -24.0f, 48.0f, 48.0f, 48.0f, Dilation(0.0f)),
                    ModelTransform.pivot(15.0f, 16.0f, 0.0f)
                )

                modelPartData.addChild(
                    "left_leg",
                    ModelPartBuilder.create().uv(64, 96)
                        .cuboid(7.0f, -20.0f, -8.0f, 16.0f, 20.0f, 16.0f, Dilation(0.0f)),
                    ModelTransform.pivot(0.0f, 24.0f, 0.0f)
                )

                 modelPartData.addChild(
                    "right_leg",
                    ModelPartBuilder.create().uv(0, 96)
                        .cuboid(-23.0f, -20.0f, -8.0f, 16.0f, 20.0f, 16.0f, Dilation(0.0f)),
                    ModelTransform.pivot(0.0f, 24.0f, 0.0f)
                )

                val left_arm = modelPartData.addChild(
                    "left_arm",
                    ModelPartBuilder.create().uv(112, 148)
                        .cuboid(24.0f, -16.0f, -8.0f, 16.0f, 16.0f, 16.0f, Dilation(0.0f)),
                    ModelTransform.pivot(0.0f, -16.0f, 0.0f)
                )

                left_arm.addChild(
                    "4_r1",
                    ModelPartBuilder.create().uv(0, 132)
                        .cuboid(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 16.0f, Dilation(0.0f)),
                    ModelTransform.of(54.0f, 11.0f, -8.0f, 1.1436f, 0.5649f, 1.8579f)
                )

                 left_arm.addChild(
                    "3_r1",
                    ModelPartBuilder.create().uv(144, 0)
                        .cuboid(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 16.0f, Dilation(0.0f)),
                    ModelTransform.of(51.0f, 2.0f, -4.0f, 0.6196f, 0.6264f, 1.1228f)
                )

                 left_arm.addChild(
                    "2_r1",
                    ModelPartBuilder.create().uv(160, 132)
                        .cuboid(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 16.0f, Dilation(0.0f)),
                    ModelTransform.of(43.0f, -3.0f, 0.0f, 0.1946f, 0.3931f, 0.4752f)
                )

                val right_arm = modelPartData.addChild(
                    "right_arm",
                    ModelPartBuilder.create().uv(0, 164)
                        .cuboid(-40.0f, -16.0f, -8.0f, 16.0f, 16.0f, 16.0f, Dilation(0.0f)),
                    ModelTransform.pivot(0.0f, -16.0f, 0.0f)
                )

                right_arm.addChild(
                    "4_r2",
                    ModelPartBuilder.create().uv(160, 96)
                        .cuboid(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 16.0f, Dilation(0.0f)),
                    ModelTransform.of(-54.0f, 11.0f, -8.0f, 1.1436f, -0.5649f, -1.8579f)
                )

                right_arm.addChild(
                    "3_r2",
                    ModelPartBuilder.create().uv(112, 116)
                        .cuboid(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 16.0f, Dilation(0.0f)),
                    ModelTransform.of(-51.0f, 2.0f, -4.0f, 0.6196f, -0.6264f, -1.1228f)
                )

                right_arm.addChild(
                    "2_r2",
                    ModelPartBuilder.create().uv(64, 132)
                        .cuboid(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 16.0f, Dilation(0.0f)),
                    ModelTransform.of(-43.0f, -3.0f, 0.0f, 0.1946f, -0.3931f, -0.4752f)
                )
                return TexturedModelData.of(modelData, 256, 256)
            }
    }
}