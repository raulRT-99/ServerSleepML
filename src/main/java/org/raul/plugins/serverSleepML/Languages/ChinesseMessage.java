package org.raul.plugins.serverSleepML.Languages;

import org.raul.plugins.serverSleepML.Functionallity.Config;

public class ChinesseMessage extends LanguageMessages {

    public ChinesseMessage(Config config) {
        super(config);
    }

    @Override
    public String notEnoughPlayers(int totalPlayers, int sleepingPlayers, int percent) {
        int atLeast = (int) Math.ceil((double) (config.getPercent() * totalPlayers) / 100);
        if (config.isShowPercent()) {
            return "§f有§e" + percent + "%§f玩家在睡觉。至少需要§e" + config.getPercent() + "%§f。";
        } else {
            return "§f有§e" + sleepingPlayers + "§f个玩家在睡觉。至少需要§e" + atLeast + "个。";
        }
    }

    @Override
    public String sleepingServer() {
        return "§a跳过夜晚中...";
    }

    @Override
    public String nightPassed() {
        return "§a早上好！";
    }

    @Override
    public String serverStartMessage() {
        return "§9感谢使用我的插件！\n§7希望你喜欢 --- raulRT99 (Raul Reyes)";
    }

    @Override
    public String notValidNumber() {
        return "§c请输入有效数字";
    }

    @Override
    public String newPercent(int newPercent) {
        return "睡眠百分比已更改为："+newPercent;
    }

    @Override
    public String playerSleeping(String player) {
        return "§f晚安 §6" + player + "！";
    }
}
