package me.fishy246.easychatclear.commands;

import me.fishy246.easychatclear.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Copyright (C) Fishy246 - All Rights Reserved
 * Unauthorized copying of this file or any associated API's, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Fishy246 <contact@fishy246.me>, 25 March 2016, 12:06
 */

public class EasyChatClear implements CommandExecutor {

    private Main plugin;

    public EasyChatClear(Main plugin) {
        this.plugin = plugin;
    }


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        switch (args.length) {
            case 0:
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e[ECC] &6EasyChatClear version &a" + plugin.getDescription().getVersion()));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Author: &aFishy246"));
                return true;
            case 1:
                if (args[0].equalsIgnoreCase("reload")) {
                    Bukkit.getPluginManager().getPlugin("EasyChatClear").reloadConfig();
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.configreload")));
                    return true;
                }
        }
        return false;
    }
}
