package me.sshcrack.randomstuff.mixin;

import me.sshcrack.randomstuff.RandomStuffMod;
import me.sshcrack.randomstuff.util.test.events.TitleRenderEvent;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleRenderMixin {
    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) {
        RandomStuffMod.LOGGER.info("Firing new Event...");
        RandomStuffMod.EVENT_BUS.fireEvent(new TitleRenderEvent());
    }
}
