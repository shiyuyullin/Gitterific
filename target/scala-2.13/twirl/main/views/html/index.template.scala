
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
                """),_display_(/*65.18*/for(i <- searchKeywords.size()-1 to 0 by -1) yield /*65.62*/{_display_(Seq[Any](format.raw/*65.63*/("""
                    """),format.raw/*66.21*/("""<br>
                    <p>Search terms: """),_display_(/*67.39*/searchKeywords/*67.53*/.get(i)),format.raw/*67.60*/("""</p>
                    <table style="width:100% table-layout: fixed; word-wrap:break-word; word-break:break-all;">
                        <tr>
                            <th>Author Name</th>
                            <th>Repo Name</th>
                            <th>Topics</th>
                            <th>Create Date</th>
                        </tr>
                    """),_display_(/*75.22*/for(repo <- allRepos.get(i)) yield /*75.50*/{_display_(Seq[Any](format.raw/*75.51*/("""

                            """),format.raw/*77.29*/("""<tr>
                                <td style="width: 15%">
                                    <a href=""""),_display_(/*79.47*/routes/*79.53*/.HomeController.userProfile(repo.getAuthorName)),format.raw/*79.100*/("""">"""),_display_(/*79.103*/repo/*79.107*/.getAuthorName),format.raw/*79.121*/("""</a>
                                </td>
                                <td style="width: 15%">
                                    <a href=""""),_display_(/*82.47*/routes/*82.53*/.HomeController.repos(repo.getAuthorName().replaceAll("\"", ""), repo.getRepoName().replaceAll("\"", ""))),format.raw/*82.158*/("""">"""),_display_(/*82.161*/repo/*82.165*/.getRepoName()),format.raw/*82.179*/("""</a>
                                </td >
                                <td style="width: 40%">
                                """),_display_(/*85.34*/repo/*85.38*/.getTopics()),format.raw/*85.50*/("""
                                """),format.raw/*86.33*/("""</td>
                                <td style="width: 30%">
                                """),_display_(/*88.34*/repo/*88.38*/.getCreatedDate()),format.raw/*88.55*/("""
                                """),format.raw/*89.33*/("""</td>

                            </tr>
                    """)))}),format.raw/*92.22*/("""
                    """),format.raw/*93.21*/("""</table>
                """)))}),format.raw/*94.18*/("""
            """)))}),format.raw/*95.14*/("""
        """),format.raw/*96.9*/("""</div>

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
                  HASH: d969ea56c69c2176244e31c217cc672ae4906c65
                  MATRIX: 610->1|977->31|1140->101|1167->102|1521->428|1550->429|1595->446|1669->492|1698->493|1739->506|1782->521|1811->522|1856->539|1954->609|1983->610|2024->623|2060->631|2089->632|2134->649|2262->749|2291->750|2332->763|2363->766|2392->767|2437->784|2562->881|2591->882|2632->895|2665->900|2694->901|2739->918|2937->1088|2966->1089|3007->1102|3040->1107|3069->1108|3114->1125|3198->1181|3227->1182|3269->1196|3304->1203|3333->1204|3378->1221|3502->1317|3531->1318|3567->1327|4022->1755|4085->1809|4124->1810|4169->1828|4229->1872|4268->1873|4317->1894|4387->1937|4410->1951|4438->1958|4851->2344|4895->2372|4934->2373|4992->2403|5126->2510|5141->2516|5210->2563|5241->2566|5255->2570|5291->2584|5463->2729|5478->2735|5605->2840|5636->2843|5650->2847|5686->2861|5846->2994|5859->2998|5892->3010|5953->3043|6075->3138|6088->3142|6126->3159|6187->3192|6280->3254|6329->3275|6386->3301|6431->3315|6467->3324
                  LINES: 23->1|28->2|33->3|34->4|42->12|42->12|43->13|44->14|44->14|45->15|45->15|45->15|46->16|48->18|48->18|49->19|49->19|49->19|50->20|53->23|53->23|54->24|54->24|54->24|55->25|58->28|58->28|59->29|59->29|59->29|60->30|65->35|65->35|66->36|66->36|66->36|67->37|69->39|69->39|71->41|71->41|71->41|72->42|75->45|75->45|76->46|94->64|94->64|94->64|95->65|95->65|95->65|96->66|97->67|97->67|97->67|105->75|105->75|105->75|107->77|109->79|109->79|109->79|109->79|109->79|109->79|112->82|112->82|112->82|112->82|112->82|112->82|115->85|115->85|115->85|116->86|118->88|118->88|118->88|119->89|122->92|123->93|124->94|125->95|126->96
                  -- GENERATED --
              */
          