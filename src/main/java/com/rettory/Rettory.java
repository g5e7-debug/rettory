package com.rettory;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafxmod.FXModLanguageProvider;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import com.mojang.blaze3d.systems.RenderSystem;
import org.lwjgl.opengl.GL11;

@Mod("rettory")
public class Rettory {
    public static final String MOD_ID = "rettory";

    public Rettory() {
        IEventBus modEventBus = FXModLanguageProvider.getInstance().getModEventBus();
        modEventBus.addListener(this::onClientSetup);
    }

    private void onClientSetup(final FMLClientSetupEvent event) {
        // Инициализация клиентских ресурсов
    }
}

@Mod.EventBusSubscriber(modid = Rettory.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
class RenderEventHandler {
    @SubscribeEvent
    public static void onRenderLevelStage(RenderLevelStageEvent event) {
        switch (event.getStage()) {
            case AFTER_WEATHER:
                handleRenderAfterWeather(event);
                break;
            case AFTER_PARTICLES:
                handleRenderAfterParticles(event);
                break;
            default:
                break;
        }
    }

    @SubscribeEvent
    public static void onRenderGui(RenderGuiEvent.Post event) {
        // Рендер после GUI
    }

    private static void handleRenderAfterWeather(RenderLevelStageEvent event) {
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        RenderSystem.disableBlend();
    }

    private static void handleRenderAfterParticles(RenderLevelStageEvent event) {
        // Обработка частиц
    }
}