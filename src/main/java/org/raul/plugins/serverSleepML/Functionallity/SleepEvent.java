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
    private static Set<Player> sleptTonight = new HashSet<>();
    private boolean isNight = false;

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

        isNight = world.getTime() >= 13000;
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

        List<Player> players = world.getPlayers();
        if (players.isEmpty()) return;

        long sleepingCount = players.stream()
                .filter(LivingEntity::isSleeping)
                .count();

        double percentSleeping = (double) (sleepingCount - 1) / players.size() * 100;

        if (percentSleeping < config.getPercent() && isNight) {
            broadcastMsg(world, languageMsg.notEnoughPlayers(players.size(),
                    (int) sleepingCount, (int) Math.round(percentSleeping)));
            return;
        }

        sleptTonight.remove(player);
    }

    private void checkSleepPercentage(World world) {
        List<Player> players = world.getPlayers();
        if (players.isEmpty()) return;

        long sleepingCount = players.stream()
                .filter(LivingEntity::isSleeping)
                .count();

        double percentSleeping = (double) sleepingCount / players.size() * 100;

        if (percentSleeping >= config.getPercent() && sleepingCount >= 1) {
            broadcastMsg(world, languageMsg.sleepingServer());

            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                world.setTime(900);
                isNight = false;
            }, 15L);

            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                for (Player p : sleptTonight) {
                    if (p != null && p.isOnline()) {
                        p.sendMessage(languageMsg.nightPassed());
                    }
                }
                sleptTonight.clear();
            }, 20L);

        } else {
            broadcastMsg(world, languageMsg.notEnoughPlayers(players.size(),
                    (int) sleepingCount, (int) Math.round(percentSleeping)));
        }


    }

    private void broadcastMsg(World world, String msg) {
        world.getPlayers().forEach(p -> p.sendMessage(msg));
    }

}
