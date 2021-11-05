
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<html>

    <head>
        <title>Search</title>
        <style>
            .welcomeHeader """),format.raw/*7.28*/("""{"""),format.raw/*7.29*/("""
                """),format.raw/*8.17*/("""background-color: #92d13d;
                height: 150px;
            """),format.raw/*10.13*/("""}"""),format.raw/*10.14*/("""
            """),format.raw/*11.13*/("""h1 """),format.raw/*11.16*/("""{"""),format.raw/*11.17*/("""
                """),format.raw/*12.17*/("""color: white;
                padding-top: 55px;
                padding-left: 55px;
            """),format.raw/*15.13*/("""}"""),format.raw/*15.14*/("""
            """),format.raw/*16.13*/("""form """),format.raw/*16.18*/("""{"""),format.raw/*16.19*/("""
                """),format.raw/*17.17*/("""padding-top: 300px;
                padding-left: 30%;
            """),format.raw/*19.13*/("""}"""),format.raw/*19.14*/("""
            """),format.raw/*20.13*/("""input"""),format.raw/*20.18*/("""{"""),format.raw/*20.19*/("""
                """),format.raw/*21.17*/("""height: 45px;
                width: 600px;
            """),format.raw/*23.13*/("""}"""),format.raw/*23.14*/("""
        """),format.raw/*24.9*/("""</style>
    </head>

    <body>
        <div class="welcomeHeader">
            <h1>Welcome to Gitterific</h1>
        </div>

        <div>
            <form action="/keyword" method="post">
                <input type="text" placeholder="Search..">
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
                  HASH: 6240db58011266aaf2e7e9855b2df60e2ff17e22
                  MATRIX: 989->1|1108->93|1136->94|1180->111|1278->181|1307->182|1348->195|1379->198|1408->199|1453->216|1578->313|1607->314|1648->327|1681->332|1710->333|1755->350|1850->417|1879->418|1920->431|1953->436|1982->437|2027->454|2111->510|2140->511|2176->520
                  LINES: 32->2|37->7|37->7|38->8|40->10|40->10|41->11|41->11|41->11|42->12|45->15|45->15|46->16|46->16|46->16|47->17|49->19|49->19|50->20|50->20|50->20|51->21|53->23|53->23|54->24
                  -- GENERATED --
              */
          