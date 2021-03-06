package controllers

import forms.TaskForm
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.AbstractController


trait TaskControllerSupport { this: AbstractController =>

  protected val form = Form(
    mapping(
      "id"    ->    optional(longNumber),
      "content"    ->  nonEmptyText,
      "status" -> nonEmptyText
    )(TaskForm.apply)(TaskForm.unapply)
  )

}
