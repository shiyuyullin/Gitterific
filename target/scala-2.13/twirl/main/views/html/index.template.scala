
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[GeneralRepoInfo],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(listOfRepo : List[GeneralRepoInfo]):play.twirl.api.HtmlFormat.Appendable = {
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
            """),format.raw/*13.13*/("""h1 """),format.raw/*13.16*/("""{"""),format.raw/*13.17*/("""
                """),format.raw/*14.17*/("""color: white;
                padding-top: 55px;
                padding-left: 55px;
            """),format.raw/*17.13*/("""}"""),format.raw/*17.14*/("""
            """),format.raw/*18.13*/("""form """),format.raw/*18.18*/("""{"""),format.raw/*18.19*/("""
                """),format.raw/*19.17*/("""padding-top: 300px;
                padding-left: 30%;
            """),format.raw/*21.13*/("""}"""),format.raw/*21.14*/("""
            """),format.raw/*22.13*/("""input"""),format.raw/*22.18*/("""{"""),format.raw/*22.19*/("""
                """),format.raw/*23.17*/("""height: 45px;
                width: 600px;
            """),format.raw/*25.13*/("""}"""),format.raw/*25.14*/("""
        """),format.raw/*26.9*/("""</style>
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

        <div>
            """),_display_(/*42.14*/if(!listOfRepo.isEmpty())/*42.39*/{_display_(Seq[Any](format.raw/*42.40*/("""
                """),_display_(/*43.18*/for(repo <- listOfRepo) yield /*43.41*/{_display_(Seq[Any](format.raw/*43.42*/("""
                    """),format.raw/*44.21*/("""<h>"""),_display_(/*44.25*/repo/*44.29*/.getAuthorName()),format.raw/*44.45*/(""", """),_display_(/*44.48*/repo/*44.52*/.getRepoName()),format.raw/*44.66*/(""", """),_display_(/*44.69*/repo/*44.73*/.getTopics()),format.raw/*44.85*/("""</h>
                """)))}),format.raw/*45.18*/("""
            """)))}),format.raw/*46.14*/("""
        """),format.raw/*47.9*/("""</div>

    </body>


</html>"""))
      }
    }
  }

  def render(listOfRepo:List[GeneralRepoInfo]): play.twirl.api.HtmlFormat.Appendable = apply(listOfRepo)

  def f:((List[GeneralRepoInfo]) => play.twirl.api.HtmlFormat.Appendable) = (listOfRepo) => apply(listOfRepo)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: fb6e97ca0c199427e5ad40a8e9ca108dea956b0a
                  MATRIX: 610->1|958->31|1088->68|1115->69|1234->161|1262->162|1307->179|1405->249|1434->250|1475->263|1506->266|1535->267|1580->284|1705->381|1734->382|1775->395|1808->400|1837->401|1882->418|1977->485|2006->486|2047->499|2080->504|2109->505|2154->522|2238->578|2267->579|2303->588|2748->1006|2782->1031|2821->1032|2866->1050|2905->1073|2944->1074|2993->1095|3024->1099|3037->1103|3074->1119|3104->1122|3117->1126|3152->1140|3182->1143|3195->1147|3228->1159|3281->1181|3326->1195|3362->1204
                  LINES: 23->1|28->2|33->3|34->4|39->9|39->9|40->10|42->12|42->12|43->13|43->13|43->13|44->14|47->17|47->17|48->18|48->18|48->18|49->19|51->21|51->21|52->22|52->22|52->22|53->23|55->25|55->25|56->26|72->42|72->42|72->42|73->43|73->43|73->43|74->44|74->44|74->44|74->44|74->44|74->44|74->44|74->44|74->44|74->44|75->45|76->46|77->47
                  -- GENERATED --
              */
          