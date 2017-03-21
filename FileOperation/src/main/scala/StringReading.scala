import akka.actor.Actor

/**
  * Created by knoldus on 20/3/17.
  */
class StringReading extends Actor{
  override def receive = {
    case msg: String =>
      sender() ! msg.length
      println(msg.length)

  }

}
