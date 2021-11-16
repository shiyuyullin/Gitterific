
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
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Mukta&display=swap" rel="stylesheet">
        <style>
            body """),format.raw/*12.18*/("""{"""),format.raw/*12.19*/("""
                """),format.raw/*13.17*/("""font-family: 'Mukta', sans-serif;
            """),format.raw/*14.13*/("""}"""),format.raw/*14.14*/("""
            """),format.raw/*15.13*/(""".welcomeHeader """),format.raw/*15.28*/("""{"""),format.raw/*15.29*/("""
                """),format.raw/*16.17*/("""background-color: #92d13d;
                height: 150px;
            """),format.raw/*18.13*/("""}"""),format.raw/*18.14*/("""
            """),format.raw/*19.13*/(""".result """),format.raw/*19.21*/("""{"""),format.raw/*19.22*/("""
                """),format.raw/*20.17*/("""padding-left: 15%;
                padding-right: 15%;
                padding-top: 3%;
            """),format.raw/*23.13*/("""}"""),format.raw/*23.14*/("""
            """),format.raw/*24.13*/("""h1 """),format.raw/*24.16*/("""{"""),format.raw/*24.17*/("""
                """),format.raw/*25.17*/("""color: white;
                padding-top: 55px;
                padding-left: 55px;
            """),format.raw/*28.13*/("""}"""),format.raw/*28.14*/("""
            """),format.raw/*29.13*/("""form """),format.raw/*29.18*/("""{"""),format.raw/*29.19*/("""
                """),format.raw/*30.17*/("""padding-top: 5%;
                padding-left: 25%;
                padding-right: 20%;
                display: flex;
                flex-flow: row nowrap;
            """),format.raw/*35.13*/("""}"""),format.raw/*35.14*/("""
            """),format.raw/*36.13*/("""input"""),format.raw/*36.18*/("""{"""),format.raw/*36.19*/("""
                """),format.raw/*37.17*/("""height: 45px;
                width: 600px;
            """),format.raw/*39.13*/("""}"""),format.raw/*39.14*/("""

            """),format.raw/*41.13*/("""button """),format.raw/*41.20*/("""{"""),format.raw/*41.21*/("""
                """),format.raw/*42.17*/("""font-family: inherit;
                width: 75px;
                font-size: 16px;
            """),format.raw/*45.13*/("""}"""),format.raw/*45.14*/("""
        """),format.raw/*46.9*/("""</style>
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
            """),_display_(/*64.14*/if(searchKeywords != null && searchKeywords.size != 0)/*64.68*/{_display_(Seq[Any](format.raw/*64.69*/("""
                """),_display_(/*65.18*/if(searchKeywords.size() <= 10)/*65.49*/{_display_(Seq[Any](format.raw/*65.50*/("""
                    """),_display_(/*66.22*/for(i <- searchKeywords.size()-1 to 0 by -1) yield /*66.66*/{_display_(Seq[Any](format.raw/*66.67*/("""
                        """),format.raw/*67.25*/("""<br>
                        <p>Search terms: """),_display_(/*68.43*/searchKeywords/*68.57*/.get(i)),format.raw/*68.64*/("""</p>
                        <table style="width:100% table-layout: fixed; word-wrap:break-word; word-break:break-all;">
                            <tr>
                                <th>Author Name</th>
                                <th>Repo Name</th>
                                <th>Topics</th>
                                <th>Create Date</th>
                            </tr>
                            """),_display_(/*76.30*/for(repo <- allRepos.get(i)) yield /*76.58*/{_display_(Seq[Any](format.raw/*76.59*/("""

                                """),format.raw/*78.33*/("""<tr>
                                    <td style="width: 15%">
                                        <a href=""""),_display_(/*80.51*/routes/*80.57*/.HomeController.userProfile(repo.getAuthorName)),format.raw/*80.104*/("""">"""),_display_(/*80.107*/repo/*80.111*/.getAuthorName),format.raw/*80.125*/("""</a>
                                    </td>
                                    <td style="width: 15%">
                                        <a href=""""),_display_(/*83.51*/routes/*83.57*/.HomeController.repos(repo.getAuthorName().replaceAll("\"", ""), repo.getRepoName().replaceAll("\"", ""))),format.raw/*83.162*/("""">"""),_display_(/*83.165*/repo/*83.169*/.getRepoName()),format.raw/*83.183*/("""</a>
                                    </td >
                                    <td style="width: 40%">
                                    """),_display_(/*86.38*/repo/*86.42*/.getTopics()),format.raw/*86.54*/("""
                                    """),format.raw/*87.37*/("""</td>
                                    <td style="width: 30%">
                                    """),_display_(/*89.38*/repo/*89.42*/.getCreatedDate()),format.raw/*89.59*/("""
                                    """),format.raw/*90.37*/("""</td>

                                </tr>
                            """)))}),format.raw/*93.30*/("""
                        """),format.raw/*94.25*/("""</table>
                    """)))}),format.raw/*95.22*/("""
                """)))}),format.raw/*96.18*/("""
                """),_display_(/*97.18*/if(searchKeywords.size() > 10)/*97.48*/{_display_(Seq[Any](format.raw/*97.49*/("""
                    """),_display_(/*98.22*/for(i <- searchKeywords.size()-1 to searchKeywords.size()-10 by -1) yield /*98.89*/{_display_(Seq[Any](format.raw/*98.90*/("""
                        """),format.raw/*99.25*/("""<br>
                        <p>Search terms: """),_display_(/*100.43*/searchKeywords/*100.57*/.get(i)),format.raw/*100.64*/("""</p>
                        <table style="width:100% table-layout: fixed; word-wrap:break-word; word-break:break-all;">
                            <tr>
                                <th>Author Name</th>
                                <th>Repo Name</th>
                                <th>Topics</th>
                                <th>Create Date</th>
                            </tr>
                            """),_display_(/*108.30*/for(repo <- allRepos.get(i)) yield /*108.58*/{_display_(Seq[Any](format.raw/*108.59*/("""

                                """),format.raw/*110.33*/("""<tr>
                                    <td style="width: 15%">
                                        <a href=""""),_display_(/*112.51*/routes/*112.57*/.HomeController.userProfile(repo.getAuthorName)),format.raw/*112.104*/("""">"""),_display_(/*112.107*/repo/*112.111*/.getAuthorName),format.raw/*112.125*/("""</a>
                                    </td>
                                    <td style="width: 15%">
                                        <a href=""""),_display_(/*115.51*/routes/*115.57*/.HomeController.repos(repo.getAuthorName().replaceAll("\"", ""), repo.getRepoName().replaceAll("\"", ""))),format.raw/*115.162*/("""">"""),_display_(/*115.165*/repo/*115.169*/.getRepoName()),format.raw/*115.183*/("""</a>
                                    </td >
                                    <td style="width: 40%">
                                    """),_display_(/*118.38*/repo/*118.42*/.getTopics()),format.raw/*118.54*/("""
                                    """),format.raw/*119.37*/("""</td>
                                    <td style="width: 30%">
                                    """),_display_(/*121.38*/repo/*121.42*/.getCreatedDate()),format.raw/*121.59*/("""
                                    """),format.raw/*122.37*/("""</td>

                                </tr>
                            """)))}),format.raw/*125.30*/("""
                        """),format.raw/*126.25*/("""</table>
                    """)))}),format.raw/*127.22*/("""
                """)))}),format.raw/*128.18*/("""

            """)))}),format.raw/*130.14*/("""
        """),format.raw/*131.9*/("""</div>

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
                  HASH: fa32177c837873569ed0eb7dcc91ae68078471d6
                  MATRIX: 610->1|977->31|1140->101|1167->102|1521->428|1550->429|1595->446|1669->492|1698->493|1739->506|1782->521|1811->522|1856->539|1954->609|1983->610|2024->623|2060->631|2089->632|2134->649|2262->749|2291->750|2332->763|2363->766|2392->767|2437->784|2562->881|2591->882|2632->895|2665->900|2694->901|2739->918|2937->1088|2966->1089|3007->1102|3040->1107|3069->1108|3114->1125|3198->1181|3227->1182|3269->1196|3304->1203|3333->1204|3378->1221|3502->1317|3531->1318|3567->1327|4022->1755|4085->1809|4124->1810|4169->1828|4209->1859|4248->1860|4297->1882|4357->1926|4396->1927|4449->1952|4523->1999|4546->2013|4574->2020|5023->2442|5067->2470|5106->2471|5168->2505|5310->2620|5325->2626|5394->2673|5425->2676|5439->2680|5475->2694|5659->2851|5674->2857|5801->2962|5832->2965|5846->2969|5882->2983|6054->3128|6067->3132|6100->3144|6165->3181|6295->3284|6308->3288|6346->3305|6411->3342|6516->3416|6569->3441|6630->3471|6679->3489|6724->3507|6763->3537|6802->3538|6851->3560|6934->3627|6973->3628|7026->3653|7101->3700|7125->3714|7154->3721|7604->4143|7649->4171|7689->4172|7752->4206|7895->4321|7911->4327|7981->4374|8013->4377|8028->4381|8065->4395|8250->4552|8266->4558|8394->4663|8426->4666|8441->4670|8478->4684|8651->4829|8665->4833|8699->4845|8765->4882|8896->4985|8910->4989|8949->5006|9015->5043|9121->5117|9175->5142|9237->5172|9287->5190|9334->5205|9371->5214
                  LINES: 23->1|28->2|33->3|34->4|42->12|42->12|43->13|44->14|44->14|45->15|45->15|45->15|46->16|48->18|48->18|49->19|49->19|49->19|50->20|53->23|53->23|54->24|54->24|54->24|55->25|58->28|58->28|59->29|59->29|59->29|60->30|65->35|65->35|66->36|66->36|66->36|67->37|69->39|69->39|71->41|71->41|71->41|72->42|75->45|75->45|76->46|94->64|94->64|94->64|95->65|95->65|95->65|96->66|96->66|96->66|97->67|98->68|98->68|98->68|106->76|106->76|106->76|108->78|110->80|110->80|110->80|110->80|110->80|110->80|113->83|113->83|113->83|113->83|113->83|113->83|116->86|116->86|116->86|117->87|119->89|119->89|119->89|120->90|123->93|124->94|125->95|126->96|127->97|127->97|127->97|128->98|128->98|128->98|129->99|130->100|130->100|130->100|138->108|138->108|138->108|140->110|142->112|142->112|142->112|142->112|142->112|142->112|145->115|145->115|145->115|145->115|145->115|145->115|148->118|148->118|148->118|149->119|151->121|151->121|151->121|152->122|155->125|156->126|157->127|158->128|160->130|161->131
                  -- GENERATED --
              */
          