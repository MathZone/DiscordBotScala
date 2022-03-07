package org.nanokloon.bot.Commands

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.entities.{Guild, Member, Message}
import net.dv8tion.jda.api.exceptions.HierarchyException

import java.awt.event.HierarchyEvent
import java.util.concurrent.TimeUnit
import scala.collection.mutable.ListBuffer

object TimeoutRoulette {
  def roulette(server: Guild, message: Message): Unit = {
    val memberCount: Int = server.getMemberCount
    val r = scala.util.Random
    val timeoutList: ListBuffer[Member] = ListBuffer()

    for (i <- 1 to memberCount) {
       timeoutList += server.getMembers.get(r.nextInt(memberCount ))
  }

    val loser: Member = timeoutList(r.nextInt(memberCount))

    try {
      loser.timeoutFor(100L, TimeUnit.SECONDS).queue()
    } catch {
      case _: HierarchyException => message.reply("You fucked up perms / code idiot!")
    }
    message.reply("<@"+loser.getId + ">" + " got timed out LOL").queue()

  }
}
