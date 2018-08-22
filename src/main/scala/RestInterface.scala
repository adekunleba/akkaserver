import scala.concurrent.ExecutionContext
import akka.http.scaladsl.server.Route
import db.RedisService
import exceptionhandler.MyImplicitExceptionHandler
import resources.TensorFlowResources
import service.ImageService

trait RestInterface extends Resources with MyImplicitExceptionHandler{
  println("RestInterface being initialized")
  // This doesn't have definition, so until Main hits the below line
  // > implicit val executionContext = system.dispatcher
  // this is left null
  implicit def executionContext: ExecutionContext

  //This is where declared imageService from TensorFlowResource is now being initialized.
  lazy val imageService = new ImageService
  lazy val redisModelService = new RedisService
  val routes: Route =  imageRoutes
}

trait Resources extends TensorFlowResources
