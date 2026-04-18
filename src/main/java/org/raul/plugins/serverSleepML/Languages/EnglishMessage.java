package org.raul.plugins.serverSleepML.Languages;

import org.raul.plugins.serverSleepML.Functionallity.Config;

public class EnglishMessage extends LanguageMessages {

    public EnglishMessage(Config config) {
        super(config);
    }

    @Override
    public String notEnoughPlayers(int totalPlayers, int sleepingPlayers, int percent) {
        int atLeast = (int) Math.ceil((double) (percent * totalPlayers) / 100);
        if (config.isShowPercent()) {
            return "§fThere are §e" + percent + "%§f of players sleeping. At least §e" + config.getPercent() + "%§f are required.";
        } else {
            return "§fThere are §e" + sleepingPlayers + "§f players sleeping. At least §e" + atLeast + " are required.";
        }
    }

    @Override
    public String sleepingServer() {
        return "§aSkipping night...";
    }

    @Override
    public String nightPassed() {
        return "§aGood morning!";
    }

    @Override
    public String serverStartMessage() {
        return "§9Thanks for using my plugin!\n§7Hope you enjoy it --- raulRT99 (Raul Reyes)";
    }

    @Override
    public String notValidNumber() {
        return "§cEnter a valid number";
    }

    @Override
    public String playerSleeping(String player) {
        return "§fGood night §6" + player;
    }

}
