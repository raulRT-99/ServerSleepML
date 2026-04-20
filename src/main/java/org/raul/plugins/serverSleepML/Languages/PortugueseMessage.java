package org.raul.plugins.serverSleepML.Languages;

import org.raul.plugins.serverSleepML.Functionallity.Config;

public class PortugueseMessage extends LanguageMessages {

    public PortugueseMessage(Config config) {
        super(config);
    }

    @Override
    public String notEnoughPlayers(int totalPlayers, int sleepingPlayers, int percent) {
        int atLeast = (int) Math.ceil((double) (config.getPercent() * totalPlayers) / 100);
        if (config.isShowPercent()) {
            return "§fHá §e" + percent + "%§f dos jogadores dormindo. São necessários pelo menos §e" + config.getPercent() + "%§f.";
        } else {
            return "§fHá §e" + sleepingPlayers + "§f jogadores dormindo. São necessários pelo menos §e" + atLeast + ".";
        }
    }

    @Override
    public String sleepingServer() {
        return "§aPulando a noite...";
    }

    @Override
    public String nightPassed() {
        return "§aBom dia!";
    }

    @Override
    public String serverStartMessage() {
        return "§9Obrigado por usar meu plugin!\n§7Espero que goste --- raulRT99 (Raul Reyes)";
    }

    @Override
    public String notValidNumber() {
        return "§cDigite um número válido";
    }

    @Override
    public String newPercent(int newPercent) {
        return "A porcentagem para dormir foi alterada para: "+newPercent;
    }

    @Override
    public String playerSleeping(String player) {
        return "§fBoa noite §6" + player + "!";
    }
}
