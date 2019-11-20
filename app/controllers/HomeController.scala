package controllers

import javax.inject._

import play.api.mvc._
import play.api._
import play.api.data._
import play.api.data.format.Formats._
import sys.process._
import play.api.data._
import play.api.data.Forms._
import form.TryScalaForm

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents)(implicit assetsFinder: AssetsFinder)
  extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def exec = Action {
    val form = Form(
      mapping(
        "command" -> text
      )(TryScalaForm.apply)(TryScalaForm.unapply)
    )
    val data = form.bindFromRequest.fold(
      formWithErrors => {
        BadRequest("bad request")
      },
      data => {
        val result = Process(data.command).!!
        Ok(result)
      }
    )
  }

  def startConsole = Action {
    val result = Process("sbt run </dev/null >> console.log &").!!
    Ok("console start")
  }

  def getConsole =  Action {
    val result = Process("cat console.log").!!
    Ok(result)
  }

  def clearLog = Action {
    val result = Process("echo '' > console.log &").!!
    Ok("clear console log")
  }
}
