package org.raul.plugins.serverSleepML.Languages;

import org.raul.plugins.serverSleepML.Functionallity.Config;

public class SpanishMessage extends LanguageMessages {

    public SpanishMessage(Config config) {
        super(config);
    }

    @Override
    public String notEnoughPlayers(int totalPlayers, int sleepingPlayers, int percent) {
        int atLeast = (int) Math.ceil((double) (config.getPercent() * totalPlayers) / 100);
        if (config.isShowPercent()) {
            return "§fHay §e" + percent + "%§f de jugadores durmiendo. Se requieren §e" + config.getPercent() + "%§f por lo menos.";
        } else {
            return "§fHay §e" + sleepingPlayers + "§f jugadores durmiendo. Se requieren por lo menos §e" + atLeast + ".";
        }
    }

    @Override
    public String sleepingServer() {
        return "§aPasando la noche...";
    }

    @Override
    public String nightPassed() {
        return "§aBuenos días";
    }

    @Override
    public String serverStartMessage() {
        return "§9Gracias por usar mi plugin!\n§7Espero lo disfrutes --- raulRT99 (Raul Reyes)";
    }

    @Override
    public String notValidNumber() {
        return "§cEscribe un número válido";
    }

    @Override
    public String newPercent(int newPercent) {
        return "El porcentaje para dormir ah sido cambiado a: "+newPercent;
    }

    @Override
    public String playerSleeping(String player) {
        return "§fBuenas noches §6" + player;
    }
}
