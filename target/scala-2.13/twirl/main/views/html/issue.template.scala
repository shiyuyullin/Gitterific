
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
        <style>
            .row """),format.raw/*7.18*/("""{"""),format.raw/*7.19*/("""
                """),format.raw/*8.17*/("""display: flex;
            """),format.raw/*9.13*/("""}"""),format.raw/*9.14*/("""
            """),format.raw/*10.13*/(""".column """),format.raw/*10.21*/("""{"""),format.raw/*10.22*/("""
                """),format.raw/*11.17*/("""flex: 50%;
            """),format.raw/*12.13*/("""}"""),format.raw/*12.14*/("""
            """),format.raw/*13.13*/("""h1 """),format.raw/*13.16*/("""{"""),format.raw/*13.17*/("""
                """),format.raw/*14.17*/("""color: white;
                padding-top: 55px;
                padding-left: 55px;
            """),format.raw/*17.13*/("""}"""),format.raw/*17.14*/("""
            """),format.raw/*18.13*/(""".welcomeHeader """),format.raw/*18.28*/("""{"""),format.raw/*18.29*/("""
                """),format.raw/*19.17*/("""background-color: #92d13d;
                height: 150px;
            """),format.raw/*21.13*/("""}"""),format.raw/*21.14*/("""
        """),format.raw/*22.9*/("""</style>
    </head>
    <body>
        <div class="welcomeHeader">
            <h1>Word-level Statistics</h1>
        </div>
        <div class="row">
            <div class="column">
                """),_display_(/*30.18*/for( (k,v) <- wordCount) yield /*30.42*/{_display_(Seq[Any](format.raw/*30.43*/("""

                """),format.raw/*32.17*/("""<p>Word: """),_display_(/*32.27*/k),format.raw/*32.28*/(""", Count: """),_display_(/*32.38*/v),format.raw/*32.39*/("""</p>

                """)))}),format.raw/*34.18*/("""
            """),format.raw/*35.13*/("""</div>
            <div class="column">
                """),_display_(/*37.18*/for(title <- titles) yield /*37.38*/{_display_(Seq[Any](format.raw/*37.39*/("""
                    """),format.raw/*38.21*/("""<p>title : """),_display_(/*38.33*/title),format.raw/*38.38*/("""</p>
                """)))}),format.raw/*39.18*/("""
            """),format.raw/*40.13*/("""</div>
        </div>

    </body>
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
                  HASH: 56de8038077f49edaf79faec3ab24bc6c282d710
                  MATRIX: 938->1|1093->63|1120->64|1228->145|1256->146|1300->163|1354->190|1382->191|1423->204|1459->212|1488->213|1533->230|1584->253|1613->254|1654->267|1685->270|1714->271|1759->288|1884->385|1913->386|1954->399|1997->414|2026->415|2071->432|2169->502|2198->503|2234->512|2463->714|2503->738|2542->739|2588->757|2625->767|2647->768|2684->778|2706->779|2760->802|2801->815|2885->872|2921->892|2960->893|3009->914|3048->926|3074->931|3127->953|3168->966
                  LINES: 27->1|32->2|33->3|37->7|37->7|38->8|39->9|39->9|40->10|40->10|40->10|41->11|42->12|42->12|43->13|43->13|43->13|44->14|47->17|47->17|48->18|48->18|48->18|49->19|51->21|51->21|52->22|60->30|60->30|60->30|62->32|62->32|62->32|62->32|62->32|64->34|65->35|67->37|67->37|67->37|68->38|68->38|68->38|69->39|70->40
                  -- GENERATED --
              */
          