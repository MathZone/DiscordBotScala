package org.nanokloon.bot

import net.dv8tion.jda.api.requests.GatewayIntent
import net.dv8tion.jda.api.utils.{ChunkingFilter, MemberCachePolicy}
import net.dv8tion.jda.api.{JDA, JDABuilder}
import ujson.Value.Value


object Main {
  val file: String = os.read(os.pwd/"config"/"config.json")
  var data: Value = ujson.read(file)
    def main(args: Array[String]): Unit = {
      val jdaBuilder: JDABuilder = JDABuilder.createDefault(data("token").str)
      jdaBuilder.setChunkingFilter(ChunkingFilter.ALL)
      jdaBuilder.setMemberCachePolicy(MemberCachePolicy.ALL)
      jdaBuilder.enableIntents(GatewayIntent.GUILD_MEMBERS)
      val jda :JDA = jdaBuilder.build()

      jda.addEventListener(new MessageListener(jda))
      //print(data("token"))
    }
  }

//example class
//class Greet( prefix: String , suffix: String , age: Integer){
//  var p: String = prefix + " "
//
//  def greet(name: String): Unit ={
//
//    println(p+name+" "+ age.toString()+suffix)
//
//  }
//
//}