
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[List[List[GeneralRepoInfo]],List[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(allRepos: List[List[GeneralRepoInfo]], searchKeywords: List[String]):play.twirl.api.HtmlFormat.Appendable = {
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
            <form action="/" method="post">
                <input type="text" placeholder="Search.." name="keywords">
                <button type="submit" style="height:45px; width: 60px">search</button>
            </form>
        </div>



        <div class="result">
            """),_display_(/*50.14*/if(searchKeywords.size != 0)/*50.42*/{_display_(Seq[Any](format.raw/*50.43*/("""
                """),_display_(/*51.18*/for(i <- searchKeywords.size()-1 to 0 by -1) yield /*51.62*/{_display_(Seq[Any](format.raw/*51.63*/("""
                    """),format.raw/*52.21*/("""<br>
                    <p>Search terms: """),_display_(/*53.39*/searchKeywords/*53.53*/.get(i)),format.raw/*53.60*/("""</p>
                    """),_display_(/*54.22*/for(repo <- allRepos.get(i)) yield /*54.50*/{_display_(Seq[Any](format.raw/*54.51*/("""
                        """),format.raw/*55.25*/("""<P>"""),_display_(/*55.29*/repo),format.raw/*55.33*/("""</P>
                    """)))}),format.raw/*56.22*/("""
                """)))}),format.raw/*57.18*/("""
            """)))}),format.raw/*58.14*/("""
        """),format.raw/*59.9*/("""</div>

    </body>


</html>"""))
      }
    }
  }

  def render(allRepos:List[List[GeneralRepoInfo]],searchKeywords:List[String]): play.twirl.api.HtmlFormat.Appendable = apply(allRepos,searchKeywords)

  def f:((List[List[GeneralRepoInfo]],List[String]) => play.twirl.api.HtmlFormat.Appendable) = (allRepos,searchKeywords) => apply(allRepos,searchKeywords)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: f891072ec2ae2ef436eec4b0662168d0616d6403
                  MATRIX: 610->1|977->31|1140->101|1167->102|1286->194|1314->195|1359->212|1457->282|1486->283|1527->296|1563->304|1592->305|1637->322|1765->422|1794->423|1835->436|1866->439|1895->440|1940->457|2065->554|2094->555|2135->568|2168->573|2197->574|2242->591|2370->691|2399->692|2440->705|2473->710|2502->711|2547->728|2631->784|2660->785|2696->794|3151->1222|3188->1250|3227->1251|3272->1269|3332->1313|3371->1314|3420->1335|3490->1378|3513->1392|3541->1399|3594->1425|3638->1453|3677->1454|3730->1479|3761->1483|3786->1487|3843->1513|3892->1531|3937->1545|3973->1554
                  LINES: 23->1|28->2|33->3|34->4|39->9|39->9|40->10|42->12|42->12|43->13|43->13|43->13|44->14|47->17|47->17|48->18|48->18|48->18|49->19|52->22|52->22|53->23|53->23|53->23|54->24|57->27|57->27|58->28|58->28|58->28|59->29|61->31|61->31|62->32|80->50|80->50|80->50|81->51|81->51|81->51|82->52|83->53|83->53|83->53|84->54|84->54|84->54|85->55|85->55|85->55|86->56|87->57|88->58|89->59
                  -- GENERATED --
              */
          