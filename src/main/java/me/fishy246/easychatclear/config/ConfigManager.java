package me.fishy246.easychatclear.config;

import me.fishy246.easychatclear.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.io.File;

public class ConfigManager {

    private Main plugin;

    public ConfigManager(Main plugin) {
        this.plugin = plugin;
    }

    public void setupConfig() {
        File config = new File(plugin.getDataFolder(), "config.yml");
        if (!config.exists()) {
            plugin.saveDefaultConfig();
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "[EasyChatClear] " + ChatColor.RED + "config file not found, generating default configuration file");
            return;
        }
    }
}