import java.io.{File, FileNotFoundException, IOException, PrintWriter}
import java.nio.file.{Files,Paths}
import akka.util.Timeout

import scala.io.Source
import akka.pattern.ask
import scala.concurrent.duration._

import akka.actor.{Props, Actor}

class FileReadingActor extends Actor{
  var count=0
  override def receive = {
    case msg: String =>
      implicit val timeout = Timeout(1000 seconds)
      import scala.concurrent.ExecutionContext.Implicits.global

      val test=msg
      if(Files.exists(Paths.get(test))){
        val str=Source.fromFile(test).mkString
        println(str)
        val output=context.actorOf(Props[StringReading]) ? str
        output.map(x=> count=count+x.toString.toInt)
        output.foreach(x=> println("output :"+ x))
        println("line count"+count)
      }
      else
      {
        println("No such File or directory")
      }
      context.actorOf(Props[StringReading]).forward(msg)
  }
}
