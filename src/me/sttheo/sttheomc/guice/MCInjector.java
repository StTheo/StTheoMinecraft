package me.sttheo.sttheomc.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import me.sttheo.sttheomc.arena.ArenaScoreboardManager;
import me.sttheo.sttheomc.arena.ArenaStateManager;

/**
 * Created by theodoregardner on 4/5/15.
 *
 * Guice injector for the plugin
 */
public class MCInjector extends AbstractModule {
    @Override
    protected void configure() {
        bind(ArenaScoreboardManager.class).in(Singleton.class);
        bind(ArenaStateManager.class).in(Singleton.class);
    }
}
