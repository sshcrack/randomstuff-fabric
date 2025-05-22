package me.sshcrack.randomstuff.util.test.events;

import me.sshcrack.randomstuff.RandomStuffMod;
import me.sshcrack.randomstuff.util.test.events.annotations.SubscribeEvent;

public class TestEventHandler {
    @SubscribeEvent
    public void onTitleRender(TitleRenderEvent event) {
        RandomStuffMod.LOGGER.info(String.format("Event message %s", event.getTest()));
    }
}
