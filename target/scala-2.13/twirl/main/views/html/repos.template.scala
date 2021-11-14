
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
"""),format.raw/*6.1*/("""<html>
    <head>
        <title>Repository</title>
        <style>
                tbody"""),format.raw/*10.22*/("""{"""),format.raw/*10.23*/("""
                    """),format.raw/*11.21*/("""counter-reset: sectioncounter;
                """),format.raw/*12.17*/("""}"""),format.raw/*12.18*/("""

                """),format.raw/*14.17*/(""".SortClass:before"""),format.raw/*14.34*/("""{"""),format.raw/*14.35*/("""
                    """),format.raw/*15.21*/("""content:counter(sectioncounter);
                    counter-increment: sectioncounter;
                """),format.raw/*17.17*/("""}"""),format.raw/*17.18*/("""
                """),format.raw/*18.17*/(""".main"""),format.raw/*18.22*/("""{"""),format.raw/*18.23*/("""
                    """),format.raw/*19.21*/("""text-align: center;
                    margin-top: 50px;
                    top: 0;
                    bottom: 0;
                    left: 0;
                    right: 0;
                    font-weight: bold;

                """),format.raw/*27.17*/("""}"""),format.raw/*27.18*/("""
                """),format.raw/*28.17*/(""".row """),format.raw/*28.22*/("""{"""),format.raw/*28.23*/("""
                    """),format.raw/*29.21*/("""display: flex;
                """),format.raw/*30.17*/("""}"""),format.raw/*30.18*/("""
                """),format.raw/*31.17*/(""".column """),format.raw/*31.25*/("""{"""),format.raw/*31.26*/("""
                    """),format.raw/*32.21*/("""flex: 50%;
                """),format.raw/*33.17*/("""}"""),format.raw/*33.18*/("""
                """),format.raw/*34.17*/("""h1 """),format.raw/*34.20*/("""{"""),format.raw/*34.21*/("""
                    """),format.raw/*35.21*/("""color: white;
                    padding-top: 55px;
                    padding-left: 55px;
                """),format.raw/*38.17*/("""}"""),format.raw/*38.18*/("""
                """),format.raw/*39.17*/(""".welcomeHeader """),format.raw/*39.32*/("""{"""),format.raw/*39.33*/("""
                    """),format.raw/*40.21*/("""background-color: #92d13d;
                    height: 150px;
                """),format.raw/*42.17*/("""}"""),format.raw/*42.18*/("""
        """),format.raw/*43.9*/("""</style>
    </head>
    <body>
        <div class="welcomeHeader">
            <h1>Repository</h1>
        </div>


        <div class="main">
            <table style="margin: auto;">
                <tr>
                    <th>Respository Name</th>
                    <th>"""),_display_(/*55.26*/repo/*55.30*/.getRepoName),format.raw/*55.42*/("""</th>
                </tr>
                <tr>
                    <th>ID</th>
                    <th>"""),_display_(/*59.26*/repo/*59.30*/.getID),format.raw/*59.36*/("""
                """),format.raw/*60.17*/("""</tr>
                <tr>
                    <th>Author Name</th>
                    <th>"""),_display_(/*63.26*/repo/*63.30*/.getAuthorName),format.raw/*63.44*/("""</th>
                </tr>
                <tr>
                    <th>Description</th>
                    <th>"""),_display_(/*67.26*/repo/*67.30*/.getDescription),format.raw/*67.45*/("""</th>
                </tr>
                <tr>
                    <th>Topics</th>
                    <th>"""),_display_(/*71.26*/repo/*71.30*/.getTopics),format.raw/*71.40*/("""</th>
                </tr>
                <tr>
                    <th>Visibility</th>
                    <th>"""),_display_(/*75.26*/repo/*75.30*/.getVisibility),format.raw/*75.44*/("""</th>
                </tr>
                <tr>
                    <th>Default Branch</th>
                    <th>"""),_display_(/*79.26*/repo/*79.30*/.getDefault_branch),format.raw/*79.48*/("""</th>
                </tr>
                <tr>
                    <th>Created Date</th>
                    <th>"""),_display_(/*83.26*/repo/*83.30*/.getCreatedDate),format.raw/*83.45*/("""</th>
                </tr>
                <tr>
                    <th>Updated Date</th>
                    <th>"""),_display_(/*87.26*/repo/*87.30*/.getUpdateDate),format.raw/*87.44*/("""</th>
                </tr>
                <tr>
                    <th>Pushed Date</th>
                    <th>"""),_display_(/*91.26*/repo/*91.30*/.getPushedDate),format.raw/*91.44*/("""</th>
                </tr>


            </table>
            <br /><br />
            <a style="font-size: large">20 Latest Issues</a>
            <br /><br />
            <table style="margin: auto; width: 80% ">
                <tr>
                    <th>No.</th>
                    <th>Title</th>
                    <th>User Name</th>
                    <th>Description</th>
                    <th>Created Date</th>
                </tr>
                """),_display_(/*107.18*/for(issue <- issues) yield /*107.38*/{_display_(Seq[Any](format.raw/*107.39*/("""
                    """),format.raw/*108.21*/("""<tr>
                        <td class = SortClass></td>
                        <td style="width: 15%">"""),_display_(/*110.49*/issue/*110.54*/.getIssue_title),format.raw/*110.69*/("""</td>
                        <td style="width: 10%">"""),_display_(/*111.49*/issue/*111.54*/.getIssue_name),format.raw/*111.68*/("""</td>
                        <td style="width: 60%">"""),_display_(/*112.49*/issue/*112.54*/.getIssue_description),format.raw/*112.75*/("""</td>
                        <td style="width: 15%">"""),_display_(/*113.49*/issue/*113.54*/.getIssue_createdDate),format.raw/*113.75*/("""</td>
                    </tr>
                """)))}),format.raw/*115.18*/("""
            """),format.raw/*116.13*/("""</table>


        </div>

        <div>
        <a style="text-align: left; margin-left:10%" href="/user/"""),_display_(/*122.67*/repo/*122.71*/.getAuthorName),format.raw/*122.85*/("""">User Profile Page</a>
        <a style="text-align: left; margin-left:10%" href="/issue/"""),_display_(/*123.68*/repo/*123.72*/.getAuthorName),format.raw/*123.86*/("""/"""),_display_(/*123.88*/repo/*123.92*/.getRepoName),format.raw/*123.104*/("""">Issues Page</a>
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
                  HASH: 5f9cb09066daf72c10be5a394e5a2b2734953d46
                  MATRIX: 610->1|636->21|660->39|1006->65|1142->108|1169->109|1286->198|1315->199|1364->220|1439->267|1468->268|1514->286|1559->303|1588->304|1637->325|1769->429|1798->430|1843->447|1876->452|1905->453|1954->474|2214->706|2243->707|2288->724|2321->729|2350->730|2399->751|2458->782|2487->783|2532->800|2568->808|2597->809|2646->830|2701->857|2730->858|2775->875|2806->878|2835->879|2884->900|3021->1009|3050->1010|3095->1027|3138->1042|3167->1043|3216->1064|3322->1142|3351->1143|3387->1152|3692->1430|3705->1434|3738->1446|3871->1552|3884->1556|3911->1562|3956->1579|4076->1672|4089->1676|4124->1690|4266->1805|4279->1809|4315->1824|4452->1934|4465->1938|4496->1948|4637->2062|4650->2066|4685->2080|4830->2198|4843->2202|4882->2220|5025->2336|5038->2340|5074->2355|5217->2471|5230->2475|5265->2489|5407->2604|5420->2608|5455->2622|5949->3088|5986->3108|6026->3109|6076->3130|6209->3235|6224->3240|6261->3255|6343->3309|6358->3314|6394->3328|6476->3382|6491->3387|6534->3408|6616->3462|6631->3467|6674->3488|6755->3537|6797->3550|6932->3657|6946->3661|6982->3675|7101->3766|7115->3770|7151->3784|7181->3786|7195->3790|7230->3802
                  LINES: 23->1|24->2|25->3|30->4|35->5|36->6|40->10|40->10|41->11|42->12|42->12|44->14|44->14|44->14|45->15|47->17|47->17|48->18|48->18|48->18|49->19|57->27|57->27|58->28|58->28|58->28|59->29|60->30|60->30|61->31|61->31|61->31|62->32|63->33|63->33|64->34|64->34|64->34|65->35|68->38|68->38|69->39|69->39|69->39|70->40|72->42|72->42|73->43|85->55|85->55|85->55|89->59|89->59|89->59|90->60|93->63|93->63|93->63|97->67|97->67|97->67|101->71|101->71|101->71|105->75|105->75|105->75|109->79|109->79|109->79|113->83|113->83|113->83|117->87|117->87|117->87|121->91|121->91|121->91|137->107|137->107|137->107|138->108|140->110|140->110|140->110|141->111|141->111|141->111|142->112|142->112|142->112|143->113|143->113|143->113|145->115|146->116|152->122|152->122|152->122|153->123|153->123|153->123|153->123|153->123|153->123
                  -- GENERATED --
              */
          