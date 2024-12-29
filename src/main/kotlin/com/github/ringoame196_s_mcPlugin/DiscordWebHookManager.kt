package com.github.ringoame196_s_mcPlugin

import org.bukkit.Bukkit
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.URL

class DiscordWebHookManager {
    fun sendDiscordWebhook(content: String, username: String, avatarUrl: String) {
        val url = Data.webHookURL ?: return

        try {
            // WebhookのURLを設定
            val webhookUrl = URL(url)
            val connection = webhookUrl.openConnection() as HttpURLConnection

            // POSTリクエストの設定
            connection.requestMethod = "POST"
            connection.setRequestProperty("Content-Type", "application/json")
            connection.doOutput = true

            // JSONデータを作成
            val json = """
        {
            "content": "${content.replace("\"", "\\\"")}",
            "username": "${username.replace("\"", "\\\"")}",
            "avatar_url": "${avatarUrl.replace("\"", "\\\"")}"
        }
            """.trimIndent()

            // データを送信
            connection.outputStream.use { os: OutputStream ->
                os.write(json.toByteArray(Charsets.UTF_8))
            }

            // レスポンスを確認
            val responseCode = connection.responseCode
        } catch (e: Exception) {
            Bukkit.getLogger().warning("Webhook送信中にエラーが発生しました: ${e.message}")
        }
    }
}
