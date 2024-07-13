package org.wdfeer.evil_beetroot.util

import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Vec3i
import net.minecraft.world.World

fun World.isSolid(pos: BlockPos): Boolean = this.getBlockState(pos).isSolidBlock(this, pos)

fun World.isSolid(pos: Vec3i): Boolean = this.getBlockState(BlockPos(pos)).isSolidBlock(this, BlockPos(pos))
