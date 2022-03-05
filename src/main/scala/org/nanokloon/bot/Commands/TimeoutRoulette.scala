package org.nanokloon.bot.Commands

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.entities.Guild

object TimeoutRoulette {
  def roulette(bot:JDA,server:Guild): Unit ={
    println(server.getMembers.toArray.mkString("Array(", ", ", ")"))

  }
}
