package org.nanokloon.bot.Commands

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.entities.Message

object Shutdown {
 def shutdown(jda:JDA , message: Message): Unit ={
    println("Shutting Down...")
    message.reply("Shutting Down...").queue()
    jda.awaitReady().shutdownNow()
    System.exit(0)
  }

}
