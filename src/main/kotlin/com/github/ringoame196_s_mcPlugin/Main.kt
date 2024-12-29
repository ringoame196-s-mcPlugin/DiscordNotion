package com.github.ringoame196_s_mcPlugin

import com.github.ringoame196_s_mcPlugin.events.Events
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    private val plugin = this
    private val discordWebHookManager = DiscordWebHookManager()

    override fun onEnable() {
        super.onEnable()
        server.pluginManager.registerEvents(Events(), plugin)
        saveDefaultConfig()
        Data.webHookURL = plugin.config.getString("webhookURL")

        discordWebHookManager.sendDiscordWebhook(":blue_circle: サーバー起動しました", "サーバー", "https://p1.hiclipart.com/preview/896/990/447/minecraft-hd-icon-mac-pc-minecraft-icon-512-png-icon.jpg")
    }

    override fun onDisable() {
        super.onDisable()
        discordWebHookManager.sendDiscordWebhook(":red_circle: サーバー起動しました", "サーバー", "https://p1.hiclipart.com/preview/896/990/447/minecraft-hd-icon-mac-pc-minecraft-icon-512-png-icon.jpg")
    }
}
