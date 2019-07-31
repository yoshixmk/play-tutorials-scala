package controllers

object WidgetForm {
  import play.api.data.Forms._
  import play.api.data.Form

  case class Data(name: String, price: Int)

  val form = Form(
    mapping(
      "name" -> nonEmptyText,
      "price" -> number(min = 0)
    )(Data.apply)(Data.unapply)
  )
}