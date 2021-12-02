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
  // @LINE:6
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    HomeController_0: controllers.HomeController,
    // @LINE:6
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_0, Assets_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ws""", """controllers.HomeController.socket"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """issue/""" + "$" + """author<[^/]+>/""" + "$" + """repo<[^/]+>""", """controllers.HomeController.issue(author:String, repo:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """repo/""" + "$" + """author<[^/]+>/""" + "$" + """repo<[^/]+>""", """controllers.HomeController.repos(author:String, repo:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """user<[^/]+>""", """controllers.HomeController.userProfile(user:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """username<[^/]+>""", """controllers.HomeController.index(username:String, request:Request)"""),
    ("""POST""", this.prefix, """controllers.HomeController.keyword(request:Request)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] lazy val controllers_HomeController_socket0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ws")))
  )
  private[this] lazy val controllers_HomeController_socket0_invoker = createInvoker(
    HomeController_0.socket,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "socket",
      Nil,
      "GET",
      this.prefix + """ws""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_Assets_at1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at1_invoker = createInvoker(
    Assets_1.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_HomeController_issue2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("issue/"), DynamicPart("author", """[^/]+""",true), StaticPart("/"), DynamicPart("repo", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_issue2_invoker = createInvoker(
    HomeController_0.issue(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "issue",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """issue/""" + "$" + """author<[^/]+>/""" + "$" + """repo<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_HomeController_repos3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("repo/"), DynamicPart("author", """[^/]+""",true), StaticPart("/"), DynamicPart("repo", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_repos3_invoker = createInvoker(
    HomeController_0.repos(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "repos",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """repo/""" + "$" + """author<[^/]+>/""" + "$" + """repo<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_HomeController_userProfile4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("user", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_userProfile4_invoker = createInvoker(
    HomeController_0.userProfile(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "userProfile",
      Seq(classOf[String]),
      "GET",
      this.prefix + """user/""" + "$" + """user<[^/]+>""",
      """GET   /repo/:name                   controllers.HomeController.repos(name : String)""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_HomeController_index5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("username", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_index5_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_0.index(fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Seq(classOf[String], classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """""" + "$" + """username<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_HomeController_keyword6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_keyword6_invoker = createInvoker(
    
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
    case controllers_HomeController_socket0_route(params@_) =>
      call { 
        controllers_HomeController_socket0_invoker.call(HomeController_0.socket)
      }
  
    // @LINE:6
    case controllers_Assets_at1_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at1_invoker.call(Assets_1.at(path, file))
      }
  
    // @LINE:7
    case controllers_HomeController_issue2_route(params@_) =>
      call(params.fromPath[String]("author", None), params.fromPath[String]("repo", None)) { (author, repo) =>
        controllers_HomeController_issue2_invoker.call(HomeController_0.issue(author, repo))
      }
  
    // @LINE:8
    case controllers_HomeController_repos3_route(params@_) =>
      call(params.fromPath[String]("author", None), params.fromPath[String]("repo", None)) { (author, repo) =>
        controllers_HomeController_repos3_invoker.call(HomeController_0.repos(author, repo))
      }
  
    // @LINE:10
    case controllers_HomeController_userProfile4_route(params@_) =>
      call(params.fromPath[String]("user", None)) { (user) =>
        controllers_HomeController_userProfile4_invoker.call(HomeController_0.userProfile(user))
      }
  
    // @LINE:11
    case controllers_HomeController_index5_route(params@_) =>
      call(params.fromPath[String]("username", None)) { (username) =>
        controllers_HomeController_index5_invoker.call(
          req => HomeController_0.index(username, req))
      }
  
    // @LINE:15
    case controllers_HomeController_keyword6_route(params@_) =>
      call { 
        controllers_HomeController_keyword6_invoker.call(
          req => HomeController_0.keyword(req))
      }
  }
}
