
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
/*1.2*/import model.GeneralRepoInfo

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[List[GeneralRepoInfo],String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(listOfRepo : List[GeneralRepoInfo], keywords: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""
"""),format.raw/*4.1*/("""<html>

    <head>
        <title>Search</title>
        <style>
            .welcomeHeader """),format.raw/*9.28*/("""{"""),format.raw/*9.29*/("""
                """),format.raw/*10.17*/("""background-color: #92d13d;
                height: 150px;
            """),format.raw/*12.13*/("""}"""),format.raw/*12.14*/("""
            """),format.raw/*13.13*/(""".result """),format.raw/*13.21*/("""{"""),format.raw/*13.22*/("""
                """),format.raw/*14.17*/("""padding-left: 15%;
                padding-right: 15%;
                padding-top: 3%;
            """),format.raw/*17.13*/("""}"""),format.raw/*17.14*/("""
            """),format.raw/*18.13*/("""h1 """),format.raw/*18.16*/("""{"""),format.raw/*18.17*/("""
                """),format.raw/*19.17*/("""color: white;
                padding-top: 55px;
                padding-left: 55px;
            """),format.raw/*22.13*/("""}"""),format.raw/*22.14*/("""
            """),format.raw/*23.13*/("""form """),format.raw/*23.18*/("""{"""),format.raw/*23.19*/("""
                """),format.raw/*24.17*/("""padding-top: 5%;
                padding-left: 25%;
                padding-right: 20%;
            """),format.raw/*27.13*/("""}"""),format.raw/*27.14*/("""
            """),format.raw/*28.13*/("""input"""),format.raw/*28.18*/("""{"""),format.raw/*28.19*/("""
                """),format.raw/*29.17*/("""height: 45px;
                width: 600px;
            """),format.raw/*31.13*/("""}"""),format.raw/*31.14*/("""
        """),format.raw/*32.9*/("""</style>
    </head>

    <body>
        <div class="welcomeHeader">
            <h1>Welcome to Gitterific</h1>
        </div>

        <div>
            <form action="/keyword" method="post">
                <input type="text" placeholder="Search.." name="keywords">
                <button type="submit" style="height:45px; width: 60px">search</button>
            </form>
        </div>

        <div class="result">
            """),_display_(/*48.14*/if(!listOfRepo.isEmpty())/*48.39*/{_display_(Seq[Any](format.raw/*48.40*/("""
                """),format.raw/*49.17*/("""<p>Search terms: """),_display_(/*49.35*/keywords),format.raw/*49.43*/("""</p>
                """),_display_(/*50.18*/for(repo <- listOfRepo) yield /*50.41*/{_display_(Seq[Any](format.raw/*50.42*/("""
                    """),format.raw/*51.21*/("""<p>"""),_display_(/*51.25*/repo/*51.29*/.getAuthorName()),format.raw/*51.45*/(""", """),_display_(/*51.48*/repo/*51.52*/.getRepoName()),format.raw/*51.66*/(""", """),_display_(/*51.69*/repo/*51.73*/.getTopics()),format.raw/*51.85*/(""", """),_display_(/*51.88*/repo/*51.92*/.getCreatedDate()),format.raw/*51.109*/("""</p>
                """)))}),format.raw/*52.18*/("""
            """)))}),format.raw/*53.14*/("""
        """),format.raw/*54.9*/("""</div>

    </body>


</html>"""))
      }
    }
  }

  def render(listOfRepo:List[GeneralRepoInfo],keywords:String): play.twirl.api.HtmlFormat.Appendable = apply(listOfRepo,keywords)

  def f:((List[GeneralRepoInfo],String) => play.twirl.api.HtmlFormat.Appendable) = (listOfRepo,keywords) => apply(listOfRepo,keywords)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: 454e7b6f78c4e27f63e69371b2375da480762c39
                  MATRIX: 610->1|965->31|1113->86|1140->87|1259->179|1287->180|1332->197|1430->267|1459->268|1500->281|1536->289|1565->290|1610->307|1738->407|1767->408|1808->421|1839->424|1868->425|1913->442|2038->539|2067->540|2108->553|2141->558|2170->559|2215->576|2343->676|2372->677|2413->690|2446->695|2475->696|2520->713|2604->769|2633->770|2669->779|3129->1212|3163->1237|3202->1238|3247->1255|3292->1273|3321->1281|3370->1303|3409->1326|3448->1327|3497->1348|3528->1352|3541->1356|3578->1372|3608->1375|3621->1379|3656->1393|3686->1396|3699->1400|3732->1412|3762->1415|3775->1419|3814->1436|3867->1458|3912->1472|3948->1481
                  LINES: 23->1|28->2|33->3|34->4|39->9|39->9|40->10|42->12|42->12|43->13|43->13|43->13|44->14|47->17|47->17|48->18|48->18|48->18|49->19|52->22|52->22|53->23|53->23|53->23|54->24|57->27|57->27|58->28|58->28|58->28|59->29|61->31|61->31|62->32|78->48|78->48|78->48|79->49|79->49|79->49|80->50|80->50|80->50|81->51|81->51|81->51|81->51|81->51|81->51|81->51|81->51|81->51|81->51|81->51|81->51|81->51|82->52|83->53|84->54
                  -- GENERATED --
              */
          