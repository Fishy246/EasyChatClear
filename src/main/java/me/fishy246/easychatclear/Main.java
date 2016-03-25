package me.fishy246.easychatclear;

import me.fishy246.easychatclear.commands.ChatClear;
import me.fishy246.easychatclear.commands.ClearPlayerchat;
import me.fishy246.easychatclear.commands.EasyChatClear;
import me.fishy246.easychatclear.config.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Copyright (C) Fishy246 - All Rights Reserved
 * Unauthorized copying of this file or any associated API's, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Fishy246 <contact@fishy246.me>, 23 March 2016, 18:36
 */

public class Main extends JavaPlugin {

    private ConfigManager config = new ConfigManager(this);

    @Override
    public void onEnable() {
        registerCommands();
        config.setupConfig();
    }

    @Override
    public void onDisable() {
        saveConfig();
    }

    private void registerCommands() {
        getCommand("chatclear").setExecutor(new ChatClear(this));
        getCommand("individualchatclear").setExecutor(new ClearPlayerchat(this));
        getCommand("easychatclear").setExecutor(new EasyChatClear(this));
    }

}
