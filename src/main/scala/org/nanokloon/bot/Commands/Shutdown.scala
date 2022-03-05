package org.nanokloon.bot.Commands

import net.dv8tion.jda.api.JDA

object Shutdown {
 def shutdown(jda:JDA): Unit ={
    println("Shutting Down...")
    jda.awaitReady().shutdownNow()
    System.exit(0)
  }

}
