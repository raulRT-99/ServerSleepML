package org.raul.plugins.serverSleepML.Languages;

import org.raul.plugins.serverSleepML.Functionallity.Config;

public class RussianMessage extends LanguageMessages{
    protected RussianMessage(Config config) {
        super(config);
    }

    @Override
    public String notEnoughPlayers(int totalPlayers, int sleepingPlayers, int percent) {
        return "";
    }

    @Override
    public String sleepingServer() {
        return null;
    }

    @Override
    public String nightPassed() {
        return null;
    }

    @Override
    public String serverStartMessage() {
        return "";
    }

    @Override
    public String notValidNumber() {
        return "";
    }

    @Override
    public String playerSleeping(String player) {
        return null;
    }
}
