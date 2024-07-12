package org.wdfeer.evil_beetroot.entity

import net.minecraft.entity.EntityType
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.mob.HostileEntity
import net.minecraft.entity.mob.PhantomEntity
import net.minecraft.item.Items
import net.minecraft.util.Identifier
import net.minecraft.world.World
import org.wdfeer.evil_beetroot.EvilBeetrootMod
import org.wdfeer.evil_beetroot.config.BeetConfig
import org.wdfeer.evil_beetroot.entity.common.MonsterTypeBuilder
import org.wdfeer.evil_beetroot.item.ModItems

class BeetrootPhantom(world: World?) : PhantomEntity(TYPE, world) {
    companion object {
        val TYPE: EntityType<BeetrootPhantom> = MonsterTypeBuilder.build(EntityType.PHANTOM.dimensions, ::BeetrootPhantom)

        fun getIdentifier(): Identifier = EvilBeetrootMod.getIdentifier("beetroot_phantom")

        fun createMobAttributes(): DefaultAttributeContainer.Builder {
            return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.33)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7.0)
        }
    }

    override fun dropLoot(damageSource: DamageSource?, causedByPlayer: Boolean) {
        super.dropLoot(damageSource, causedByPlayer)

        if (random.nextFloat() < BeetConfig.PHANTOM_SENTIENT_DROP_CHANCE)
            dropItem(ModItems.SENTIENT_BEETROOT, 1)
        else
            dropItem(Items.BEETROOT, 1)
    }
}