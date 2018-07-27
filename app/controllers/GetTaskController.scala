package controllers


import javax.inject._
import models.Task
import play.api.i18n.I18nSupport
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}

@Singleton
class GetTaskController @Inject()(components: ControllerComponents)
  extends AbstractController(components) with I18nSupport {

  def index(id: Long): Action[AnyContent] = Action { implicit request =>
      val task = Task.findById(id).get
      Ok(views.html.show(task))
  }

}
