package org.nanokloon.bot

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.entities.{Guild, Message}
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.nanokloon.bot.Commands.Shutdown.shutdown
import org.nanokloon.bot.Commands.TimeoutRoulette.roulette

class MessageListener(bot: JDA) extends ListenerAdapter {
  override def onMessageReceived(event: MessageReceivedEvent): Unit = {
    val message: Message = event.getMessage
    if(!message.getAuthor.isBot) {
      message.getContentRaw.toLowerCase() match {
        case "bot!shutdown" => shutdown(bot)
        case "bot!dumptoken" => message.reply("You tried lol").queue()
        case "bot!roulette" => roulette(bot, message.getGuild : Guild )
      }


    }
  }


}
