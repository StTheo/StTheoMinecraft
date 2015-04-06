package me.sttheo.sttheomc.listeners;

import com.google.inject.Inject;
import me.sttheo.sttheomc.arena.ArenaScoreboardManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerTeleportEvent;

/**
 * Created by theodoregardner on 4/5/15.
 *
 * Teleport listener configured with a monitor, or read-only, priority
 */
public final class PlayerMonitorTeleportListener implements BaseListener<PlayerTeleportEvent> {
    public static final String ARENA_WORLD_NAME = "arena";
    private final ArenaScoreboardManager arenaScoreboardManager;

    @Inject
    public PlayerMonitorTeleportListener(ArenaScoreboardManager arenaScoreboardManager) {
        this.arenaScoreboardManager = arenaScoreboardManager;
    }

    @Override
    @EventHandler(priority = EventPriority.MONITOR)
    public void onEventCalled(PlayerTeleportEvent event) {
        boolean wasInArena = event.getFrom().getWorld().getName().equals(ARENA_WORLD_NAME);
        boolean isNowInArena = event.getTo().getWorld().getName().equals(ARENA_WORLD_NAME);
        if (!wasInArena && isNowInArena) {
            arenaScoreboardManager.registerPlayer(event.getPlayer());
        }
        if (wasInArena && !isNowInArena) {
            arenaScoreboardManager.unregisterPlayer(event.getPlayer());
        }

    }
}
