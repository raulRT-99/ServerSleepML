package org.raul.plugins.serverSleepML.Languages;

import org.raul.plugins.serverSleepML.Functionallity.Config;

public class GermanMessage extends LanguageMessages {

    public GermanMessage(Config config) {
        super(config);
    }

    @Override
    public String notEnoughPlayers(int totalPlayers, int sleepingPlayers, int percent) {
        int atLeast = (int) Math.ceil((double) (config.getPercent() * totalPlayers) / 100);
        if (config.isShowPercent()) {
            return "§fEs gibt §e" + percent + "%§f schlafende Spieler. Mindestens §e" + config.getPercent() + "%§f erforderlich.";
        } else {
            return "§fEs gibt §e" + sleepingPlayers + "§f schlafende Spieler. Mindestens §e" + atLeast + " erforderlich.";
        }
    }

    @Override
    public String sleepingServer() {
        return "§aNacht überspringen...";
    }

    @Override
    public String nightPassed() {
        return "§aGuten Morgen!";
    }

    @Override
    public String serverStartMessage() {
        return "§9Danke dass du mein Plugin nutzt!\n§7Viel Spaß dabei --- raulRT99 (Raul Reyes)";
    }

    @Override
    public String notValidNumber() {
        return "§cGib eine gültige Zahl ein";
    }

    @Override
    public String newPercent(int newPercent) {
        return "Der Schlafprozentsatz wurde auf "+newPercent+" geändert";
    }

    @Override
    public String playerSleeping(String player) {
        return "§fGute Nacht §6" + player + "!";
    }
}
