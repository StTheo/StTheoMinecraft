package me.sttheo.sttheomc;

import com.google.inject.Guice;
import com.google.inject.Injector;
import me.sttheo.sttheomc.guice.MCInjector;
import me.sttheo.sttheomc.listeners.*;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by tedgardner on 4/3/15.
 *
 * Main JavaPlugin class for the StTheo Minecraft plugin.
 * TODO: Name me?
 */
public class StTheoMinecraft extends JavaPlugin {
    private final Injector injector;

    public StTheoMinecraft() {
        this.injector = Guice.createInjector(new MCInjector());
    }

    @Override
    public void onEnable() {
        getLogger().info(getDescription().getName() + " has been enabled.");
        register(PlayerWritableTeleportListener.class);
        register(PlayerMonitorTeleportListener.class);
        register(PlayerChatListener.class);
        register(PlayerDeathListener.class);
    }

    @Override
    public void onDisable() {
        getLogger().info(getDescription().getName() + " has been disabled.");
    }

    private <T extends Event> void register(Class<? extends BaseListener<T>> listenerClass) {
        getServer().getPluginManager().registerEvents(injector.getInstance(listenerClass), this);
    }
}
