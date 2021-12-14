
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[List[List[GeneralRepoInfo]],List[String],play.mvc.Http.Request,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(allRepos: List[List[GeneralRepoInfo]], searchKeywords: List[String], request: play.mvc.Http.Request):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""
"""),format.raw/*4.1*/("""<html>
    <head>
        <title>Search</title>
        <style>
            body """),format.raw/*8.18*/("""{"""),format.raw/*8.19*/("""
                """),format.raw/*9.17*/("""font-family: 'Mukta', sans-serif;
            """),format.raw/*10.13*/("""}"""),format.raw/*10.14*/("""
            """),format.raw/*11.13*/(""".welcomeHeader """),format.raw/*11.28*/("""{"""),format.raw/*11.29*/("""
                """),format.raw/*12.17*/("""background-color: #92d13d;
                height: 150px;
            """),format.raw/*14.13*/("""}"""),format.raw/*14.14*/("""
            """),format.raw/*15.13*/(""".result """),format.raw/*15.21*/("""{"""),format.raw/*15.22*/("""
                """),format.raw/*16.17*/("""padding-left: 15%;
                padding-right: 15%;
                padding-top: 3%;
            """),format.raw/*19.13*/("""}"""),format.raw/*19.14*/("""
            """),format.raw/*20.13*/("""h1 """),format.raw/*20.16*/("""{"""),format.raw/*20.17*/("""
                """),format.raw/*21.17*/("""color: white;
                padding-top: 55px;
                padding-left: 55px;
            """),format.raw/*24.13*/("""}"""),format.raw/*24.14*/("""
            """),format.raw/*25.13*/("""form """),format.raw/*25.18*/("""{"""),format.raw/*25.19*/("""
                """),format.raw/*26.17*/("""padding-top: 5%;
                padding-left: 25%;
                padding-right: 20%;
                display: flex;
                flex-flow: row nowrap;
            """),format.raw/*31.13*/("""}"""),format.raw/*31.14*/("""
            """),format.raw/*32.13*/("""input"""),format.raw/*32.18*/("""{"""),format.raw/*32.19*/("""
                """),format.raw/*33.17*/("""height: 45px;
                width: 600px;
            """),format.raw/*35.13*/("""}"""),format.raw/*35.14*/("""

            """),format.raw/*37.13*/("""button """),format.raw/*37.20*/("""{"""),format.raw/*37.21*/("""
                """),format.raw/*38.17*/("""font-family: inherit;
                width: 75px;
                font-size: 16px;
            """),format.raw/*41.13*/("""}"""),format.raw/*41.14*/("""
        """),format.raw/*42.9*/("""</style>
    </head>

    <body>
        <div class="welcomeHeader">
            <h1>Welcome to Gitterific</h1>
        </div>
        <input type="hidden" id="ws-route" value=""""),_display_(/*49.52*/routes/*49.58*/.HomeController.socket.webSocketURL(request)),format.raw/*49.102*/("""">
        <div>
            <form action="/" method="post">
                <input type="text" placeholder="Search.." name="keywords">
                <button type="submit" style="height:45px; width: 60px">search</button>
            </form>
        </div>



        <div class="result">
            """),_display_(/*60.14*/if(searchKeywords != null && searchKeywords.size != 0)/*60.68*/{_display_(Seq[Any](format.raw/*60.69*/("""
                """),_display_(/*61.18*/if(searchKeywords.size() <= 10)/*61.49*/{_display_(Seq[Any](format.raw/*61.50*/("""
                    """),_display_(/*62.22*/for(i <- searchKeywords.size()-1 to 0 by -1) yield /*62.66*/{_display_(Seq[Any](format.raw/*62.67*/("""
                        """),format.raw/*63.25*/("""<br>
                        <p>Search terms: """),_display_(/*64.43*/searchKeywords/*64.57*/.get(i)),format.raw/*64.64*/("""</p>
                        <table id=""""),_display_(/*65.37*/searchKeywords/*65.51*/.get(i)),format.raw/*65.58*/("""" style="width:100% table-layout: fixed; word-wrap:break-word; word-break:break-all;">
                            <tr>
                                <th>Author Name</th>
                                <th>Repo Name</th>
                                <th>Topics</th>
                                <th>Create Date</th>
                            </tr>
                            """),_display_(/*72.30*/for(repo <- allRepos.get(i)) yield /*72.58*/{_display_(Seq[Any](format.raw/*72.59*/("""
                                """),format.raw/*73.33*/("""<tr>
                                    <td style="width: 15%">
                                        <a href=""""),_display_(/*75.51*/routes/*75.57*/.HomeController.userProfile(repo.getAuthorName)),format.raw/*75.104*/("""">"""),_display_(/*75.107*/repo/*75.111*/.getAuthorName),format.raw/*75.125*/("""</a>
                                    </td>
                                    <td style="width: 15%">
                                        <a href=""""),_display_(/*78.51*/routes/*78.57*/.HomeController.repos(repo.getAuthorName().replaceAll("\"", ""), repo.getRepoName().replaceAll("\"", ""))),format.raw/*78.162*/("""">"""),_display_(/*78.165*/repo/*78.169*/.getRepoName()),format.raw/*78.183*/("""</a>
                                    </td >
                                    <td style="width: 40%">
                                    """),_display_(/*81.38*/repo/*81.42*/.getTopics()),format.raw/*81.54*/("""
                                    """),format.raw/*82.37*/("""</td>
                                    <td style="width: 30%">
                                    """),_display_(/*84.38*/repo/*84.42*/.getCreatedDate()),format.raw/*84.59*/("""
                                    """),format.raw/*85.37*/("""</td>
                                </tr>
                            """)))}),format.raw/*87.30*/("""
                        """),format.raw/*88.25*/("""</table>
                    """)))}),format.raw/*89.22*/("""
                """)))}),format.raw/*90.18*/("""
                """),_display_(/*91.18*/if(searchKeywords.size() > 10)/*91.48*/{_display_(Seq[Any](format.raw/*91.49*/("""
                    """),_display_(/*92.22*/for(i <- searchKeywords.size()-1 to searchKeywords.size()-10 by -1) yield /*92.89*/{_display_(Seq[Any](format.raw/*92.90*/("""
                        """),format.raw/*93.25*/("""<br>
                        <p>Search terms: """),_display_(/*94.43*/searchKeywords/*94.57*/.get(i)),format.raw/*94.64*/("""</p>
                        <table style="width:100% table-layout: fixed; word-wrap:break-word; word-break:break-all;">
                            <tr>
                                <th>Author Name</th>
                                <th>Repo Name</th>
                                <th>Topics</th>
                                <th>Create Date</th>
                            </tr>
                            """),_display_(/*102.30*/for(repo <- allRepos.get(i)) yield /*102.58*/{_display_(Seq[Any](format.raw/*102.59*/("""

                                """),format.raw/*104.33*/("""<tr>
                                    <td style="width: 15%">
                                        <a href=""""),_display_(/*106.51*/routes/*106.57*/.HomeController.userProfile(repo.getAuthorName)),format.raw/*106.104*/("""">"""),_display_(/*106.107*/repo/*106.111*/.getAuthorName),format.raw/*106.125*/("""</a>
                                    </td>
                                    <td style="width: 15%">
                                        <a href=""""),_display_(/*109.51*/routes/*109.57*/.HomeController.repos(repo.getAuthorName().replaceAll("\"", ""), repo.getRepoName().replaceAll("\"", ""))),format.raw/*109.162*/("""">"""),_display_(/*109.165*/repo/*109.169*/.getRepoName()),format.raw/*109.183*/("""</a>
                                    </td >
                                    <td style="width: 40%">
                                    """),_display_(/*112.38*/repo/*112.42*/.getTopics()),format.raw/*112.54*/("""
                                    """),format.raw/*113.37*/("""</td>
                                    <td style="width: 30%">
                                    """),_display_(/*115.38*/repo/*115.42*/.getCreatedDate()),format.raw/*115.59*/("""
                                    """),format.raw/*116.37*/("""</td>

                                </tr>
                            """)))}),format.raw/*119.30*/("""
                        """),format.raw/*120.25*/("""</table>
                    """)))}),format.raw/*121.22*/("""
                """)))}),format.raw/*122.18*/("""

            """)))}),format.raw/*124.14*/("""
        """),format.raw/*125.9*/("""</div>
        <script type='text/javascript' src='"""),_display_(/*126.46*/routes/*126.52*/.Assets.at("javascripts/index.js")),format.raw/*126.86*/("""'></script>
    </body>


</html>"""))
      }
    }
  }

  def render(allRepos:List[List[GeneralRepoInfo]],searchKeywords:List[String],request:play.mvc.Http.Request): play.twirl.api.HtmlFormat.Appendable = apply(allRepos,searchKeywords,request)

  def f:((List[List[GeneralRepoInfo]],List[String],play.mvc.Http.Request) => play.twirl.api.HtmlFormat.Appendable) = (allRepos,searchKeywords,request) => apply(allRepos,searchKeywords,request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: f8a708b2e048319f0b65748536c329a2a47a47b7
                  MATRIX: 610->1|999->31|1194->133|1221->134|1329->215|1357->216|1401->233|1475->279|1504->280|1545->293|1588->308|1617->309|1662->326|1760->396|1789->397|1830->410|1866->418|1895->419|1940->436|2068->536|2097->537|2138->550|2169->553|2198->554|2243->571|2368->668|2397->669|2438->682|2471->687|2500->688|2545->705|2743->875|2772->876|2813->889|2846->894|2875->895|2920->912|3004->968|3033->969|3075->983|3110->990|3139->991|3184->1008|3308->1104|3337->1105|3373->1114|3578->1292|3593->1298|3659->1342|3989->1645|4052->1699|4091->1700|4136->1718|4176->1749|4215->1750|4264->1772|4324->1816|4363->1817|4416->1842|4490->1889|4513->1903|4541->1910|4609->1951|4632->1965|4660->1972|5075->2360|5119->2388|5158->2389|5219->2422|5361->2537|5376->2543|5445->2590|5476->2593|5490->2597|5526->2611|5710->2768|5725->2774|5852->2879|5883->2882|5897->2886|5933->2900|6105->3045|6118->3049|6151->3061|6216->3098|6346->3201|6359->3205|6397->3222|6462->3259|6566->3332|6619->3357|6680->3387|6729->3405|6774->3423|6813->3453|6852->3454|6901->3476|6984->3543|7023->3544|7076->3569|7150->3616|7173->3630|7201->3637|7651->4059|7696->4087|7736->4088|7799->4122|7942->4237|7958->4243|8028->4290|8060->4293|8075->4297|8112->4311|8297->4468|8313->4474|8441->4579|8473->4582|8488->4586|8525->4600|8698->4745|8712->4749|8746->4761|8812->4798|8943->4901|8957->4905|8996->4922|9062->4959|9168->5033|9222->5058|9284->5088|9334->5106|9381->5121|9418->5130|9498->5182|9514->5188|9570->5222
                  LINES: 23->1|28->2|33->3|34->4|38->8|38->8|39->9|40->10|40->10|41->11|41->11|41->11|42->12|44->14|44->14|45->15|45->15|45->15|46->16|49->19|49->19|50->20|50->20|50->20|51->21|54->24|54->24|55->25|55->25|55->25|56->26|61->31|61->31|62->32|62->32|62->32|63->33|65->35|65->35|67->37|67->37|67->37|68->38|71->41|71->41|72->42|79->49|79->49|79->49|90->60|90->60|90->60|91->61|91->61|91->61|92->62|92->62|92->62|93->63|94->64|94->64|94->64|95->65|95->65|95->65|102->72|102->72|102->72|103->73|105->75|105->75|105->75|105->75|105->75|105->75|108->78|108->78|108->78|108->78|108->78|108->78|111->81|111->81|111->81|112->82|114->84|114->84|114->84|115->85|117->87|118->88|119->89|120->90|121->91|121->91|121->91|122->92|122->92|122->92|123->93|124->94|124->94|124->94|132->102|132->102|132->102|134->104|136->106|136->106|136->106|136->106|136->106|136->106|139->109|139->109|139->109|139->109|139->109|139->109|142->112|142->112|142->112|143->113|145->115|145->115|145->115|146->116|149->119|150->120|151->121|152->122|154->124|155->125|156->126|156->126|156->126
                  -- GENERATED --
              */
          