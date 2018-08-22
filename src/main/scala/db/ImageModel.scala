package db
import com.redis._
import entities.Image

import scala.concurrent.{ExecutionContext, Future}


class ImageModel(implicit val executionContext: ExecutionContext) extends RedisModel {

  //Initiate connection with DB
  val client = new RedisClient("localhost", 6379)

  /***
    * Given a particular Image check if exist and if not exist in DB
    * Add as a new set, if key exist
    * @param image
    * @return
    */
   def set(image: Image): Future[Option[String]] = Future {
     //Extracting from a future using foreach
     get(image.id) match {
       case  Some(i) => None
       case _ => client.set(image.id, image.image)
     }
     Some(image.id)
  }

   def get(id: String): Option[String] =  client.get(id)


  def getEntity(id: String) :Future[Option[Image]] = Future {

//    val result:String = get(id).getOrElse("Not Found")
//      case Some(i) =>  i.map(_.toString)
//      case _ => "Not Found"
   Some(Image(id, get(id).getOrElse("Not Found")))
    }
  }


//for { res <- get(id)}
//yield Some(Image(id, res.getOrElse("Not Found")))
