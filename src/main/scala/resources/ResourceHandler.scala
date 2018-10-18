package resources

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.{MultipartUnmarshallers, Unmarshaller}
import db.RedisService
import entities.SimpleObject
import routing.MyResource


trait ResourceHandler extends MyResource {
  println("ResourceHandler being initialized")

  val redisModelService : RedisService

  def someRoutes: Route = pathPrefix("sampleroute") {
    pathEnd {
      post {
        entity(as[SimpleObject]) { image =>
          completeWithLocationHeader(
            resourceId = redisModelService.set(image),
            ifDefinedStatus = 201, ifEmptyStatus = 409
          )
        }
       }
      } ~
      path(Segment) { id =>
        println(id)
        get {
          complete(redisModelService.getEntity(id))
        }
      }
    }
  }
