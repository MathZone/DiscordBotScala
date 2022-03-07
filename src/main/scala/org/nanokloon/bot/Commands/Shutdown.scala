package org.nanokloon.bot.Commands

import net.dv8tion.jda.api.{JDA, Permission, entities}
import net.dv8tion.jda.api.entities.{Member, Message}
import net.dv8tion.jda.internal.utils.PermissionUtil
object Shutdown {
 def shutdown(jda:JDA , message: Message): Unit ={
   if(PermissionUtil.checkPermission(message.getGuild.getMemberById(message.getAuthor.getId), Permission.ADMINISTRATOR)) {
     println("Shutting Down...")
     message.reply("Shutting Down...").queue()
     jda.awaitReady().shutdownNow()
     System.exit(0)
   }else{
      message.reply("You don't have the Administrator permission!")
   }
  }
}
