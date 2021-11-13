// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def repos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.repos",
      """
        function(author0,repo1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "repo/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("author", author0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("repo", repo1))})
        }
      """
    )
  
    // @LINE:9
    def userProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.userProfile",
      """
        function(user0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("user", user0))})
        }
      """
    )
  
    // @LINE:6
    def issue: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.issue",
      """
        function(author0,repo1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "issue/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("author", author0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("repo", repo1))})
        }
      """
    )
  
    // @LINE:10
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function(username0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("username", username0))})
        }
      """
    )
  
    // @LINE:14
    def keyword: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.keyword",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + """"})
        }
      """
    )
  
  }


}
