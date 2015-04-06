package me.sttheo.sttheomc.listeners;

import org.bukkit.event.Event;
import org.bukkit.event.Listener;

/**
 * Created by theodoregardner on 4/5/15.
 *
 * Base listener class used to make things nice and structured (while also eliminating the need for the
 * "@SuppressWarnings("unused")" annotation in all the base classes.
 */
public interface BaseListener<E extends Event> extends Listener {
    @SuppressWarnings("unused")
    void onEventCalled(E event);
}
