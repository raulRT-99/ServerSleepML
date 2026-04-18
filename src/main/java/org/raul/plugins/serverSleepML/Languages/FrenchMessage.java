package org.raul.plugins.serverSleepML.Languages;

import org.raul.plugins.serverSleepML.Functionallity.Config;

public class FrenchMessage extends LanguageMessages {

    public FrenchMessage(Config config) {
        super(config);
    }

    @Override
    public String notEnoughPlayers(int totalPlayers, int sleepingPlayers, int percent) {
        int atLeast = (int) Math.ceil((double) (percent * totalPlayers) / 100);
        if (config.isShowPercent()) {
            return "§fIl y a §e" + percent + "%§f de joueurs qui dorment. §e" + config.getPercent() + "%§f minimum requis.";
        } else {
            return "§fIl y a §e" + sleepingPlayers + "§f joueurs qui dorment. §e" + atLeast + " minimum requis.";
        }
    }

    @Override
    public String sleepingServer() {
        return "§aPassage de la nuit...";
    }

    @Override
    public String nightPassed() {
        return "§aBonjour !";
    }

    @Override
    public String serverStartMessage() {
        return "§9Merci d'utiliser mon plugin !\n§7J'espère que tu l'apprécies --- raulRT99 (Raul Reyes)";
    }

    @Override
    public String notValidNumber() {
        return "§cEntrez un nombre valide";
    }

    @Override
    public String playerSleeping(String player) {
        return "§fBonne nuit §6" + player + " !";
    }
}
