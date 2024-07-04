package org.wdfeer.evil_beetroot.entity.goal

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.ai.goal.MeleeAttackGoal
import net.minecraft.entity.mob.PathAwareEntity

class LargeEntityMeleeAttackGoal(mob: PathAwareEntity?, speed: Double, pauseWhenMobIdle: Boolean) : MeleeAttackGoal(mob, speed,
    pauseWhenMobIdle
) {
    override fun getSquaredMaxAttackDistance(entity: LivingEntity?): Double {
        return super.getSquaredMaxAttackDistance(entity) / 2.0
    }
}