package me.sttheo.sttheomc;

import me.sttheo.sttheomc.listeners.PlayerTeleportListener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by tedgardner on 4/3/15.
 */
public class StTheoMinecraft extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info(getDescription().getName() + " has been enabled.");
        PlayerTeleportListener.register(this);
    }

    @Override
    public void onDisable() {
        getLogger().info(getDescription().getName() + " has been disabled.");
    }
}
