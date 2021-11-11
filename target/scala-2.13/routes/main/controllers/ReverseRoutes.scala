// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:5
package controllers {

  // @LINE:5
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def index: Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:7
    def issue: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "issue")
    }
  
    // @LINE:8
    def repos(name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "repo/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)))
    }
  
    // @LINE:11
    def keyword(): Call = {
      
      Call("POST", _prefix)
    }
  
  }


}
