import com.redis._

val value = Some("Data")
value.getOrElse("No Value")

val r = new RedisClient("localhost", 6379)

r.set("key", "some value")

var str_val = List[String]()
r.get("key") match {
  case Some(i) => str_val ::= i
  case _ => None
}
println(str_val)
//val check = Some(None.toString)
//check match {
//  case Some(None) => println(s"Value present $p")
//  case _ => println("None is present")
//}
//
//
//
//
//
//val client = new RedisClientPool("localhost", 6373)
//def lp(msgs: List[String]) = {
//  client.withClient {
//    client => {
//      msgs.foreach(client.lpush("list-l", _))
//      client.llen("list-l")
//    }
//  }
//}
//
//
//def rp(msg: List[String]) = {
//  client.withClient {
//    client => {
//      msg.foreach(client.rpush("list-r", _))
//      client.llen("llen-r")
//    }
//  }
//}
//
//def set(msg: List[String]) :Option[Long] = {
//  client.withClient {
//    client => {
//      var i = 0
//      msg.foreach {
//        v =>
//          client.set("key-%d".format(i), v)
//          i += 1
//      }
//      Some(1000)
//    }
//  }
//}
//
////Trying out
//val l = (0 until 5000).map(_.toString).toList
//val fns = List[List[String] => Option[Long]](lp, rp, set)
//r.set("longnumber", l)
//
//
//
////You can store multiple data to a key with lpush and rpush
//r.lpush("list-1", "foo")
//r.rpush("list-1", "bar")
//
//val firstEntry = r.lindex("list-1", 0)
//
////How to extract values from Some Scala
//firstEntry match {
//  case Some(b) => println(b)
//  case _ => None
//}
//
