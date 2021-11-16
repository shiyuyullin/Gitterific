
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
                """),_display_(/*51.18*/if(searchKeywords.size() <= 10)/*51.49*/{_display_(Seq[Any](format.raw/*51.50*/("""
                    """),_display_(/*52.22*/for(i <- searchKeywords.size() - 1 to 0 by -1) yield /*52.68*/{_display_(Seq[Any](format.raw/*52.69*/("""
                        """),format.raw/*53.25*/("""<br>
                        <p>Search terms: """),_display_(/*54.43*/searchKeywords/*54.57*/.get(i)),format.raw/*54.64*/("""</p>
                        <table style="width=100% table-layout: fixed; word-wrap:break-word; word-break:break-all;">
                        """),_display_(/*56.26*/for(repo <- allRepos.get(i)) yield /*56.54*/{_display_(Seq[Any](format.raw/*56.55*/("""

                            """),format.raw/*58.29*/("""<tr>
                                <td style="width: 15%">
                                    <a href=""""),_display_(/*60.47*/routes/*60.53*/.HomeController.userProfile(repo.getAuthorName)),format.raw/*60.100*/("""">"""),_display_(/*60.103*/repo/*60.107*/.getAuthorName),format.raw/*60.121*/("""</a>
                                </td>
                                <td style="width: 15%">
                                    <a href=""""),_display_(/*63.47*/routes/*63.53*/.HomeController.repos(repo.getAuthorName().replaceAll("\"", ""), repo.getRepoName().replaceAll("\"", ""))),format.raw/*63.158*/("""">"""),_display_(/*63.161*/repo/*63.165*/.getRepoName()),format.raw/*63.179*/("""</a>
                                </td >
                                <td style="width: 40%">
                                """),_display_(/*66.34*/repo/*66.38*/.getTopics()),format.raw/*66.50*/("""
                                """),format.raw/*67.33*/("""</td>
                                <td style="width: 30%">
                                """),_display_(/*69.34*/repo/*69.38*/.getCreatedDate()),format.raw/*69.55*/("""
                                """),format.raw/*70.33*/("""</td>

                            </tr>
                        """)))}),format.raw/*73.26*/("""
                        """),format.raw/*74.25*/("""</table>
                    """)))}),format.raw/*75.22*/("""
                """)))}),format.raw/*76.18*/("""
                """),_display_(/*77.18*/if(searchKeywords.size() > 10)/*77.48*/{_display_(Seq[Any](format.raw/*77.49*/("""
                    """),_display_(/*78.22*/for(i <- searchKeywords.size() - 1 to searchKeywords.size()-10 by -1) yield /*78.91*/{_display_(Seq[Any](format.raw/*78.92*/("""
                        """),format.raw/*79.25*/("""<br>
                        <p>Search terms: """),_display_(/*80.43*/searchKeywords/*80.57*/.get(i)),format.raw/*80.64*/("""</p>
                        <table style="width=100% table-layout: fixed; word-wrap:break-word; word-break:break-all;">
                        """),_display_(/*82.26*/for(repo <- allRepos.get(i)) yield /*82.54*/{_display_(Seq[Any](format.raw/*82.55*/("""

                            """),format.raw/*84.29*/("""<tr>
                                <td style="width: 15%">
                                    <a href=""""),_display_(/*86.47*/routes/*86.53*/.HomeController.userProfile(repo.getAuthorName)),format.raw/*86.100*/("""">"""),_display_(/*86.103*/repo/*86.107*/.getAuthorName),format.raw/*86.121*/("""</a>
                                </td>
                                <td style="width: 15%">
                                    <a href=""""),_display_(/*89.47*/routes/*89.53*/.HomeController.repos(repo.getAuthorName().replaceAll("\"", ""), repo.getRepoName().replaceAll("\"", ""))),format.raw/*89.158*/("""">"""),_display_(/*89.161*/repo/*89.165*/.getRepoName()),format.raw/*89.179*/("""</a>
                                </td >
                                <td style="width: 40%">
                                """),_display_(/*92.34*/repo/*92.38*/.getTopics()),format.raw/*92.50*/("""
                                """),format.raw/*93.33*/("""</td>
                                <td style="width: 30%">
                                """),_display_(/*95.34*/repo/*95.38*/.getCreatedDate()),format.raw/*95.55*/("""
                                """),format.raw/*96.33*/("""</td>

                            </tr>
                        """)))}),format.raw/*99.26*/("""
                        """),format.raw/*100.25*/("""</table>
                    """)))}),format.raw/*101.22*/("""
                """)))}),format.raw/*102.18*/("""

            """)))}),format.raw/*104.14*/("""
        """),format.raw/*105.9*/("""</div>

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
                  HASH: cec0fea7a564354bc2480343b478cb40aff9ea85
                  MATRIX: 610->1|977->31|1140->101|1167->102|1286->194|1314->195|1359->212|1457->282|1486->283|1527->296|1563->304|1592->305|1637->322|1765->422|1794->423|1835->436|1866->439|1895->440|1940->457|2065->554|2094->555|2135->568|2168->573|2197->574|2242->591|2370->691|2399->692|2440->705|2473->710|2502->711|2547->728|2631->784|2660->785|2696->794|3151->1222|3214->1276|3253->1277|3298->1295|3338->1326|3377->1327|3426->1349|3488->1395|3527->1396|3580->1421|3654->1468|3677->1482|3705->1489|3878->1635|3922->1663|3961->1664|4019->1694|4153->1801|4168->1807|4237->1854|4268->1857|4282->1861|4318->1875|4490->2020|4505->2026|4632->2131|4663->2134|4677->2138|4713->2152|4873->2285|4886->2289|4919->2301|4980->2334|5102->2429|5115->2433|5153->2450|5214->2483|5311->2549|5364->2574|5425->2604|5474->2622|5519->2640|5558->2670|5597->2671|5646->2693|5731->2762|5770->2763|5823->2788|5897->2835|5920->2849|5948->2856|6121->3002|6165->3030|6204->3031|6262->3061|6396->3168|6411->3174|6480->3221|6511->3224|6525->3228|6561->3242|6733->3387|6748->3393|6875->3498|6906->3501|6920->3505|6956->3519|7116->3652|7129->3656|7162->3668|7223->3701|7345->3796|7358->3800|7396->3817|7457->3850|7554->3916|7608->3941|7670->3971|7720->3989|7767->4004|7804->4013
                  LINES: 23->1|28->2|33->3|34->4|39->9|39->9|40->10|42->12|42->12|43->13|43->13|43->13|44->14|47->17|47->17|48->18|48->18|48->18|49->19|52->22|52->22|53->23|53->23|53->23|54->24|57->27|57->27|58->28|58->28|58->28|59->29|61->31|61->31|62->32|80->50|80->50|80->50|81->51|81->51|81->51|82->52|82->52|82->52|83->53|84->54|84->54|84->54|86->56|86->56|86->56|88->58|90->60|90->60|90->60|90->60|90->60|90->60|93->63|93->63|93->63|93->63|93->63|93->63|96->66|96->66|96->66|97->67|99->69|99->69|99->69|100->70|103->73|104->74|105->75|106->76|107->77|107->77|107->77|108->78|108->78|108->78|109->79|110->80|110->80|110->80|112->82|112->82|112->82|114->84|116->86|116->86|116->86|116->86|116->86|116->86|119->89|119->89|119->89|119->89|119->89|119->89|122->92|122->92|122->92|123->93|125->95|125->95|125->95|126->96|129->99|130->100|131->101|132->102|134->104|135->105
                  -- GENERATED --
              */
          