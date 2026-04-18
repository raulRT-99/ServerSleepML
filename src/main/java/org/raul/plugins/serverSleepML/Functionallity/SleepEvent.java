package org.raul.plugins.serverSleepML.Functionallity;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.raul.plugins.serverSleepML.Languages.LanguageMessages;

import java.util.*;

public class SleepEvent implements Listener {

    private final JavaPlugin plugin;
    private Config config;
    private final LanguageMessages languageMsg;
    private static Map<World, Boolean> almostSleeping = new HashMap<>();
    private static Set<Player> sleptTonight = new HashSet<>();

    public SleepEvent(JavaPlugin plugin, Config config, LanguageMessages languageMsg) {
        this.plugin = plugin;
        this.config = config;
        this.languageMsg = languageMsg;
    }

    @EventHandler
    public void onEntryBed(PlayerBedEnterEvent bedEntry) {
        if (!bedEntry.getBedEnterResult().equals(PlayerBedEnterEvent.BedEnterResult.OK)) return;

        Player player = bedEntry.getPlayer();
        World world = bedEntry.getPlayer().getWorld();

        player.sendMessage(languageMsg.playerSleeping(player.getName()));

        sleptTonight.add(player);

        new BukkitRunnable() {
            @Override
            public void run() {
                checkSleepPercentage(world);
            }
        }.runTaskLater(plugin, 5L);
    }

    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent bedLeave) {
        Player player = bedLeave.getPlayer();
        World world = bedLeave.getPlayer().getWorld();

        sleptTonight.remove(player);

        List<Player> players = world.getPlayers();
        if (players.isEmpty()) return;

        long sleepingCount = players.stream()
                .filter(LivingEntity::isSleeping)
                .count();

        if (almostSleeping.getOrDefault(world, false)) {
            world.setTime(13000);
            almostSleeping.put(world, false);
            broadcastMsg(world, languageMsg.notEnoughPlayers(players.size(),
                    (int) sleepingCount, config.getPercent()));
            return;
        }

        checkSleepPercentage(world);
    }

    private void checkSleepPercentage(World world) {
        List<Player> players = world.getPlayers();
        if (players.isEmpty()) return;

        long sleepingCount = players.stream()
                .filter(LivingEntity::isSleeping)
                .count();

        double percentSleeping = (double) sleepingCount / players.size() * 100;

        if (sleepingCount >= 1) {
            broadcastMsg(world, languageMsg.notEnoughPlayers(players.size(),
                    (int) sleepingCount, config.getPercent()));
        }

        if (percentSleeping >= config.getPercent()) {
            broadcastMsg(world, languageMsg.sleepingServer());
            world.setTime(1000);
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                for (Player p : sleptTonight) {
                    if (p != null && p.isOnline()) {
                        p.sendMessage(languageMsg.nightPassed());
                    }
                }
                sleptTonight.clear();
            }, 20L);
        }
    }

    private void broadcastMsg(World world, String msg) {
        world.getPlayers().forEach(p -> p.sendMessage(msg));
    }

}
