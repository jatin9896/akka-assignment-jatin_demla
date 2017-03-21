import akka.actor.{Props, Actor}

/**
  * Created by knoldus on 20/3/17.
  */
class SeatList extends Actor{
  override def receive = {
    case msg:String =>
//      context.actorOf(Props[BookSeat]).forward(msg)
      context.actorSelection("../Seat").forward(msg)
     // println("msg fwd : "+msg)
  }

}
