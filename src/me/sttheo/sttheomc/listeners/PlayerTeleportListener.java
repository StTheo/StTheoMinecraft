package me.sttheo.sttheomc.listeners;

import me.sttheo.sttheomc.StTheoMinecraft;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

/**
 * Created by tedgardner on 4/3/15.
 *
 * Used to handle custom teleport logic
 */
public final class PlayerTeleportListener implements Listener {
    private static final String SPECTATOR_TELEPORT_MESSAGE = ChatColor.DARK_AQUA.toString() + "Spectator teleportation isn't allowed here.";

    private PlayerTeleportListener() {
    }

    public static void register(StTheoMinecraft plugin) {
        plugin.getServer().getPluginManager().registerEvents(new PlayerTeleportListener(), plugin);
    }

    @SuppressWarnings("unused")
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        if (PlayerTeleportEvent.TeleportCause.SPECTATE.equals(event.getCause())) {
            event.getPlayer().sendMessage(SPECTATOR_TELEPORT_MESSAGE);
            event.setCancelled(true);
        }
    }
}
