package me.sttheo.sttheomc.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by theodoregardner on 4/5/15.
 *
 * Used to handle custom teleport logic
 */
public final class PlayerChatListener implements BaseListener<AsyncPlayerChatEvent> {
    @Override
    @EventHandler(priority = EventPriority.MONITOR)
    public void onEventCalled(AsyncPlayerChatEvent event) {
        //TODO: Regex & scheduling
    }
}
