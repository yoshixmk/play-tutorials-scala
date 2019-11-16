package controllers

import play.api._
import play.api.mvc._
import play.api.Play.current
import play.api.data._
import play.api.data.format.Formats._
import sys.process._
import form.TryScalaForm
import play.api.data._
import play.api.data.Forms._

object TryScalaController extends Controller {

  def exec = Action {
    val form = Form(
      mapping(
        "command" -> of[String]
      )(TryScalaForm.apply)(TryScalaForm.unapply)
    )

    // Process("ls -la").!!
    val result = Process("sbt \"console print(\"hello\")\"").!!
    Ok(result)
  }
}