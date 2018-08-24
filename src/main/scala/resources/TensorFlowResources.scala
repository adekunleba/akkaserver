package resources

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.{MultipartUnmarshallers, Unmarshaller}
import db.RedisService
import entities.Image
import routing.MyResource


trait TensorFlowResources extends MyResource {
  println("TensorFlowResources being initialized")

  val redisModelService : RedisService

  def imageRoutes: Route = pathPrefix("images") {
    pathEnd {
      post {
        entity(as[Image]) { image =>
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
