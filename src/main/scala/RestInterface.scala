import scala.concurrent.ExecutionContext
import akka.http.scaladsl.server.Route
import db.RedisService
import exceptionhandler.MyImplicitExceptionHandler
import resources.TensorFlowResources

trait RestInterface extends Resources with MyImplicitExceptionHandler{

  implicit def executionContext: ExecutionContext

  lazy val redisModelService = new RedisService
  val routes: Route =  imageRoutes
}

trait Resources extends TensorFlowResources
