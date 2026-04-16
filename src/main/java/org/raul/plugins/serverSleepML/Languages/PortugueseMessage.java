package org.raul.plugins.serverSleepML.Languages;

import org.raul.plugins.serverSleepML.Functionallity.Config;

public class PortugueseMessage extends LanguageMessages{
    protected PortugueseMessage(Config config) {
        super(config);
    }

    @Override
    public String notEnoughPlayers(int totalPlayers, int sleepingPlayers) {
        return null;
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
    public String playerSleeping(String player) {
        return null;
    }
}
