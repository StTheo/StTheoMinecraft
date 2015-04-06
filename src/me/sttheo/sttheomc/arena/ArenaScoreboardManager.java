package me.sttheo.sttheomc.arena;

import com.google.common.collect.Maps;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.util.List;
import java.util.Map;

/**
 * Created by theodoregardner on 4/5/15.
 *
 * Manages arena scores, displaying the top 10 scores and the player's score
 */
public class ArenaScoreboardManager {
    public static final String ARENA_NAME = "arena";
    public static final String DASHBOARD = "arenaDashboard";
    private Map<String, Integer> playerScores = Maps.newHashMap();

    public void registerPlayer(Player player) {
        player.setScoreboard(createNewScoreboard());
        updatePlayer(player);
    }

    public void update() {
        List<Player> players = Bukkit.getWorld(ARENA_NAME).getPlayers();
        //TODO: Populate top 10 playerScores
        for (Player player : players) {
            updatePlayer(player);
        }
    }

    public void unregisterPlayer(Player player) {
        player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
    }

    private Scoreboard createNewScoreboard() {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective dashboardObjective = scoreboard.registerNewObjective(DASHBOARD, "dummy");
        dashboardObjective.setDisplayName(ChatColor.RED + "Arena");
        return scoreboard;
    }

    private void updatePlayer(Player player) {
        Objective dashboardObjective = player.getScoreboard().getObjective(DASHBOARD);
        if (dashboardObjective == null) {
            player.setScoreboard(createNewScoreboard());
            dashboardObjective = player.getScoreboard().getObjective(DASHBOARD);
        }
        for (Map.Entry<String, Integer> playerScore : playerScores.entrySet()) {
            Score score = dashboardObjective.getScore(playerScore.getKey());
            score.setScore(playerScore.getValue());
        }
    }

}
