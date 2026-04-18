package org.raul.plugins.serverSleepML;

import org.bukkit.plugin.java.JavaPlugin;
import org.raul.plugins.serverSleepML.Functionallity.Config;
import org.raul.plugins.serverSleepML.Languages.*;

public final class ServerSleepML extends JavaPlugin {

    public static Config config;

    @Override
    public void onEnable() {
        // Plugin startup logic
        try {
            saveDefaultConfig();
            loadConfFile();
        } catch (Exception e) {
            this.getLogger().severe("Error on loading config file, please check you modify it correctly. Reset to default config --- " + e.getMessage());
        }

        LanguageMessages langMsg = selectLanguage(config.getLang());
        this.getLogger().info(langMsg.serverStartMessage());



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void loadConfFile() {
        // Con defaults seguros
        ServerSleepML.config = new Config(getConfig().getString("lang", "en"),
                getConfig().getInt("percent", 50),
                getConfig().getString("show", "percent"));

    }

    private LanguageMessages selectLanguage(String lang) {
        return switch (lang) {
            case "es" -> new SpanishMessage(config);
            case "en" -> new EnglishMessage(config);
            case "fr" -> new FrenchMessage(config);
            case "gr" -> new GermanMessage(config);
            case "ch" -> new ChinesseMessage(config);
            case "jp" -> new JapaneseLanguage(config);
            case "ru" -> new RussianMessage(config);
            case "pt" -> new PortugueseMessage(config);
            default -> new EnglishMessage(config);
        };
    }
}
