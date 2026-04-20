package org.raul.plugins.serverSleepML.Languages;

import org.raul.plugins.serverSleepML.Functionallity.Config;

public class RussianMessage extends LanguageMessages {

    public RussianMessage(Config config) {
        super(config);
    }

    @Override
    public String notEnoughPlayers(int totalPlayers, int sleepingPlayers, int percent) {
        int atLeast = (int) Math.ceil((double) (config.getPercent() * totalPlayers) / 100);
        if (config.isShowPercent()) {
            return "§f§e" + percent + "%§f игроков спит. Нужно минимум §e" + config.getPercent() + "%§f.";
        } else {
            return "§f§e" + sleepingPlayers + "§f игроков спит. Нужно минимум §e" + atLeast + ".";
        }
    }

    @Override
    public String sleepingServer() {
        return "§aПропуск ночи...";
    }

    @Override
    public String nightPassed() {
        return "§aДоброе утро!";
    }

    @Override
    public String serverStartMessage() {
        return "§9Спасибо за использование моего плагина!\n§7Надеюсь тебе понравится --- raulRT99 (Raul Reyes)";
    }

    @Override
    public String notValidNumber() {
        return "§cВведите корректное число";
    }

    @Override
    public String newPercent(int newPercent) {
        return "Процент для сна изменен на: "+newPercent;
    }

    @Override
    public String playerSleeping(String player) {
        return "§fСпокойной ночи §6" + player + "§f!";
    }
}
