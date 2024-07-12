package org.wdfeer.evil_beetroot.entity.spawn

object MobSpawnRules {
    fun initialize() {
        SmallBeetrootSpawner.initialize()
        BeetrootPhantomSpawner.initialize()
        BeetrootBossSpawner.initialize()
    }
}