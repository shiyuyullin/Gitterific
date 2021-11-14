
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
/*2.2*/import model.Profile_Repo

object users extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Profile,List[Profile_Repo],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(user : Profile, repos : List[Profile_Repo]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.1*/("""

"""),format.raw/*6.1*/("""<html>
    <head>
        <title>User Profile</title>
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
            <h1>User Profile</h1>
        </div>


        <div class="main">
            <table style="margin: auto;">
                <tr>
                    <th>User Login Name</th>
                    <th>"""),_display_(/*55.26*/user/*55.30*/.getLogin),format.raw/*55.39*/("""</th>
                </tr>
                <tr>
                    <th>ID</th>
                    <th>"""),_display_(/*59.26*/user/*59.30*/.getId),format.raw/*59.36*/("""
                """),format.raw/*60.17*/("""</tr>
                <tr>
                    <th>User Name</th>
                    <th>"""),_display_(/*63.26*/user/*63.30*/.getName),format.raw/*63.38*/("""</th>
                </tr>
                <tr>
                    <th>Followers</th>
                    <th>"""),_display_(/*67.26*/user/*67.30*/.getFollowers),format.raw/*67.43*/("""</th>
                </tr>
                <tr>
                    <th>Following</th>
                    <th>"""),_display_(/*71.26*/user/*71.30*/.getFollowing),format.raw/*71.43*/("""</th>
                </tr>
                <tr>
                    <th>User Github Page</th>
                    <th>"""),_display_(/*75.26*/user/*75.30*/.getHtml_url),format.raw/*75.42*/("""</th>
                </tr>
                <tr>
                    <th>Location</th>
                    <th>"""),_display_(/*79.26*/user/*79.30*/.getLocation),format.raw/*79.42*/("""</th>
                </tr>
                <tr>
                    <th>Email</th>
                    <th>"""),_display_(/*83.26*/user/*83.30*/.getEmail),format.raw/*83.39*/("""</th>
                </tr>
                <tr>
                    <th>Company</th>
                    <th>"""),_display_(/*87.26*/user/*87.30*/.getCompany),format.raw/*87.41*/("""</th>
                </tr>
            </table>

            <br /><br />
            <a style="font-size: large">User Repos</a>
            <br /><br />
            <table style="margin: auto; width: 80% ">
                <tr>
                    <th>No.</th>
                    <th>Repo Name</th>
                    <th>isPrivate</th>
                    <th>html_url</th>
                    <th>created_at</th>
                    <th>updated_at</th>
                    <th>pushed_at</th>
                </tr>
                """),_display_(/*104.18*/for(repo <- repos) yield /*104.36*/{_display_(Seq[Any](format.raw/*104.37*/("""
                    """),format.raw/*105.21*/("""<tr>
                        <td class = SortClass></td>
                        <td style="width: 20%">"""),_display_(/*107.49*/repo/*107.53*/.getName),format.raw/*107.61*/("""</td>
                        <td style="width: 10%">"""),_display_(/*108.49*/repo/*108.53*/.getPrivate),format.raw/*108.64*/("""</td>
                        <td style="width: 15%">"""),_display_(/*109.49*/repo/*109.53*/.getHtml_url),format.raw/*109.65*/("""</td>
                        <td style="width: 15%">"""),_display_(/*110.49*/repo/*110.53*/.getCreated_at),format.raw/*110.67*/("""</td>
                        <td style="width: 15%">"""),_display_(/*111.49*/repo/*111.53*/.getUpdated_at),format.raw/*111.67*/("""</td>
                        <td style="width: 15%">"""),_display_(/*112.49*/repo/*112.53*/.getPushed_at),format.raw/*112.66*/("""</td>
                    </tr>
                """)))}),format.raw/*114.18*/("""

            """),format.raw/*116.13*/("""</table>
        </div>

    </body>
</html>"""))
      }
    }
  }

  def render(user:Profile,repos:List[Profile_Repo]): play.twirl.api.HtmlFormat.Appendable = apply(user,repos)

  def f:((Profile,List[Profile_Repo]) => play.twirl.api.HtmlFormat.Appendable) = (user,repos) => apply(user,repos)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/users.scala.html
                  HASH: 0632f7b38f399a8d92438c719896e32606de4852
                  MATRIX: 610->1|638->23|988->50|1126->95|1154->97|1273->188|1302->189|1351->210|1426->257|1455->258|1501->276|1546->293|1575->294|1624->315|1756->419|1785->420|1830->437|1863->442|1892->443|1941->464|2201->696|2230->697|2275->714|2308->719|2337->720|2386->741|2445->772|2474->773|2519->790|2555->798|2584->799|2633->820|2688->847|2717->848|2762->865|2793->868|2822->869|2871->890|3008->999|3037->1000|3082->1017|3125->1032|3154->1033|3203->1054|3309->1132|3338->1133|3374->1142|3680->1421|3693->1425|3723->1434|3856->1540|3869->1544|3896->1550|3941->1567|4059->1658|4072->1662|4101->1670|4241->1783|4254->1787|4288->1800|4428->1913|4441->1917|4475->1930|4622->2050|4635->2054|4668->2066|4807->2178|4820->2182|4853->2194|4989->2303|5002->2307|5032->2316|5170->2427|5183->2431|5215->2442|5780->2979|5815->2997|5855->2998|5905->3019|6038->3124|6052->3128|6082->3136|6164->3190|6178->3194|6211->3205|6293->3259|6307->3263|6341->3275|6423->3329|6437->3333|6473->3347|6555->3401|6569->3405|6605->3419|6687->3473|6701->3477|6736->3490|6817->3539|6860->3553
                  LINES: 23->1|24->2|29->3|34->4|36->6|40->10|40->10|41->11|42->12|42->12|44->14|44->14|44->14|45->15|47->17|47->17|48->18|48->18|48->18|49->19|57->27|57->27|58->28|58->28|58->28|59->29|60->30|60->30|61->31|61->31|61->31|62->32|63->33|63->33|64->34|64->34|64->34|65->35|68->38|68->38|69->39|69->39|69->39|70->40|72->42|72->42|73->43|85->55|85->55|85->55|89->59|89->59|89->59|90->60|93->63|93->63|93->63|97->67|97->67|97->67|101->71|101->71|101->71|105->75|105->75|105->75|109->79|109->79|109->79|113->83|113->83|113->83|117->87|117->87|117->87|134->104|134->104|134->104|135->105|137->107|137->107|137->107|138->108|138->108|138->108|139->109|139->109|139->109|140->110|140->110|140->110|141->111|141->111|141->111|142->112|142->112|142->112|144->114|146->116
                  -- GENERATED --
              */
          