package net.examplemod.forge

import dev.architectury.platform.forge.EventBuses
import net.examplemod.ExampleMod
import net.examplemod.ExampleMod.init
import net.examplemod.forge.datagen.ChineseProvider
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_CONTEXT


@Mod(ExampleMod.MOD_ID)
class ExampleModForge {
    init {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(ExampleMod.MOD_ID, MOD_CONTEXT.getKEventBus())
        MOD_CONTEXT.getKEventBus().addListener(this::onGatherData)
        init()
    }

    private fun onGatherData(event: GatherDataEvent) {
        val gen = event.generator
        gen.addProvider(true, ChineseProvider(gen))
    }
}