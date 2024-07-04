package org.wdfeer.evil_beetroot.model

import net.minecraft.client.model.*
import net.minecraft.client.render.VertexConsumer
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.util.math.MatrixStack
import org.wdfeer.evil_beetroot.entity.SmallBeetroot

// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
class SmallBeetrootModel(root: ModelPart) : EntityModel<SmallBeetroot?>() {
    private val bb_main: ModelPart = root.getChild("bb_main")
    override fun setAngles(
        entity: SmallBeetroot?,
        limbSwing: Float,
        limbSwingAmount: Float,
        ageInTicks: Float,
        netHeadYaw: Float,
        headPitch: Float
    ) {
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
        bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha)
    }

    companion object {
        val texturedModelData: TexturedModelData
            get() {
                val modelData = ModelData()
                val modelPartData = modelData.root
                val bb_main = modelPartData.addChild(
                    "bb_main",
                    ModelPartBuilder.create().uv(0, 0).cuboid(-6.0f, -19.0f, -6.0f, 12.0f, 12.0f, 12.0f, Dilation(0.0f))
                        .uv(16, 24).cuboid(-6.0f, -7.0f, -2.0f, 4.0f, 7.0f, 4.0f, Dilation(0.0f))
                        .uv(0, 24).cuboid(2.0f, -7.0f, -2.0f, 4.0f, 7.0f, 4.0f, Dilation(0.0f)),
                    ModelTransform.pivot(0.0f, 24.0f, 0.0f)
                )
                return TexturedModelData.of(modelData, 64, 64)
            }
    }
}