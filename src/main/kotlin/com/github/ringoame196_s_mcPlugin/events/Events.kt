package com.github.ringoame196_s_mcPlugin.events

import com.github.ringoame196_s_mcPlugin.DiscordWebHookManager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class Events : Listener {
    private val discordWebHookManager = DiscordWebHookManager()
    private val iconAPIURL = "https://api.mineatar.io/face/@uuid?scale=32"

    @EventHandler
    fun onPlayerJoin(e: PlayerJoinEvent) {
        val player = e.player
        val name = player.displayName
        val uuid = player.uniqueId.toString()
        val iconURL = iconAPIURL.replace("@uuid", uuid)
        discordWebHookManager.sendDiscordWebhook(":computer: 参加しました", name, iconURL)
    }

    @EventHandler
    fun onPlayerQuit(e: PlayerQuitEvent) {
        val player = e.player
        val name = player.name
        val uuid = player.uniqueId.toString()
        val iconURL = iconAPIURL.replace("@uuid", uuid)
        discordWebHookManager.sendDiscordWebhook(":wave: 抜けました", name, iconURL)
    }
}
