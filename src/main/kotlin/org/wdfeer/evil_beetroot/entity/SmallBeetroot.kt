package org.wdfeer.evil_beetroot.entity

import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.entity.ai.goal.*
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.mob.HostileEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Items
import net.minecraft.util.Identifier
import net.minecraft.world.World
import org.wdfeer.evil_beetroot.EvilBeetrootMod

class SmallBeetroot(world: World?) : HostileEntity(TYPE, world) {
    companion object {
        val TYPE: EntityType<SmallBeetroot> = FabricEntityTypeBuilder.create<SmallBeetroot>(
            SpawnGroup.CREATURE
        ) { type, world -> SmallBeetroot(world) }
            .dimensions(EntityDimensions.fixed(0.75f, 0.75f))
            .build()
        
        fun getIdentifier(): Identifier = EvilBeetrootMod.getIdentifier("small_beetroot")

        fun createMobAttributes(): DefaultAttributeContainer.Builder {
            return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.33)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0)
        }
    }

    init {
        this.goalSelector.add(1, SwimGoal(this))
        this.goalSelector.add(2, MeleeAttackGoal(this, 1.0, true))
        this.goalSelector.add(3, WanderAroundGoal(this, 1.0))
        this.goalSelector.add(4, LookAtEntityGoal(this, PlayerEntity::class.java, 8.0f))
        this.goalSelector.add(5, LookAroundGoal(this))

        this.targetSelector.add(1, ActiveTargetGoal(this, PlayerEntity::class.java, true))
    }

    override fun dropLoot(damageSource: DamageSource?, causedByPlayer: Boolean) {
        super.dropLoot(damageSource, causedByPlayer)

        this.dropItem(Items.BEETROOT, 1)
    }
}