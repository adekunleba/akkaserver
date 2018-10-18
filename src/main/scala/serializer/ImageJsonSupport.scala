package serializer

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol
import entities.SimpleObject



trait ImageJsonSupport extends DefaultJsonProtocol with SprayJsonSupport {
  implicit val PortoFolioFormats = jsonFormat2(SimpleObject)
}
object ImageJsonSupport extends ImageJsonSupport