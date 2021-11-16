
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
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Mukta&display=swap" rel="stylesheet">
        <style>
            body """),format.raw/*10.18*/("""{"""),format.raw/*10.19*/("""
                """),format.raw/*11.17*/("""font-family: 'Mukta', sans-serif;
            """),format.raw/*12.13*/("""}"""),format.raw/*12.14*/("""
            """),format.raw/*13.13*/(""".row """),format.raw/*13.18*/("""{"""),format.raw/*13.19*/("""
                """),format.raw/*14.17*/("""display: flex;
            """),format.raw/*15.13*/("""}"""),format.raw/*15.14*/("""
            """),format.raw/*16.13*/(""".column """),format.raw/*16.21*/("""{"""),format.raw/*16.22*/("""
                """),format.raw/*17.17*/("""flex: 50%;
            """),format.raw/*18.13*/("""}"""),format.raw/*18.14*/("""
            """),format.raw/*19.13*/("""h1 """),format.raw/*19.16*/("""{"""),format.raw/*19.17*/("""
                """),format.raw/*20.17*/("""color: white;
                padding-top: 55px;
                padding-left: 55px;
            """),format.raw/*23.13*/("""}"""),format.raw/*23.14*/("""
            """),format.raw/*24.13*/(""".welcomeHeader """),format.raw/*24.28*/("""{"""),format.raw/*24.29*/("""
                """),format.raw/*25.17*/("""background-color: #92d13d;
                height: 150px;
            """),format.raw/*27.13*/("""}"""),format.raw/*27.14*/("""
        """),format.raw/*28.9*/("""</style>
    </head>
    <body>
        <div class="welcomeHeader">
            <h1>Word-level Statistics</h1>
        </div>
        <div class="row">
            <div class="column">
                """),_display_(/*36.18*/for((k,v) <- wordCount) yield /*36.41*/{_display_(Seq[Any](format.raw/*36.42*/("""
                    """),format.raw/*37.21*/("""<p>"""),_display_(/*37.25*/k),format.raw/*37.26*/(""" """),_display_(/*37.28*/v),format.raw/*37.29*/("""</p>
                """)))}),format.raw/*38.18*/("""
            """),format.raw/*39.13*/("""</div>
            <div class="column">
                """),_display_(/*41.18*/for(title <- titles) yield /*41.38*/{_display_(Seq[Any](format.raw/*41.39*/("""
                    """),format.raw/*42.21*/("""<p>title: """),_display_(/*42.32*/title),format.raw/*42.37*/("""</p>
                """)))}),format.raw/*43.18*/("""
            """),format.raw/*44.13*/("""</div>
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
                  HASH: af0cc2df704cba1280b225048664a734b14102b5
                  MATRIX: 935->1|1085->58|1112->59|1465->384|1494->385|1539->402|1613->448|1642->449|1683->462|1716->467|1745->468|1790->485|1845->512|1874->513|1915->526|1951->534|1980->535|2025->552|2076->575|2105->576|2146->589|2177->592|2206->593|2251->610|2376->707|2405->708|2446->721|2489->736|2518->737|2563->754|2661->824|2690->825|2726->834|2955->1036|2994->1059|3033->1060|3082->1081|3113->1085|3135->1086|3164->1088|3186->1089|3239->1111|3280->1124|3364->1181|3400->1201|3439->1202|3488->1223|3526->1234|3552->1239|3605->1261|3646->1274
                  LINES: 27->1|32->2|33->3|40->10|40->10|41->11|42->12|42->12|43->13|43->13|43->13|44->14|45->15|45->15|46->16|46->16|46->16|47->17|48->18|48->18|49->19|49->19|49->19|50->20|53->23|53->23|54->24|54->24|54->24|55->25|57->27|57->27|58->28|66->36|66->36|66->36|67->37|67->37|67->37|67->37|67->37|68->38|69->39|71->41|71->41|71->41|72->42|72->42|72->42|73->43|74->44
                  -- GENERATED --
              */
          