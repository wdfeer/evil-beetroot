package org.wdfeer.evil_beetroot.entity

import net.minecraft.entity.EntityType
import net.minecraft.entity.ai.goal.*
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.mob.HostileEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Items
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Identifier
import net.minecraft.world.World
import org.wdfeer.evil_beetroot.EvilBeetrootMod
import org.wdfeer.evil_beetroot.config.BeetConfig
import org.wdfeer.evil_beetroot.entity.common.MonsterTypeBuilder
import org.wdfeer.evil_beetroot.entity.spawn.BeetrootBossSpawner
import org.wdfeer.evil_beetroot.item.ModItems

class SmallBeetroot(world: World?) : HostileEntity(TYPE, world) {
    companion object {
        val TYPE: EntityType<SmallBeetroot> = MonsterTypeBuilder.build(0.75f, 0.75f, ::SmallBeetroot)

        fun getIdentifier(): Identifier = EvilBeetrootMod.getIdentifier("small_beetroot")

        fun createMobAttributes(): DefaultAttributeContainer.Builder {
            return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.33)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0)
        }
    }

    init {
        goalSelector.add(1, SwimGoal(this))
        goalSelector.add(2, MeleeAttackGoal(this, 1.0, true))
        goalSelector.add(3, WanderAroundGoal(this, 1.0))
        goalSelector.add(4, LookAtEntityGoal(this, PlayerEntity::class.java, 8.0f))
        goalSelector.add(5, LookAroundGoal(this))

        targetSelector.add(1, ActiveTargetGoal(this, PlayerEntity::class.java, true))
    }

    override fun dropLoot(damageSource: DamageSource?, causedByPlayer: Boolean) {
        super.dropLoot(damageSource, causedByPlayer)

        if (random.nextFloat() < BeetConfig.SMALL_BEETROOT_SENTIENT_DROP_CHANCE)
            dropItem(ModItems.SENTIENT_BEETROOT, 1)
        else
            dropItem(Items.BEETROOT, 1)
    }

    override fun onDeath(damageSource: DamageSource?) {
        super.onDeath(damageSource)

        if (damageSource != null && damageSource.attacker is ServerPlayerEntity){
            val player: ServerPlayerEntity = damageSource.attacker as ServerPlayerEntity
            BeetrootBossSpawner.onSmallBeetrootKilled(player)
        }
    }
}