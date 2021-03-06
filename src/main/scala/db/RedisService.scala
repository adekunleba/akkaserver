package db
import com.redis._
import entities.SimpleObject

import scala.concurrent.{ExecutionContext, Future}


class RedisService(implicit val executionContext: ExecutionContext) extends RedisModel {

  //Initiate connection with DB
  val client = new RedisClient("localhost", 6379)

  /***
    * Given a particular SimpleObject check if exist and if not exist in DB
    * Add as a new set, if key exist
    * @param image
    * @return
    */
   def set(image: SimpleObject): Future[Option[String]] = Future {
     //Extracting from a future using foreach
     get(image.id) match {
       case  Some(i) => None
       case _ => client.set(image.id, image.value)
     }
     Some(image.id)
  }

   def get(id: String): Option[String] =  client.get(id)

  /***
    * Helper function to get data from Redis Database
    * @param id
    * @return
    */
  def getEntity(id: String) :Future[Option[SimpleObject]] = Future {
   Some(SimpleObject(id, get(id).getOrElse("Not Found")))
    }
  }


//for { res <- get(id)}
//yield Some(SimpleObject(id, res.getOrElse("Not Found")))
