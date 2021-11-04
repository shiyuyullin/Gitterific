
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.data._
import play.core.j.PlayFormsMagicForJava._
import scala.jdk.CollectionConverters._

object issue extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[List[String],HashMap[String, Integer],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(titles : List[String], wordCount : HashMap[String, Integer]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<html>
<head>
    <title>issues</title>
</head>
<body>
"""),_display_(/*8.2*/for( (k,v) <- wordCount) yield /*8.26*/{_display_(Seq[Any](format.raw/*8.27*/("""

"""),format.raw/*10.1*/("""<p>Word: """),_display_(/*10.11*/k),format.raw/*10.12*/(""", Count: """),_display_(/*10.22*/v),format.raw/*10.23*/("""</p>

""")))}),format.raw/*12.2*/("""
"""),format.raw/*13.1*/("""</body>
</html>"""))
      }
    }
  }

  def render(titles:List[String],wordCount:HashMap[String, Integer]): play.twirl.api.HtmlFormat.Appendable = apply(titles,wordCount)

  def f:((List[String],HashMap[String, Integer]) => play.twirl.api.HtmlFormat.Appendable) = (titles,wordCount) => apply(titles,wordCount)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/issue.scala.html
                  HASH: b21bc07ab0d7243af8bfd5213726643305ed5a1f
                  MATRIX: 938->1|1093->63|1120->64|1201->120|1240->144|1278->145|1307->147|1344->157|1366->158|1403->168|1425->169|1462->176|1490->177
                  LINES: 27->1|32->2|33->3|38->8|38->8|38->8|40->10|40->10|40->10|40->10|40->10|42->12|43->13
                  -- GENERATED --
              */
          