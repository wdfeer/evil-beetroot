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
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.Identifier
import net.minecraft.world.World
import org.wdfeer.evil_beetroot.EvilBeetrootMod
import org.wdfeer.evil_beetroot.entity.goal.LargeEntityMeleeAttackGoal
import org.wdfeer.evil_beetroot.item.ModItems
import kotlin.random.Random
import kotlin.random.nextInt

class BeetrootBoss(world: World?) : HostileEntity(TYPE, world) {
    companion object {
        val TYPE: EntityType<BeetrootBoss> = FabricEntityTypeBuilder.create(
            SpawnGroup.MISC
        ) { _, world -> BeetrootBoss(world) }
            .dimensions(EntityDimensions.fixed(3.5f, 3.5f))
            .build()
        
        fun getIdentifier(): Identifier = EvilBeetrootMod.getIdentifier("beetroot_boss")

        fun createMobAttributes(): DefaultAttributeContainer.Builder {
            return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 150.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 80.0)
        }
    }

    init {
        goalSelector.add(1, SwimGoal(this))
        goalSelector.add(2, LargeEntityMeleeAttackGoal(this, 1.0, true))
        goalSelector.add(3, WanderAroundGoal(this, 0.5))
        goalSelector.add(4, LookAtEntityGoal(this, PlayerEntity::class.java, 8.0f))
        goalSelector.add(5, LookAroundGoal(this))

        targetSelector.add(1, ActiveTargetGoal(this, PlayerEntity::class.java, false))

        experiencePoints *= 15
    }

    override fun dropLoot(damageSource: DamageSource?, causedByPlayer: Boolean) {
        super.dropLoot(damageSource, causedByPlayer)

        for (i in 1..4) {
            dropStack(ItemStack(Items.BEETROOT, Random.nextInt(1..6)))
        }

        if (causedByPlayer && random.nextBoolean())
            dropStack(ItemStack(ModItems.SENTIENT_BEETROOT))

        if (causedByPlayer && random.nextBoolean())
            dropItem(ModItems.BEETROOT_HEART)
    }
}