
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
/*1.2*/import helper._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""<html>

    <head>
        <title>Search</title>
        <style>
            .welcomeHeader """),format.raw/*8.28*/("""{"""),format.raw/*8.29*/("""
                """),format.raw/*9.17*/("""background-color: #92d13d;
                height: 150px;
            """),format.raw/*11.13*/("""}"""),format.raw/*11.14*/("""
            """),format.raw/*12.13*/("""h1 """),format.raw/*12.16*/("""{"""),format.raw/*12.17*/("""
                """),format.raw/*13.17*/("""color: white;
                padding-top: 55px;
                padding-left: 55px;
            """),format.raw/*16.13*/("""}"""),format.raw/*16.14*/("""
            """),format.raw/*17.13*/("""form """),format.raw/*17.18*/("""{"""),format.raw/*17.19*/("""
                """),format.raw/*18.17*/("""padding-top: 300px;
                padding-left: 30%;
            """),format.raw/*20.13*/("""}"""),format.raw/*20.14*/("""
            """),format.raw/*21.13*/("""input"""),format.raw/*21.18*/("""{"""),format.raw/*21.19*/("""
                """),format.raw/*22.17*/("""height: 45px;
                width: 600px;
            """),format.raw/*24.13*/("""}"""),format.raw/*24.14*/("""
        """),format.raw/*25.9*/("""</style>
    </head>

    <body>
        <div class="welcomeHeader">
            <h1>Welcome to Gitterific</h1>
        </div>

        <div>
            <form action="/keyword" method="post">
                <input type="text" placeholder="Search.." name="keywords">
                <button type="submit" style="height:45px; width: 50px">search</button>
            </form>
        </div>

    </body>


</html>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: 6222eac54d805298537c297258591a04ceb1de83
                  MATRIX: 610->1|1012->18|1131->110|1159->111|1203->128|1301->198|1330->199|1371->212|1402->215|1431->216|1476->233|1601->330|1630->331|1671->344|1704->349|1733->350|1778->367|1873->434|1902->435|1943->448|1976->453|2005->454|2050->471|2134->527|2163->528|2199->537
                  LINES: 23->1|33->3|38->8|38->8|39->9|41->11|41->11|42->12|42->12|42->12|43->13|46->16|46->16|47->17|47->17|47->17|48->18|50->20|50->20|51->21|51->21|51->21|52->22|54->24|54->24|55->25
                  -- GENERATED --
              */
          