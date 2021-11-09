
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

object issue extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[List[String],HashMap[String, Long],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(titles: List[String], wordCount : HashMap[String,Long]):play.twirl.api.HtmlFormat.Appendable = {
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
                """),_display_(/*30.18*/for((k,v) <- wordCount) yield /*30.41*/{_display_(Seq[Any](format.raw/*30.42*/("""
                    """),format.raw/*31.21*/("""<p>"""),_display_(/*31.25*/k),format.raw/*31.26*/(""" """),_display_(/*31.28*/v),format.raw/*31.29*/("""</p>
                """)))}),format.raw/*32.18*/("""
            """),format.raw/*33.13*/("""</div>
            <div class="column">
                """),_display_(/*35.18*/for(title <- titles) yield /*35.38*/{_display_(Seq[Any](format.raw/*35.39*/("""
                    """),format.raw/*36.21*/("""<p>title: """),_display_(/*36.32*/title),format.raw/*36.37*/("""</p>
                """)))}),format.raw/*37.18*/("""
            """),format.raw/*38.13*/("""</div>
        </div>

    </body>
</html>"""))
      }
    }
  }

  def render(titles:List[String],wordCount:HashMap[String, Long]): play.twirl.api.HtmlFormat.Appendable = apply(titles,wordCount)

  def f:((List[String],HashMap[String, Long]) => play.twirl.api.HtmlFormat.Appendable) = (titles,wordCount) => apply(titles,wordCount)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/issue.scala.html
                  HASH: e843bbe3187173c95ad91ed55bcccfc1200068a0
                  MATRIX: 935->1|1085->58|1112->59|1220->140|1248->141|1292->158|1346->185|1374->186|1415->199|1451->207|1480->208|1525->225|1576->248|1605->249|1646->262|1677->265|1706->266|1751->283|1876->380|1905->381|1946->394|1989->409|2018->410|2063->427|2161->497|2190->498|2226->507|2455->709|2494->732|2533->733|2582->754|2613->758|2635->759|2664->761|2686->762|2739->784|2780->797|2864->854|2900->874|2939->875|2988->896|3026->907|3052->912|3105->934|3146->947
                  LINES: 27->1|32->2|33->3|37->7|37->7|38->8|39->9|39->9|40->10|40->10|40->10|41->11|42->12|42->12|43->13|43->13|43->13|44->14|47->17|47->17|48->18|48->18|48->18|49->19|51->21|51->21|52->22|60->30|60->30|60->30|61->31|61->31|61->31|61->31|61->31|62->32|63->33|65->35|65->35|65->35|66->36|66->36|66->36|67->37|68->38
                  -- GENERATED --
              */
          