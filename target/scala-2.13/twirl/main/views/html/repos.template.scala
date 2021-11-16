
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
/*1.2*/import model.Repos
/*2.2*/import java.util
/*3.2*/import model.Repo_issues

object repos extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Repos,List[Repo_issues],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(repo : Repos, issues : List[Repo_issues]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.1*/("""
"""),format.raw/*6.1*/("""<!DOCTYPE html>
<html>
    <head>
        <title>Repository</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Mukta&display=swap" rel="stylesheet">
        <style>
                body """),format.raw/*14.22*/("""{"""),format.raw/*14.23*/("""
                    """),format.raw/*15.21*/("""font-family: 'Mukta', sans-serif;
                """),format.raw/*16.17*/("""}"""),format.raw/*16.18*/("""
                """),format.raw/*17.17*/("""tbody"""),format.raw/*17.22*/("""{"""),format.raw/*17.23*/("""
                    """),format.raw/*18.21*/("""counter-reset: sectioncounter;
                """),format.raw/*19.17*/("""}"""),format.raw/*19.18*/("""

                """),format.raw/*21.17*/(""".SortClass:before"""),format.raw/*21.34*/("""{"""),format.raw/*21.35*/("""
                    """),format.raw/*22.21*/("""content:counter(sectioncounter);
                    counter-increment: sectioncounter;
                """),format.raw/*24.17*/("""}"""),format.raw/*24.18*/("""
                """),format.raw/*25.17*/(""".main"""),format.raw/*25.22*/("""{"""),format.raw/*25.23*/("""
                    """),format.raw/*26.21*/("""text-align: center;
                    margin-top: 50px;
                    top: 0;
                    bottom: 0;
                    left: 0;
                    right: 0;
                    font-weight: bold;

                """),format.raw/*34.17*/("""}"""),format.raw/*34.18*/("""
                """),format.raw/*35.17*/(""".row """),format.raw/*35.22*/("""{"""),format.raw/*35.23*/("""
                    """),format.raw/*36.21*/("""display: flex;
                """),format.raw/*37.17*/("""}"""),format.raw/*37.18*/("""
                """),format.raw/*38.17*/(""".column """),format.raw/*38.25*/("""{"""),format.raw/*38.26*/("""
                    """),format.raw/*39.21*/("""flex: 50%;
                """),format.raw/*40.17*/("""}"""),format.raw/*40.18*/("""
                """),format.raw/*41.17*/("""h1 """),format.raw/*41.20*/("""{"""),format.raw/*41.21*/("""
                    """),format.raw/*42.21*/("""color: white;
                    padding-top: 55px;
                    padding-left: 55px;
                """),format.raw/*45.17*/("""}"""),format.raw/*45.18*/("""
                """),format.raw/*46.17*/(""".welcomeHeader """),format.raw/*46.32*/("""{"""),format.raw/*46.33*/("""
                    """),format.raw/*47.21*/("""background-color: #92d13d;
                    height: 150px;
                """),format.raw/*49.17*/("""}"""),format.raw/*49.18*/("""
                """),format.raw/*50.17*/("""table """),format.raw/*50.23*/("""{"""),format.raw/*50.24*/("""
                    """),format.raw/*51.21*/("""margin: auto;
                """),format.raw/*52.17*/("""}"""),format.raw/*52.18*/("""
                """),format.raw/*53.17*/("""th """),format.raw/*53.20*/("""{"""),format.raw/*53.21*/("""
                    """),format.raw/*54.21*/("""padding: 0 1rem;
                """),format.raw/*55.17*/("""}"""),format.raw/*55.18*/("""
                """),format.raw/*56.17*/("""td """),format.raw/*56.20*/("""{"""),format.raw/*56.21*/("""
                    """),format.raw/*57.21*/("""padding: 0 1rem
                """),format.raw/*58.17*/("""}"""),format.raw/*58.18*/("""
                """),format.raw/*59.17*/(""".user-info th """),format.raw/*59.31*/("""{"""),format.raw/*59.32*/("""
                    """),format.raw/*60.21*/("""text-align: end;
                    background-color: #fff7d6;
                """),format.raw/*62.17*/("""}"""),format.raw/*62.18*/("""
                """),format.raw/*63.17*/(""".user-info td """),format.raw/*63.31*/("""{"""),format.raw/*63.32*/("""
                    """),format.raw/*64.21*/("""background-color: #fff7d6;
                """),format.raw/*65.17*/("""}"""),format.raw/*65.18*/("""

                """),format.raw/*67.17*/(""".data-table """),format.raw/*67.29*/("""{"""),format.raw/*67.30*/("""
                    """),format.raw/*68.21*/("""width: 90%;
                """),format.raw/*69.17*/("""}"""),format.raw/*69.18*/("""
                """),format.raw/*70.17*/(""".data-table """),format.raw/*70.29*/("""{"""),format.raw/*70.30*/("""
                    """),format.raw/*71.21*/("""border: 1px solid grey;
                """),format.raw/*72.17*/("""}"""),format.raw/*72.18*/("""
            """),format.raw/*73.13*/("""a """),format.raw/*73.15*/("""{"""),format.raw/*73.16*/("""
                """),format.raw/*74.17*/("""text-decoration: none;
            """),format.raw/*75.13*/("""}"""),format.raw/*75.14*/("""
        """),format.raw/*76.9*/("""</style>
    </head>
    <body>
        <div class="welcomeHeader">
            <h1>Repository</h1>
        </div>


        <div class="main">
            <table class="user-info">
                <tr>
                    <th>Respository Name</th>
                    <td>"""),_display_(/*88.26*/repo/*88.30*/.getRepoName),format.raw/*88.42*/("""</td>
                </tr>
                <tr>
                    <th>ID</th>
                    <td>"""),_display_(/*92.26*/repo/*92.30*/.getID),format.raw/*92.36*/("""</td>
                </tr>
                <tr>
                    <th>Author Name</th>
                    <td>"""),_display_(/*96.26*/repo/*96.30*/.getAuthorName),format.raw/*96.44*/("""</td>
                </tr>
                <tr>
                    <th>Description</th>
                    <td>"""),_display_(/*100.26*/repo/*100.30*/.getDescription),format.raw/*100.45*/("""</td>
                </tr>
                <tr>
                    <th>Topics</th>
                    <td>"""),_display_(/*104.26*/repo/*104.30*/.getTopics),format.raw/*104.40*/("""</td>
                </tr>
                <tr>
                    <th>Visibility</th>
                    <td>"""),_display_(/*108.26*/repo/*108.30*/.getVisibility),format.raw/*108.44*/("""</td>
                </tr>
                <tr>
                    <th>Default Branch</th>
                    <td>"""),_display_(/*112.26*/repo/*112.30*/.getDefault_branch),format.raw/*112.48*/("""</td>
                </tr>
                <tr>
                    <th>Created Date</th>
                    <td>"""),_display_(/*116.26*/repo/*116.30*/.getCreatedDate),format.raw/*116.45*/("""</td>
                </tr>
                <tr>
                    <th>Updated Date</th>
                    <td>"""),_display_(/*120.26*/repo/*120.30*/.getUpdateDate),format.raw/*120.44*/("""</td>
                </tr>
                <tr>
                    <th>Pushed Date</th>
                    <td>"""),_display_(/*124.26*/repo/*124.30*/.getPushedDate),format.raw/*124.44*/("""</td>
                </tr>
            </table>
            <h2>20 Latest Issues</h2>
            <table class="data-table">
                <tr>
                    <th>No.</th>
                    <th>Title</th>
                    <th>User Name</th>
                    <th>Description</th>
                    <th>Created Date</th>
                </tr>
                """),_display_(/*136.18*/for(issue <- issues) yield /*136.38*/{_display_(Seq[Any](format.raw/*136.39*/("""
                    """),format.raw/*137.21*/("""<tr>
                        <td class = SortClass></td>
                        <td style="width: 15%">"""),_display_(/*139.49*/issue/*139.54*/.getIssue_title),format.raw/*139.69*/("""</td>
                        <td style="width: 10%">"""),_display_(/*140.49*/issue/*140.54*/.getIssue_name),format.raw/*140.68*/("""</td>
                        <td style="width: 60%">"""),_display_(/*141.49*/issue/*141.54*/.getIssue_description),format.raw/*141.75*/("""</td>
                        <td style="width: 15%">"""),_display_(/*142.49*/issue/*142.54*/.getIssue_createdDate),format.raw/*142.75*/("""</td>
                    </tr>
                """)))}),format.raw/*144.18*/("""
            """),format.raw/*145.13*/("""</table>


        </div>

        <div>
        <ul>
            <li><a href="/user/"""),_display_(/*152.33*/repo/*152.37*/.getAuthorName),format.raw/*152.51*/("""">User Profile Page</a></li>
            <li><a href="/issue/"""),_display_(/*153.34*/repo/*153.38*/.getAuthorName),format.raw/*153.52*/("""/"""),_display_(/*153.54*/repo/*153.58*/.getRepoName),format.raw/*153.70*/("""">Issues Page</a></li>
        </ul>
        </div>




    </body>
</html>"""))
      }
    }
  }

  def render(repo:Repos,issues:List[Repo_issues]): play.twirl.api.HtmlFormat.Appendable = apply(repo,issues)

  def f:((Repos,List[Repo_issues]) => play.twirl.api.HtmlFormat.Appendable) = (repo,issues) => apply(repo,issues)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/repos.scala.html
                  HASH: dae62a07830fff57902b7e5c3d3f9a27ce55e0ec
                  MATRIX: 610->1|636->21|660->39|1006->65|1142->108|1169->109|1546->458|1575->459|1624->480|1702->530|1731->531|1776->548|1809->553|1838->554|1887->575|1962->622|1991->623|2037->641|2082->658|2111->659|2160->680|2292->784|2321->785|2366->802|2399->807|2428->808|2477->829|2737->1061|2766->1062|2811->1079|2844->1084|2873->1085|2922->1106|2981->1137|3010->1138|3055->1155|3091->1163|3120->1164|3169->1185|3224->1212|3253->1213|3298->1230|3329->1233|3358->1234|3407->1255|3544->1364|3573->1365|3618->1382|3661->1397|3690->1398|3739->1419|3845->1497|3874->1498|3919->1515|3953->1521|3982->1522|4031->1543|4089->1573|4118->1574|4163->1591|4194->1594|4223->1595|4272->1616|4333->1649|4362->1650|4407->1667|4438->1670|4467->1671|4516->1692|4576->1724|4605->1725|4650->1742|4692->1756|4721->1757|4770->1778|4878->1858|4907->1859|4952->1876|4994->1890|5023->1891|5072->1912|5143->1955|5172->1956|5218->1974|5258->1986|5287->1987|5336->2008|5392->2036|5421->2037|5466->2054|5506->2066|5535->2067|5584->2088|5652->2128|5681->2129|5722->2142|5752->2144|5781->2145|5826->2162|5889->2197|5918->2198|5954->2207|6255->2481|6268->2485|6301->2497|6434->2603|6447->2607|6474->2613|6616->2728|6629->2732|6664->2746|6807->2861|6821->2865|6858->2880|6996->2990|7010->2994|7042->3004|7184->3118|7198->3122|7234->3136|7380->3254|7394->3258|7434->3276|7578->3392|7592->3396|7629->3411|7773->3527|7787->3531|7823->3545|7966->3660|7980->3664|8016->3678|8420->4054|8457->4074|8497->4075|8547->4096|8680->4201|8695->4206|8732->4221|8814->4275|8829->4280|8865->4294|8947->4348|8962->4353|9005->4374|9087->4428|9102->4433|9145->4454|9226->4503|9268->4516|9382->4602|9396->4606|9432->4620|9522->4682|9536->4686|9572->4700|9602->4702|9616->4706|9650->4718
                  LINES: 23->1|24->2|25->3|30->4|35->5|36->6|44->14|44->14|45->15|46->16|46->16|47->17|47->17|47->17|48->18|49->19|49->19|51->21|51->21|51->21|52->22|54->24|54->24|55->25|55->25|55->25|56->26|64->34|64->34|65->35|65->35|65->35|66->36|67->37|67->37|68->38|68->38|68->38|69->39|70->40|70->40|71->41|71->41|71->41|72->42|75->45|75->45|76->46|76->46|76->46|77->47|79->49|79->49|80->50|80->50|80->50|81->51|82->52|82->52|83->53|83->53|83->53|84->54|85->55|85->55|86->56|86->56|86->56|87->57|88->58|88->58|89->59|89->59|89->59|90->60|92->62|92->62|93->63|93->63|93->63|94->64|95->65|95->65|97->67|97->67|97->67|98->68|99->69|99->69|100->70|100->70|100->70|101->71|102->72|102->72|103->73|103->73|103->73|104->74|105->75|105->75|106->76|118->88|118->88|118->88|122->92|122->92|122->92|126->96|126->96|126->96|130->100|130->100|130->100|134->104|134->104|134->104|138->108|138->108|138->108|142->112|142->112|142->112|146->116|146->116|146->116|150->120|150->120|150->120|154->124|154->124|154->124|166->136|166->136|166->136|167->137|169->139|169->139|169->139|170->140|170->140|170->140|171->141|171->141|171->141|172->142|172->142|172->142|174->144|175->145|182->152|182->152|182->152|183->153|183->153|183->153|183->153|183->153|183->153
                  -- GENERATED --
              */
          