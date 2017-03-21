import akka.actor.{Props, ActorSystem}
import akka.util.Timeout
import scala.concurrent.duration._
import akka.pattern.ask


object BookMyShow extends App{
  implicit val timeout = Timeout(1000 seconds)
  import scala.concurrent.ExecutionContext.Implicits.global

  val system = ActorSystem("SeatList")
  val bookSeatProps = Props[BookSeat];
  val bookSeatRef = system.actorOf(bookSeatProps,"Seat")
  val seatListProps = Props[SeatList];
  val seatListRef=system.actorOf(seatListProps)
//  val ref=system.actorSelection("../Seat")
   val seat1 = seatListRef ? "A1"
  seat1.foreach(println _)
  val ref1 = system.actorOf(seatListProps)
 // val ref1=system.actorSelection("../Seat")
  val seat2= ref1 ? "A1"
  seat2.foreach(println _)
  system.terminate()
}
