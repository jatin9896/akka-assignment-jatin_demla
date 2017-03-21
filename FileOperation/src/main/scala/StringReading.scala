import akka.actor.Actor

class StringReading extends Actor{
  override def receive = {
    case msg: String =>
      sender() ! msg.length
      println(msg.length)
  }

}
