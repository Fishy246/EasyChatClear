package me.fishy246.easychatclear.commands;

import me.fishy246.easychatclear.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Copyright (C) Fishy246 - All Rights Reserved
 * Unauthorized copying of this file or any associated API's, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Fishy246 <contact@fishy246.me>, 24 March 2016, 15:35
 */

public class ClearPlayerchat implements CommandExecutor {

    private Main plugin;

    public ClearPlayerchat(Main plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        int clearlines = plugin.getConfig().getInt("linestoclear.otherplayer");
        int personalclearlines = plugin.getConfig().getInt("linestoclear.personal");

        switch (args.length) {
            case 0:
                if (!sender.hasPermission(plugin.getConfig().getString("permissions.clearownchat"))) {
                    sender.sendMessage(plugin.getConfig().getString("messages.nopermission"));
                }
                for (int i = 0; i < personalclearlines; i++) {
                    sender.sendMessage("");
                }
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.ownchatclear")));
                return true;
            case 1:
                if (!sender.hasPermission(plugin.getConfig().getString("permissions.clearplayerchat"))) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.nopermission")));
                    return true;
                }
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.offlineplayer").replaceAll("%t", args[0])));
                    break;
                }
                for (int i = 0; i < clearlines; i++) {
                    target.sendMessage("");
                }
                target.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.individualclearmessage").replaceAll("%p", sender.getName())));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.individualsendermessage").replaceAll("%t", args[0])));
                return true;
            default:
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.incorrectusage")));
                return true;
        }
        return false;
    }
}

