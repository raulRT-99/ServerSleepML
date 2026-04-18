package org.raul.plugins.serverSleepML.Languages;

import org.raul.plugins.serverSleepML.Functionallity.Config;

public class JapaneseLanguage extends LanguageMessages {

    public JapaneseLanguage(Config config) {
        super(config);
    }

    @Override
    public String notEnoughPlayers(int totalPlayers, int sleepingPlayers, int percent) {
        int atLeast = (int) Math.ceil((double) (percent * totalPlayers) / 100);
        if (config.isShowPercent()) {
            return "§fプレイヤーの§e" + percent + "%§fが寝ています。最低§e" + config.getPercent() + "%§f必要です。";
        } else {
            return "§f§e" + sleepingPlayers + "§f人のプレイヤーが寝ています。最低§e" + atLeast + "§f人必要です。";
        }
    }

    @Override
    public String sleepingServer() {
        return "§a夜をスキップ中...";
    }

    @Override
    public String nightPassed() {
        return "§aおはようございます！";
    }

    @Override
    public String serverStartMessage() {
        return "§9私のプラグインを使用していただきありがとう！\n§7お楽しみください --- raulRT99 (Raul Reyes)";
    }

    @Override
    public String notValidNumber() {
        return "§c有効な数字を入力してください";
    }

    @Override
    public String playerSleeping(String player) {
        return "§fおやすみなさい §6" + player + "§fさん";
    }
}
