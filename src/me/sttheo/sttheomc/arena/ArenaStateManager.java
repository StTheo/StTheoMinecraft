package me.sttheo.sttheomc.arena;

import com.google.gson.Gson;
import org.bukkit.entity.Player;

/**
 * Created by theodoregardner on 4/5/15.
 *
 * Handles the "state" (inventory, xp, potion effects) of a player upon entering/exiting the arena
 */
public class ArenaStateManager {
    //TODO: All of this
    public void storeState(Player player) {
        Gson gson1 = new Gson();

        gson1.toJson(player.getInventory());

    }

    public void writeState(Player player) {

    }
}
