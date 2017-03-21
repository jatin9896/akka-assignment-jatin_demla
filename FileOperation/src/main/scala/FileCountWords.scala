import akka.actor.{Props, ActorSystem}
import akka.util.Timeout
import scala.concurrent.duration._
import akka.pattern.ask

/**
  * Created by knoldus on 20/3/17.
  */
object FileCountWords extends App{

  implicit val timeout = Timeout(1000 seconds)
  import scala.concurrent.ExecutionContext.Implicits.global
  val system = ActorSystem("FileCount")
  val fileReadingProps = Props[FileReadingActor];
  val fileReadingRef = system.actorOf(fileReadingProps,"File")
  fileReadingRef ? "/home/knoldus/Desktop/data.txt"

}
