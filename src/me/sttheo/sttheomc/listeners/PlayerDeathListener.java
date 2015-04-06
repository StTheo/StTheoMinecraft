package me.sttheo.sttheomc.listeners;

import com.google.inject.Inject;
import me.sttheo.sttheomc.arena.ArenaStateManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Created by theodoregardner on 4/5/15.
 */
public class PlayerDeathListener implements BaseListener<PlayerDeathEvent> {
    private final ArenaStateManager arenaStateManager;

    @Inject
    public PlayerDeathListener(ArenaStateManager arenaStateManager) {
        this.arenaStateManager = arenaStateManager;
    }

    @Override
    @EventHandler(priority = EventPriority.MONITOR)
    public void onEventCalled(PlayerDeathEvent event) {
        if (event.getEntity().getWorld().getName().equals("arena")) {
            event.setKeepInventory(true);
            event.setKeepLevel(true);
        }

    }
}
