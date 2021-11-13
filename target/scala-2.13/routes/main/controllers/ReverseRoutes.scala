// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def repos(author:String, repo:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "repo/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("author", author)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("repo", repo)))
    }
  
    // @LINE:9
    def userProfile(user:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("user", user)))
    }
  
    // @LINE:6
    def issue(author:String, repo:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "issue/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("author", author)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("repo", repo)))
    }
  
    // @LINE:10
    def index(username:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("username", username)))
    }
  
    // @LINE:14
    def keyword(): Call = {
      
      Call("POST", _prefix)
    }
  
  }


}
