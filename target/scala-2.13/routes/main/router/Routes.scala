// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  HomeController_0: controllers.HomeController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    HomeController_0: controllers.HomeController
  ) = this(errorHandler, HomeController_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """issue""", """controllers.HomeController.issue"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """repo/""" + "$" + """name<[^/]+>""", """controllers.HomeController.repos(name:String)"""),
    ("""POST""", this.prefix, """controllers.HomeController.keyword(request:Request)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_HomeController_issue1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("issue")))
  )
  private[this] lazy val controllers_HomeController_issue1_invoker = createInvoker(
    HomeController_0.issue,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "issue",
      Nil,
      "GET",
      this.prefix + """issue""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_HomeController_repos2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("repo/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_repos2_invoker = createInvoker(
    HomeController_0.repos(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "repos",
      Seq(classOf[String]),
      "GET",
      this.prefix + """repo/""" + "$" + """name<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_HomeController_keyword3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_keyword3_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_0.keyword(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "keyword",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """""",
      """""",
      Seq("""nocsrf""")
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:5
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:7
    case controllers_HomeController_issue1_route(params@_) =>
      call { 
        controllers_HomeController_issue1_invoker.call(HomeController_0.issue)
      }
  
    // @LINE:8
    case controllers_HomeController_repos2_route(params@_) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_HomeController_repos2_invoker.call(HomeController_0.repos(name))
      }
  
    // @LINE:11
    case controllers_HomeController_keyword3_route(params@_) =>
      call { 
        controllers_HomeController_keyword3_invoker.call(
          req => HomeController_0.keyword(req))
      }
  }
}
