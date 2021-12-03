
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
                        <table id=""""),_display_(/*68.37*/searchKeywords/*68.51*/.get(i)),format.raw/*68.58*/("""" style="width:100% table-layout: fixed; word-wrap:break-word; word-break:break-all;">
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
                        """),format.raw/*91.25*/("""</table>
                    """)))}),format.raw/*92.22*/("""
                """)))}),format.raw/*93.18*/("""
                """),_display_(/*94.18*/if(searchKeywords.size() > 10)/*94.48*/{_display_(Seq[Any](format.raw/*94.49*/("""
                    """),_display_(/*95.22*/for(i <- searchKeywords.size()-1 to searchKeywords.size()-10 by -1) yield /*95.89*/{_display_(Seq[Any](format.raw/*95.90*/("""
                        """),format.raw/*96.25*/("""<br>
                        <p>Search terms: """),_display_(/*97.43*/searchKeywords/*97.57*/.get(i)),format.raw/*97.64*/("""</p>
                        <table style="width:100% table-layout: fixed; word-wrap:break-word; word-break:break-all;">
                            <tr>
                                <th>Author Name</th>
                                <th>Repo Name</th>
                                <th>Topics</th>
                                <th>Create Date</th>
                            </tr>
                            """),_display_(/*105.30*/for(repo <- allRepos.get(i)) yield /*105.58*/{_display_(Seq[Any](format.raw/*105.59*/("""

                                """),format.raw/*107.33*/("""<tr>
                                    <td style="width: 15%">
                                        <a href=""""),_display_(/*109.51*/routes/*109.57*/.HomeController.userProfile(repo.getAuthorName)),format.raw/*109.104*/("""">"""),_display_(/*109.107*/repo/*109.111*/.getAuthorName),format.raw/*109.125*/("""</a>
                                    </td>
                                    <td style="width: 15%">
                                        <a href=""""),_display_(/*112.51*/routes/*112.57*/.HomeController.repos(repo.getAuthorName().replaceAll("\"", ""), repo.getRepoName().replaceAll("\"", ""))),format.raw/*112.162*/("""">"""),_display_(/*112.165*/repo/*112.169*/.getRepoName()),format.raw/*112.183*/("""</a>
                                    </td >
                                    <td style="width: 40%">
                                    """),_display_(/*115.38*/repo/*115.42*/.getTopics()),format.raw/*115.54*/("""
                                    """),format.raw/*116.37*/("""</td>
                                    <td style="width: 30%">
                                    """),_display_(/*118.38*/repo/*118.42*/.getCreatedDate()),format.raw/*118.59*/("""
                                    """),format.raw/*119.37*/("""</td>

                                </tr>
                            """)))}),format.raw/*122.30*/("""
                        """),format.raw/*123.25*/("""</table>
                    """)))}),format.raw/*124.22*/("""
                """)))}),format.raw/*125.18*/("""

            """)))}),format.raw/*127.14*/("""
        """),format.raw/*128.9*/("""</div>
        <script type='text/javascript' src='"""),_display_(/*129.46*/routes/*129.52*/.Assets.at("javascripts/index.js")),format.raw/*129.86*/("""'></script>
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
                  HASH: 19d95075545bc062a49b1df20f869d434ea9228b
                  MATRIX: 610->1|999->31|1194->133|1221->134|1574->459|1603->460|1648->477|1722->523|1751->524|1792->537|1835->552|1864->553|1909->570|2007->640|2036->641|2077->654|2113->662|2142->663|2187->680|2315->780|2344->781|2385->794|2416->797|2445->798|2490->815|2615->912|2644->913|2685->926|2718->931|2747->932|2792->949|2990->1119|3019->1120|3060->1133|3093->1138|3122->1139|3167->1156|3251->1212|3280->1213|3322->1227|3357->1234|3386->1235|3431->1252|3555->1348|3584->1349|3620->1358|3825->1536|3840->1542|3906->1586|4236->1889|4299->1943|4338->1944|4383->1962|4423->1993|4462->1994|4511->2016|4571->2060|4610->2061|4663->2086|4737->2133|4760->2147|4788->2154|4856->2195|4879->2209|4907->2216|5322->2604|5366->2632|5405->2633|5466->2666|5608->2781|5623->2787|5692->2834|5723->2837|5737->2841|5773->2855|5957->3012|5972->3018|6099->3123|6130->3126|6144->3130|6180->3144|6352->3289|6365->3293|6398->3305|6463->3342|6593->3445|6606->3449|6644->3466|6709->3503|6813->3576|6866->3601|6927->3631|6976->3649|7021->3667|7060->3697|7099->3698|7148->3720|7231->3787|7270->3788|7323->3813|7397->3860|7420->3874|7448->3881|7898->4303|7943->4331|7983->4332|8046->4366|8189->4481|8205->4487|8275->4534|8307->4537|8322->4541|8359->4555|8544->4712|8560->4718|8688->4823|8720->4826|8735->4830|8772->4844|8945->4989|8959->4993|8993->5005|9059->5042|9190->5145|9204->5149|9243->5166|9309->5203|9415->5277|9469->5302|9531->5332|9581->5350|9628->5365|9665->5374|9745->5426|9761->5432|9817->5466
                  LINES: 23->1|28->2|33->3|34->4|41->11|41->11|42->12|43->13|43->13|44->14|44->14|44->14|45->15|47->17|47->17|48->18|48->18|48->18|49->19|52->22|52->22|53->23|53->23|53->23|54->24|57->27|57->27|58->28|58->28|58->28|59->29|64->34|64->34|65->35|65->35|65->35|66->36|68->38|68->38|70->40|70->40|70->40|71->41|74->44|74->44|75->45|82->52|82->52|82->52|93->63|93->63|93->63|94->64|94->64|94->64|95->65|95->65|95->65|96->66|97->67|97->67|97->67|98->68|98->68|98->68|105->75|105->75|105->75|106->76|108->78|108->78|108->78|108->78|108->78|108->78|111->81|111->81|111->81|111->81|111->81|111->81|114->84|114->84|114->84|115->85|117->87|117->87|117->87|118->88|120->90|121->91|122->92|123->93|124->94|124->94|124->94|125->95|125->95|125->95|126->96|127->97|127->97|127->97|135->105|135->105|135->105|137->107|139->109|139->109|139->109|139->109|139->109|139->109|142->112|142->112|142->112|142->112|142->112|142->112|145->115|145->115|145->115|146->116|148->118|148->118|148->118|149->119|152->122|153->123|154->124|155->125|157->127|158->128|159->129|159->129|159->129
                  -- GENERATED --
              */
          