package controllers

import play.api._
import play.api.mvc._
import play.api.cache.Cache
import play.api.Play.current
import play.api.data._
import play.api.data.format.Formats._
import sys.process._
import form.TryScalaForm
import play.api.data._
import play.api.data.Forms._

import play.api.db._

object TryScalaController extends Controller {

  def apply(): TryScalaController = new TryScalaController() {
    Process("sbt shell")
  }

  def exec = Action {
    val form = Form(
      mapping(
        "command" -> of[String]
      )(TryScalaForm.apply)(TryScalaForm.unapply)
    )

    Process("ls -la").!!
    val result = Process("print(\"hello\")").!!
    Ok(result)
  }
}
