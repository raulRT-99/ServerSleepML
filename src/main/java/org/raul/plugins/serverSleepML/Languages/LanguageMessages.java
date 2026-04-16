package org.raul.plugins.serverSleepML.Languages;

import org.raul.plugins.serverSleepML.Functionallity.Config;

public abstract class LanguageMessages {
    protected final Config config;

    protected LanguageMessages(Config config) {
        this.config = config;
    }

    public abstract String notEnoughPlayers(int totalPlayers, int sleepingPlayers);
    public abstract String sleepingServer();
    public abstract String playerSleeping(String player);
    public abstract String nightPassed();

}
