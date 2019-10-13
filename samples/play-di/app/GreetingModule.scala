import controllers.GreeterController
import play.api.i18n.Langs
import play.api.mvc.ControllerComponents
import services.GreetingService

/**
  * wire with Controller and Service
  */
trait GreetingModule {

  import com.softwaremill.macwire._

  lazy val greeterController = wire[GreeterController] //
  lazy val greetingService = wire[GreetingService] //

  def langs: Langs

  def controllerComponents: ControllerComponents
}
