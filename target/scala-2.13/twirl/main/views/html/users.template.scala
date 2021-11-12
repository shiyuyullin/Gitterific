
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
/*1.2*/import model.Profile

object users extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Profile,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(user : Profile ):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""
"""),format.raw/*4.1*/("""<html>
    <head>
        <title>User Profile</title>
        <style>
                tbody"""),format.raw/*8.22*/("""{"""),format.raw/*8.23*/("""
                    """),format.raw/*9.21*/("""counter-reset: sectioncounter;
                """),format.raw/*10.17*/("""}"""),format.raw/*10.18*/("""

                """),format.raw/*12.17*/(""".SortClass:before"""),format.raw/*12.34*/("""{"""),format.raw/*12.35*/("""
                    """),format.raw/*13.21*/("""content:counter(sectioncounter);
                    counter-increment: sectioncounter;
                """),format.raw/*15.17*/("""}"""),format.raw/*15.18*/("""
                """),format.raw/*16.17*/(""".main"""),format.raw/*16.22*/("""{"""),format.raw/*16.23*/("""
                    """),format.raw/*17.21*/("""text-align: center;
                    margin-top: 50px;
                    top: 0;
                    bottom: 0;
                    left: 0;
                    right: 0;
                    font-weight: bold;

                """),format.raw/*25.17*/("""}"""),format.raw/*25.18*/("""
                """),format.raw/*26.17*/(""".row """),format.raw/*26.22*/("""{"""),format.raw/*26.23*/("""
                    """),format.raw/*27.21*/("""display: flex;
                """),format.raw/*28.17*/("""}"""),format.raw/*28.18*/("""
                """),format.raw/*29.17*/(""".column """),format.raw/*29.25*/("""{"""),format.raw/*29.26*/("""
                    """),format.raw/*30.21*/("""flex: 50%;
                """),format.raw/*31.17*/("""}"""),format.raw/*31.18*/("""
                """),format.raw/*32.17*/("""h1 """),format.raw/*32.20*/("""{"""),format.raw/*32.21*/("""
                    """),format.raw/*33.21*/("""color: white;
                    padding-top: 55px;
                    padding-left: 55px;
                """),format.raw/*36.17*/("""}"""),format.raw/*36.18*/("""
                """),format.raw/*37.17*/(""".welcomeHeader """),format.raw/*37.32*/("""{"""),format.raw/*37.33*/("""
                    """),format.raw/*38.21*/("""background-color: #92d13d;
                    height: 150px;
                """),format.raw/*40.17*/("""}"""),format.raw/*40.18*/("""
        """),format.raw/*41.9*/("""</style>
    </head>
    <body>
        <div class="welcomeHeader">
            <h1>User Profile</h1>
        </div>


        <div class="main">
            <table style="margin: auto;">
                <tr>
                    <th>User Login Name</th>
                    <th>"""),_display_(/*53.26*/user/*53.30*/.getId),format.raw/*53.36*/("""</th>
                </tr>
                <tr>
                    <th>ID</th>
                    <th>"""),_display_(/*57.26*/user/*57.30*/.getId),format.raw/*57.36*/("""
                """),format.raw/*58.17*/("""</tr>
                <tr>
                    <th>User Name</th>
                    <th>"""),_display_(/*61.26*/user/*61.30*/.getName),format.raw/*61.38*/("""</th>
                </tr>
                <tr>
                    <th>Followers</th>
                    <th>"""),_display_(/*65.26*/user/*65.30*/.getFollowers),format.raw/*65.43*/("""</th>
                </tr>
                <tr>
                    <th>Following</th>
                    <th>"""),_display_(/*69.26*/user/*69.30*/.getFollowing),format.raw/*69.43*/("""</th>
                </tr>
                <tr>
                    <th>User Github Page</th>
                    <th>"""),_display_(/*73.26*/user/*73.30*/.getHtml_url),format.raw/*73.42*/("""</th>
                </tr>
                <tr>
                    <th>Location</th>
                    <th>"""),_display_(/*77.26*/user/*77.30*/.getLocation),format.raw/*77.42*/("""</th>
                </tr>
                <tr>
                    <th>Email</th>
                    <th>"""),_display_(/*81.26*/user/*81.30*/.getEmail),format.raw/*81.39*/("""</th>
                </tr>
                <tr>
                    <th>Company</th>
                    <th>"""),_display_(/*85.26*/user/*85.30*/.getCompany),format.raw/*85.41*/("""</th>
                </tr>
            </table>
        </div>

    </body>
</html>"""))
      }
    }
  }

  def render(user:Profile): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((Profile) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/users.scala.html
                  HASH: ffd0b40dc33e3ae27d9136d72b680643756a8bca
                  MATRIX: 610->1|936->23|1047->41|1074->42|1192->133|1220->134|1268->155|1343->202|1372->203|1418->221|1463->238|1492->239|1541->260|1673->364|1702->365|1747->382|1780->387|1809->388|1858->409|2118->641|2147->642|2192->659|2225->664|2254->665|2303->686|2362->717|2391->718|2436->735|2472->743|2501->744|2550->765|2605->792|2634->793|2679->810|2710->813|2739->814|2788->835|2925->944|2954->945|2999->962|3042->977|3071->978|3120->999|3226->1077|3255->1078|3291->1087|3597->1366|3610->1370|3637->1376|3770->1482|3783->1486|3810->1492|3855->1509|3973->1600|3986->1604|4015->1612|4155->1725|4168->1729|4202->1742|4342->1855|4355->1859|4389->1872|4536->1992|4549->1996|4582->2008|4721->2120|4734->2124|4767->2136|4903->2245|4916->2249|4946->2258|5084->2369|5097->2373|5129->2384
                  LINES: 23->1|28->2|33->3|34->4|38->8|38->8|39->9|40->10|40->10|42->12|42->12|42->12|43->13|45->15|45->15|46->16|46->16|46->16|47->17|55->25|55->25|56->26|56->26|56->26|57->27|58->28|58->28|59->29|59->29|59->29|60->30|61->31|61->31|62->32|62->32|62->32|63->33|66->36|66->36|67->37|67->37|67->37|68->38|70->40|70->40|71->41|83->53|83->53|83->53|87->57|87->57|87->57|88->58|91->61|91->61|91->61|95->65|95->65|95->65|99->69|99->69|99->69|103->73|103->73|103->73|107->77|107->77|107->77|111->81|111->81|111->81|115->85|115->85|115->85
                  -- GENERATED --
              */
          