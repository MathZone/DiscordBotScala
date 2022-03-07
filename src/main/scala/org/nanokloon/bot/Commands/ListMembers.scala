package org.nanokloon.bot.Commands

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.{Guild, Member, Message}

import java.awt.Color
import scala.jdk.CollectionConverters._


object ListMembers {
  def listMembers(message:Message, server:Guild): Unit ={

    val members : List[Member]  = server.getMembers.asScala.toList

    val embed:EmbedBuilder = new EmbedBuilder()
    embed.setTitle("Server Members")
    embed.setColor(Color.GREEN)
    //embed.addField("test","test",true)
    var names : String = ""
    //members.foreach(x => println(x.getEffectiveName))
    members.foreach(x => names+= (x.getEffectiveName + "\n"))
    embed.addField("Member count: "+ server.getMemberCount.toString ,names,true)

    message.getChannel.sendMessageEmbeds(embed.build()).queue()
  }
}
