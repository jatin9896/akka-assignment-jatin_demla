import akka.actor.Actor


class BookSeat extends Actor{
  var seatList=List(Seat("A1"),Seat("A2"),Seat("A3"),Seat("A4"))
  override def receive = {
    case msg:String =>
      if(seatList.contains(Seat(msg))){
        seatList=seatList.diff(List(Seat(msg)))
        sender() ! s"Seat Confirmed : $msg Seats now Avalaible : $seatList"
      }
      else
        sender() !  s"No such seat in list List of Available Seat : $seatList"

    case _=>
      sender() ! s"No such seat in list List of Available Seat : $seatList"
  }

}
