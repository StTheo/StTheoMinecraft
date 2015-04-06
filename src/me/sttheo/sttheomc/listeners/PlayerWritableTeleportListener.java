package me.sttheo.sttheomc.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerTeleportEvent;

/**
 * Created by tedgardner on 4/3/15.
 *
 * Used to handle custom teleport logic
 */
public final class PlayerWritableTeleportListener implements BaseListener<PlayerTeleportEvent> {
    private static final String SPECTATOR_TELEPORT_MESSAGE = ChatColor.DARK_AQUA + "Spectator teleportation isn't allowed here.";

    @Override
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEventCalled(PlayerTeleportEvent event) {
        if (PlayerTeleportEvent.TeleportCause.SPECTATE.equals(event.getCause())) {
            event.getPlayer().sendMessage(SPECTATOR_TELEPORT_MESSAGE);
            event.setCancelled(true);
        }
    }
}
