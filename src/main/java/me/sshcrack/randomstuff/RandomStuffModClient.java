package me.sshcrack.randomstuff;

import me.sshcrack.randomstuff.client.renderer.TPArrowEntityRenderer;
import me.sshcrack.randomstuff.client.renderer.TntArrowEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class RandomStuffModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(RandomStuffMod.TntArrowEntityType, TntArrowEntityRenderer::new);
        EntityRendererRegistry.register(RandomStuffMod.TPArrowEntityType, TPArrowEntityRenderer::new);
    }
}
