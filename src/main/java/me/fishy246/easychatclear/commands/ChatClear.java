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
 * Written by Fishy246 <contact@fishy246.me>, 23 March 2016, 21:12
 */

public class ChatClear implements CommandExecutor {

    private Main plugin;

    public ChatClear(Main plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        int clearlines = plugin.getConfig().getInt("linestoclear.global");

        if (!sender.hasPermission(plugin.getConfig().getString("permissions.clearchat"))) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.nopermission")));
            return true;
        }
        switch (args.length) {
            default:
                for (int i = 0; i < clearlines; i++) {
                    Bukkit.broadcastMessage("");
                }
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.globalclearmessage").replaceAll("%p", sender.getName())));
                return true;
        }
    }
}
