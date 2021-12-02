
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
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Mukta&display=swap" rel="stylesheet">
        <style>
            body """),format.raw/*11.18*/("""{"""),format.raw/*11.19*/("""
                """),format.raw/*12.17*/("""font-family: 'Mukta', sans-serif;
            """),format.raw/*13.13*/("""}"""),format.raw/*13.14*/("""
            """),format.raw/*14.13*/(""".welcomeHeader """),format.raw/*14.28*/("""{"""),format.raw/*14.29*/("""
                """),format.raw/*15.17*/("""background-color: #92d13d;
                height: 150px;
            """),format.raw/*17.13*/("""}"""),format.raw/*17.14*/("""
            """),format.raw/*18.13*/(""".result """),format.raw/*18.21*/("""{"""),format.raw/*18.22*/("""
                """),format.raw/*19.17*/("""padding-left: 15%;
                padding-right: 15%;
                padding-top: 3%;
            """),format.raw/*22.13*/("""}"""),format.raw/*22.14*/("""
            """),format.raw/*23.13*/("""h1 """),format.raw/*23.16*/("""{"""),format.raw/*23.17*/("""
                """),format.raw/*24.17*/("""color: white;
                padding-top: 55px;
                padding-left: 55px;
            """),format.raw/*27.13*/("""}"""),format.raw/*27.14*/("""
            """),format.raw/*28.13*/("""form """),format.raw/*28.18*/("""{"""),format.raw/*28.19*/("""
                """),format.raw/*29.17*/("""padding-top: 5%;
                padding-left: 25%;
                padding-right: 20%;
                display: flex;
                flex-flow: row nowrap;
            """),format.raw/*34.13*/("""}"""),format.raw/*34.14*/("""
            """),format.raw/*35.13*/("""input"""),format.raw/*35.18*/("""{"""),format.raw/*35.19*/("""
                """),format.raw/*36.17*/("""height: 45px;
                width: 600px;
            """),format.raw/*38.13*/("""}"""),format.raw/*38.14*/("""

            """),format.raw/*40.13*/("""button """),format.raw/*40.20*/("""{"""),format.raw/*40.21*/("""
                """),format.raw/*41.17*/("""font-family: inherit;
                width: 75px;
                font-size: 16px;
            """),format.raw/*44.13*/("""}"""),format.raw/*44.14*/("""
        """),format.raw/*45.9*/("""</style>
    </head>

    <body>
        <div class="welcomeHeader">
            <h1>Welcome to Gitterific</h1>
        </div>
        <input type="hidden" id="ws-route" value=""""),_display_(/*52.52*/routes/*52.58*/.HomeController.socket.webSocketURL(request)),format.raw/*52.102*/("""">
        <div>
            <form action="/" method="post">
                <input type="text" placeholder="Search.." name="keywords">
                <button type="submit" style="height:45px; width: 60px">search</button>
            </form>
        </div>



        <div class="result">
            """),_display_(/*63.14*/if(searchKeywords != null && searchKeywords.size != 0)/*63.68*/{_display_(Seq[Any](format.raw/*63.69*/("""
                """),_display_(/*64.18*/if(searchKeywords.size() <= 10)/*64.49*/{_display_(Seq[Any](format.raw/*64.50*/("""
                    """),_display_(/*65.22*/for(i <- searchKeywords.size()-1 to 0 by -1) yield /*65.66*/{_display_(Seq[Any](format.raw/*65.67*/("""
                        """),format.raw/*66.25*/("""<br>
                        <p>Search terms: """),_display_(/*67.43*/searchKeywords/*67.57*/.get(i)),format.raw/*67.64*/("""</p>
                        <table style="width:100% table-layout: fixed; word-wrap:break-word; word-break:break-all;">
                            <tr>
                                <th>Author Name</th>
                                <th>Repo Name</th>
                                <th>Topics</th>
                                <th>Create Date</th>
                            </tr>
                            """),_display_(/*75.30*/for(repo <- allRepos.get(i)) yield /*75.58*/{_display_(Seq[Any](format.raw/*75.59*/("""
                                """),format.raw/*76.33*/("""<tr>
                                    <td style="width: 15%">
                                        <a href=""""),_display_(/*78.51*/routes/*78.57*/.HomeController.userProfile(repo.getAuthorName)),format.raw/*78.104*/("""">"""),_display_(/*78.107*/repo/*78.111*/.getAuthorName),format.raw/*78.125*/("""</a>
                                    </td>
                                    <td style="width: 15%">
                                        <a href=""""),_display_(/*81.51*/routes/*81.57*/.HomeController.repos(repo.getAuthorName().replaceAll("\"", ""), repo.getRepoName().replaceAll("\"", ""))),format.raw/*81.162*/("""">"""),_display_(/*81.165*/repo/*81.169*/.getRepoName()),format.raw/*81.183*/("""</a>
                                    </td >
                                    <td style="width: 40%">
                                    """),_display_(/*84.38*/repo/*84.42*/.getTopics()),format.raw/*84.54*/("""
                                    """),format.raw/*85.37*/("""</td>
                                    <td style="width: 30%">
                                    """),_display_(/*87.38*/repo/*87.42*/.getCreatedDate()),format.raw/*87.59*/("""
                                    """),format.raw/*88.37*/("""</td>
                                </tr>
                            """)))}),format.raw/*90.30*/("""
                            """),format.raw/*91.29*/("""<tr id="append"""),_display_(/*91.44*/i),format.raw/*91.45*/(""""></tr>
                        </table>
                    """)))}),format.raw/*93.22*/("""
                """)))}),format.raw/*94.18*/("""
                """),_display_(/*95.18*/if(searchKeywords.size() > 10)/*95.48*/{_display_(Seq[Any](format.raw/*95.49*/("""
                    """),_display_(/*96.22*/for(i <- searchKeywords.size()-1 to searchKeywords.size()-10 by -1) yield /*96.89*/{_display_(Seq[Any](format.raw/*96.90*/("""
                        """),format.raw/*97.25*/("""<br>
                        <p>Search terms: """),_display_(/*98.43*/searchKeywords/*98.57*/.get(i)),format.raw/*98.64*/("""</p>
                        <table style="width:100% table-layout: fixed; word-wrap:break-word; word-break:break-all;">
                            <tr>
                                <th>Author Name</th>
                                <th>Repo Name</th>
                                <th>Topics</th>
                                <th>Create Date</th>
                            </tr>
                            """),_display_(/*106.30*/for(repo <- allRepos.get(i)) yield /*106.58*/{_display_(Seq[Any](format.raw/*106.59*/("""

                                """),format.raw/*108.33*/("""<tr>
                                    <td style="width: 15%">
                                        <a href=""""),_display_(/*110.51*/routes/*110.57*/.HomeController.userProfile(repo.getAuthorName)),format.raw/*110.104*/("""">"""),_display_(/*110.107*/repo/*110.111*/.getAuthorName),format.raw/*110.125*/("""</a>
                                    </td>
                                    <td style="width: 15%">
                                        <a href=""""),_display_(/*113.51*/routes/*113.57*/.HomeController.repos(repo.getAuthorName().replaceAll("\"", ""), repo.getRepoName().replaceAll("\"", ""))),format.raw/*113.162*/("""">"""),_display_(/*113.165*/repo/*113.169*/.getRepoName()),format.raw/*113.183*/("""</a>
                                    </td >
                                    <td style="width: 40%">
                                    """),_display_(/*116.38*/repo/*116.42*/.getTopics()),format.raw/*116.54*/("""
                                    """),format.raw/*117.37*/("""</td>
                                    <td style="width: 30%">
                                    """),_display_(/*119.38*/repo/*119.42*/.getCreatedDate()),format.raw/*119.59*/("""
                                    """),format.raw/*120.37*/("""</td>

                                </tr>
                            """)))}),format.raw/*123.30*/("""
                        """),format.raw/*124.25*/("""</table>
                    """)))}),format.raw/*125.22*/("""
                """)))}),format.raw/*126.18*/("""

            """)))}),format.raw/*128.14*/("""
        """),format.raw/*129.9*/("""</div>
        <script type='text/javascript' src='"""),_display_(/*130.46*/routes/*130.52*/.Assets.at("javascripts/index.js")),format.raw/*130.86*/("""'></script>
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
                  HASH: b5f65a156837a9cafea3b1f5e82badb24507f263
                  MATRIX: 610->1|999->31|1194->133|1221->134|1574->459|1603->460|1648->477|1722->523|1751->524|1792->537|1835->552|1864->553|1909->570|2007->640|2036->641|2077->654|2113->662|2142->663|2187->680|2315->780|2344->781|2385->794|2416->797|2445->798|2490->815|2615->912|2644->913|2685->926|2718->931|2747->932|2792->949|2990->1119|3019->1120|3060->1133|3093->1138|3122->1139|3167->1156|3251->1212|3280->1213|3322->1227|3357->1234|3386->1235|3431->1252|3555->1348|3584->1349|3620->1358|3825->1536|3840->1542|3906->1586|4236->1889|4299->1943|4338->1944|4383->1962|4423->1993|4462->1994|4511->2016|4571->2060|4610->2061|4663->2086|4737->2133|4760->2147|4788->2154|5237->2576|5281->2604|5320->2605|5381->2638|5523->2753|5538->2759|5607->2806|5638->2809|5652->2813|5688->2827|5872->2984|5887->2990|6014->3095|6045->3098|6059->3102|6095->3116|6267->3261|6280->3265|6313->3277|6378->3314|6508->3417|6521->3421|6559->3438|6624->3475|6728->3548|6785->3577|6827->3592|6849->3593|6942->3655|6991->3673|7036->3691|7075->3721|7114->3722|7163->3744|7246->3811|7285->3812|7338->3837|7412->3884|7435->3898|7463->3905|7913->4327|7958->4355|7998->4356|8061->4390|8204->4505|8220->4511|8290->4558|8322->4561|8337->4565|8374->4579|8559->4736|8575->4742|8703->4847|8735->4850|8750->4854|8787->4868|8960->5013|8974->5017|9008->5029|9074->5066|9205->5169|9219->5173|9258->5190|9324->5227|9430->5301|9484->5326|9546->5356|9596->5374|9643->5389|9680->5398|9760->5450|9776->5456|9832->5490
                  LINES: 23->1|28->2|33->3|34->4|41->11|41->11|42->12|43->13|43->13|44->14|44->14|44->14|45->15|47->17|47->17|48->18|48->18|48->18|49->19|52->22|52->22|53->23|53->23|53->23|54->24|57->27|57->27|58->28|58->28|58->28|59->29|64->34|64->34|65->35|65->35|65->35|66->36|68->38|68->38|70->40|70->40|70->40|71->41|74->44|74->44|75->45|82->52|82->52|82->52|93->63|93->63|93->63|94->64|94->64|94->64|95->65|95->65|95->65|96->66|97->67|97->67|97->67|105->75|105->75|105->75|106->76|108->78|108->78|108->78|108->78|108->78|108->78|111->81|111->81|111->81|111->81|111->81|111->81|114->84|114->84|114->84|115->85|117->87|117->87|117->87|118->88|120->90|121->91|121->91|121->91|123->93|124->94|125->95|125->95|125->95|126->96|126->96|126->96|127->97|128->98|128->98|128->98|136->106|136->106|136->106|138->108|140->110|140->110|140->110|140->110|140->110|140->110|143->113|143->113|143->113|143->113|143->113|143->113|146->116|146->116|146->116|147->117|149->119|149->119|149->119|150->120|153->123|154->124|155->125|156->126|158->128|159->129|160->130|160->130|160->130
                  -- GENERATED --
              */
          