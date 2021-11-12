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

  
    // @LINE:8
    def repos(name:String): Call = {
    
      (name: @unchecked) match {
      
        // @LINE:8
        case (name)  =>
          
          Call("GET", _prefix + { _defaultPrefix } + "repo/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)))
      
      }
    
    }
  
    // @LINE:10
    def userProfile(user:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("user", user)))
    }
  
    // @LINE:7
    def issue(author:String, repo:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "issue/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("author", author)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("repo", repo)))
    }
  
    // @LINE:14
    def keyword(): Call = {
      
      Call("POST", _prefix)
    }
  
    // @LINE:5
    def index: Call = {
      
      Call("GET", _prefix)
    }
  
  }


}
