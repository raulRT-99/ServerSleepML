package org.raul.plugins.serverSleepML.Functionallity;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.raul.plugins.serverSleepML.Languages.LanguageMessages;

public class SleepCommand implements CommandExecutor {

    private final LanguageMessages consoleMessage;
    private  Config config;
    private final JavaPlugin plugin;

    public SleepCommand(LanguageMessages consoleMessage, JavaPlugin plugin, Config config) {
        this.consoleMessage = consoleMessage;
        this.plugin = plugin;
        this.config = config;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(consoleMessage.notValidNumber());
            return true;
        }

        int newPercent;
        try{
            newPercent = Integer.parseInt(args[0]);
        }catch(NumberFormatException e){
            sender.sendMessage(consoleMessage.notValidNumber());
            return false;
        }catch(Exception e){
            plugin.getLogger().severe("§c>>>Error!!: "+e.getMessage());
            return false;
        }

        plugin.getConfig().set("percent",newPercent);
        config.setPercent(newPercent);
        plugin.saveConfig();
        plugin.reloadConfig();
        sender.sendMessage(consoleMessage.newPercent(newPercent));

        return true;
    }


}
