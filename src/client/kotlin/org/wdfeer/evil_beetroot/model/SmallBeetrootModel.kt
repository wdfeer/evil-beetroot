package org.wdfeer.evil_beetroot.model

import com.google.common.collect.ImmutableList
import net.minecraft.client.model.*
import net.minecraft.client.render.VertexConsumer
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.render.entity.model.EntityModelPartNames
import net.minecraft.client.util.math.MatrixStack
import org.wdfeer.evil_beetroot.entity.SmallBeetroot


class SmallBeetrootModel(modelPart: ModelPart) : EntityModel<SmallBeetroot>() {
    companion object {
        fun getTexturedModelData(): TexturedModelData {
            val modelData = ModelData()
            val modelPartData = modelData.root
            modelPartData.addChild(
                EntityModelPartNames.CUBE,
                ModelPartBuilder.create().uv(0, 0).cuboid(-6f, 12f, -6f, 12f, 12f, 12f),
                ModelTransform.pivot(0f, 0f, 0f)
            )
            return TexturedModelData.of(modelData, 64, 64)
        }
    }

    private var base: ModelPart = modelPart.getChild(EntityModelPartNames.CUBE)


    override fun render(
        matrices: MatrixStack?,
        vertices: VertexConsumer?,
        light: Int,
        overlay: Int,
        red: Float,
        green: Float,
        blue: Float,
        alpha: Float
    ) {
        ImmutableList.of(this.base).forEach { modelRenderer ->
            modelRenderer.render(
                matrices,
                vertices,
                light,
                overlay,
                1f,
                1f,
                1f,
                alpha
            )
        }
    }

    override fun setAngles(
        entity: SmallBeetroot?,
        limbAngle: Float,
        limbDistance: Float,
        animationProgress: Float,
        headYaw: Float,
        headPitch: Float
    ) {

    }
}