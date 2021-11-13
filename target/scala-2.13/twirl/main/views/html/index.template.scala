
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
            """),_display_(/*50.14*/if(searchKeywords != null && searchKeywords.size != 0)/*50.68*/{_display_(Seq[Any](format.raw/*50.69*/("""
                """),_display_(/*51.18*/for(i <- searchKeywords.size()-1 to 0 by -1) yield /*51.62*/{_display_(Seq[Any](format.raw/*51.63*/("""
                    """),format.raw/*52.21*/("""<br>
                    <p>Search terms: """),_display_(/*53.39*/searchKeywords/*53.53*/.get(i)),format.raw/*53.60*/("""</p>
                    <table style="width=100% table-layout: fixed; word-wrap:break-word; word-break:break-all;">
                    """),_display_(/*55.22*/for(repo <- allRepos.get(i)) yield /*55.50*/{_display_(Seq[Any](format.raw/*55.51*/("""

                            """),format.raw/*57.29*/("""<tr>
                                <td style="width: 15%">
                                    <a href=""""),_display_(/*59.47*/routes/*59.53*/.HomeController.userProfile(repo.getAuthorName)),format.raw/*59.100*/("""">"""),_display_(/*59.103*/repo/*59.107*/.getAuthorName),format.raw/*59.121*/("""</a>
                                </td>
                                <td style="width: 15%">
                                    <a href=""""),_display_(/*62.47*/routes/*62.53*/.HomeController.repos(repo.getAuthorName().replaceAll("\"", ""), repo.getRepoName().replaceAll("\"", ""))),format.raw/*62.158*/("""">"""),_display_(/*62.161*/repo/*62.165*/.getRepoName()),format.raw/*62.179*/("""</a>
                                </td >
                                <td style="width: 40%">
                                """),_display_(/*65.34*/repo/*65.38*/.getTopics()),format.raw/*65.50*/("""
                                """),format.raw/*66.33*/("""</td>
                                <td style="width: 30%">
                                """),_display_(/*68.34*/repo/*68.38*/.getCreatedDate()),format.raw/*68.55*/("""
                                """),format.raw/*69.33*/("""</td>

                            </tr>
                    """)))}),format.raw/*72.22*/("""
                    """),format.raw/*73.21*/("""</table>
                """)))}),format.raw/*74.18*/("""
            """)))}),format.raw/*75.14*/("""
        """),format.raw/*76.9*/("""</div>

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
                  HASH: b5a964c5046123330bd6d4b48f574b266f5f95c5
                  MATRIX: 610->1|977->31|1140->101|1167->102|1286->194|1314->195|1359->212|1457->282|1486->283|1527->296|1563->304|1592->305|1637->322|1765->422|1794->423|1835->436|1866->439|1895->440|1940->457|2065->554|2094->555|2135->568|2168->573|2197->574|2242->591|2370->691|2399->692|2440->705|2473->710|2502->711|2547->728|2631->784|2660->785|2696->794|3151->1222|3214->1276|3253->1277|3298->1295|3358->1339|3397->1340|3446->1361|3516->1404|3539->1418|3567->1425|3732->1563|3776->1591|3815->1592|3873->1622|4007->1729|4022->1735|4091->1782|4122->1785|4136->1789|4172->1803|4344->1948|4359->1954|4486->2059|4517->2062|4531->2066|4567->2080|4727->2213|4740->2217|4773->2229|4834->2262|4956->2357|4969->2361|5007->2378|5068->2411|5161->2473|5210->2494|5267->2520|5312->2534|5348->2543
                  LINES: 23->1|28->2|33->3|34->4|39->9|39->9|40->10|42->12|42->12|43->13|43->13|43->13|44->14|47->17|47->17|48->18|48->18|48->18|49->19|52->22|52->22|53->23|53->23|53->23|54->24|57->27|57->27|58->28|58->28|58->28|59->29|61->31|61->31|62->32|80->50|80->50|80->50|81->51|81->51|81->51|82->52|83->53|83->53|83->53|85->55|85->55|85->55|87->57|89->59|89->59|89->59|89->59|89->59|89->59|92->62|92->62|92->62|92->62|92->62|92->62|95->65|95->65|95->65|96->66|98->68|98->68|98->68|99->69|102->72|103->73|104->74|105->75|106->76
                  -- GENERATED --
              */
          