
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
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Mukta&display=swap" rel="stylesheet">
        <style>
                body """),format.raw/*13.22*/("""{"""),format.raw/*13.23*/("""
                    """),format.raw/*14.21*/("""font-family: 'Mukta', sans-serif;
                """),format.raw/*15.17*/("""}"""),format.raw/*15.18*/("""
                """),format.raw/*16.17*/("""tbody """),format.raw/*16.23*/("""{"""),format.raw/*16.24*/("""
                    """),format.raw/*17.21*/("""counter-reset: sectioncounter;
                """),format.raw/*18.17*/("""}"""),format.raw/*18.18*/("""
                """),format.raw/*19.17*/(""".main"""),format.raw/*19.22*/("""{"""),format.raw/*19.23*/("""
                    """),format.raw/*20.21*/("""text-align: center;
                    margin-top: 50px;
                    top: 0;
                    bottom: 0;
                    left: 0;
                    right: 0;
                    font-weight: bold;

                """),format.raw/*28.17*/("""}"""),format.raw/*28.18*/("""
                """),format.raw/*29.17*/(""".row """),format.raw/*29.22*/("""{"""),format.raw/*29.23*/("""
                    """),format.raw/*30.21*/("""display: flex;
                """),format.raw/*31.17*/("""}"""),format.raw/*31.18*/("""
                """),format.raw/*32.17*/(""".column """),format.raw/*32.25*/("""{"""),format.raw/*32.26*/("""
                    """),format.raw/*33.21*/("""flex: 50%;
                """),format.raw/*34.17*/("""}"""),format.raw/*34.18*/("""
                """),format.raw/*35.17*/("""h1 """),format.raw/*35.20*/("""{"""),format.raw/*35.21*/("""
                    """),format.raw/*36.21*/("""color: white;
                    padding-top: 55px;
                    padding-left: 55px;
                """),format.raw/*39.17*/("""}"""),format.raw/*39.18*/("""
                """),format.raw/*40.17*/(""".welcomeHeader """),format.raw/*40.32*/("""{"""),format.raw/*40.33*/("""
                    """),format.raw/*41.21*/("""background-color: #92d13d;
                    height: 150px;
                """),format.raw/*43.17*/("""}"""),format.raw/*43.18*/("""
            """),format.raw/*44.13*/("""table """),format.raw/*44.19*/("""{"""),format.raw/*44.20*/("""
                """),format.raw/*45.17*/("""margin: auto;
            """),format.raw/*46.13*/("""}"""),format.raw/*46.14*/("""
            """),format.raw/*47.13*/("""th """),format.raw/*47.16*/("""{"""),format.raw/*47.17*/("""
                """),format.raw/*48.17*/("""padding: 0 1rem;
            """),format.raw/*49.13*/("""}"""),format.raw/*49.14*/("""
            """),format.raw/*50.13*/("""td """),format.raw/*50.16*/("""{"""),format.raw/*50.17*/("""
                """),format.raw/*51.17*/("""padding: 0 1rem
            """),format.raw/*52.13*/("""}"""),format.raw/*52.14*/("""
            """),format.raw/*53.13*/(""".user-info th """),format.raw/*53.27*/("""{"""),format.raw/*53.28*/("""
                """),format.raw/*54.17*/("""text-align: end;
                background-color: #fff7d6;
            """),format.raw/*56.13*/("""}"""),format.raw/*56.14*/("""
            """),format.raw/*57.13*/(""".user-info td """),format.raw/*57.27*/("""{"""),format.raw/*57.28*/("""
                """),format.raw/*58.17*/("""background-color: #fff7d6;
            """),format.raw/*59.13*/("""}"""),format.raw/*59.14*/("""

            """),format.raw/*61.13*/(""".data-table """),format.raw/*61.25*/("""{"""),format.raw/*61.26*/("""
                """),format.raw/*62.17*/("""width: 90%;
            """),format.raw/*63.13*/("""}"""),format.raw/*63.14*/("""
            """),format.raw/*64.13*/(""".data-table """),format.raw/*64.25*/("""{"""),format.raw/*64.26*/("""
                """),format.raw/*65.17*/("""border: 1px solid grey;
            """),format.raw/*66.13*/("""}"""),format.raw/*66.14*/("""
                """),format.raw/*67.17*/(""".SortClass:before"""),format.raw/*67.34*/("""{"""),format.raw/*67.35*/("""
                    """),format.raw/*68.21*/("""content:counter(sectioncounter);
                    counter-increment: sectioncounter;
                """),format.raw/*70.17*/("""}"""),format.raw/*70.18*/("""
        """),format.raw/*71.9*/("""</style>
    </head>
    <body>
        <div class="welcomeHeader">
            <h1>User Profile</h1>
        </div>


        <div class="main">
            <table class="user-info">
                <tr>
                    <th>User Login Name</th>
                    <td>"""),_display_(/*83.26*/user/*83.30*/.getLogin),format.raw/*83.39*/("""</td>
                </tr>
                <tr>
                    <th>ID</th>
                    <td>"""),_display_(/*87.26*/user/*87.30*/.getId),format.raw/*87.36*/("""</td>
                </tr>
                <tr>
                    <th>User Name</th>
                    <td>"""),_display_(/*91.26*/user/*91.30*/.getName),format.raw/*91.38*/("""</td>
                </tr>
                <tr>
                    <th>Followers</th>
                    <td>"""),_display_(/*95.26*/user/*95.30*/.getFollowers),format.raw/*95.43*/("""</td>
                </tr>
                <tr>
                    <th>Following</th>
                    <td>"""),_display_(/*99.26*/user/*99.30*/.getFollowing),format.raw/*99.43*/("""</td>
                </tr>
                <tr>
                    <th>User Github Page</th>
                    <td>"""),_display_(/*103.26*/user/*103.30*/.getHtml_url),format.raw/*103.42*/("""</td>
                </tr>
                <tr>
                    <th>Location</th>
                    <td>"""),_display_(/*107.26*/user/*107.30*/.getLocation),format.raw/*107.42*/("""</td>
                </tr>
                <tr>
                    <th>Email</th>
                    <td>"""),_display_(/*111.26*/user/*111.30*/.getEmail),format.raw/*111.39*/("""</td>
                </tr>
                <tr>
                    <th>Company</th>
                    <td>"""),_display_(/*115.26*/user/*115.30*/.getCompany),format.raw/*115.41*/("""</td>
                </tr>
            </table>

            <h2>User Repos</h2>
            <table class="data-table">
                <tr>
                    <th>No.</th>
                    <th>Repo Name</th>
                    <th>isPrivate</th>
                    <th>html_url</th>
                    <th>created_at</th>
                    <th>updated_at</th>
                    <th>pushed_at</th>
                </tr>
                """),_display_(/*130.18*/for(repo <- repos) yield /*130.36*/{_display_(Seq[Any](format.raw/*130.37*/("""
                    """),format.raw/*131.21*/("""<tr>
                        <td class = SortClass></td>
                        <td style="width: 20%">"""),_display_(/*133.49*/repo/*133.53*/.getName),format.raw/*133.61*/("""</td>
                        <td style="width: 10%">"""),_display_(/*134.49*/repo/*134.53*/.getPrivate),format.raw/*134.64*/("""</td>
                        <td style="width: 15%">"""),_display_(/*135.49*/repo/*135.53*/.getHtml_url),format.raw/*135.65*/("""</td>
                        <td style="width: 15%">"""),_display_(/*136.49*/repo/*136.53*/.getCreated_at),format.raw/*136.67*/("""</td>
                        <td style="width: 15%">"""),_display_(/*137.49*/repo/*137.53*/.getUpdated_at),format.raw/*137.67*/("""</td>
                        <td style="width: 15%">"""),_display_(/*138.49*/repo/*138.53*/.getPushed_at),format.raw/*138.66*/("""</td>
                    </tr>
                """)))}),format.raw/*140.18*/("""

            """),format.raw/*142.13*/("""</table>
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
                  HASH: f88a73018ccb427444518373b25a73dddc57d308
                  MATRIX: 610->1|638->23|988->50|1126->95|1154->97|1517->432|1546->433|1595->454|1673->504|1702->505|1747->522|1781->528|1810->529|1859->550|1934->597|1963->598|2008->615|2041->620|2070->621|2119->642|2379->874|2408->875|2453->892|2486->897|2515->898|2564->919|2623->950|2652->951|2697->968|2733->976|2762->977|2811->998|2866->1025|2895->1026|2940->1043|2971->1046|3000->1047|3049->1068|3186->1177|3215->1178|3260->1195|3303->1210|3332->1211|3381->1232|3487->1310|3516->1311|3557->1324|3591->1330|3620->1331|3665->1348|3719->1374|3748->1375|3789->1388|3820->1391|3849->1392|3894->1409|3951->1438|3980->1439|4021->1452|4052->1455|4081->1456|4126->1473|4182->1501|4211->1502|4252->1515|4294->1529|4323->1530|4368->1547|4468->1619|4497->1620|4538->1633|4580->1647|4609->1648|4654->1665|4721->1704|4750->1705|4792->1719|4832->1731|4861->1732|4906->1749|4958->1773|4987->1774|5028->1787|5068->1799|5097->1800|5142->1817|5206->1853|5235->1854|5280->1871|5325->1888|5354->1889|5403->1910|5535->2014|5564->2015|5600->2024|5902->2299|5915->2303|5945->2312|6078->2418|6091->2422|6118->2428|6258->2541|6271->2545|6300->2553|6440->2666|6453->2670|6487->2683|6627->2796|6640->2800|6674->2813|6822->2933|6836->2937|6870->2949|7010->3061|7024->3065|7058->3077|7195->3186|7209->3190|7240->3199|7379->3310|7393->3314|7426->3325|7903->3774|7938->3792|7978->3793|8028->3814|8161->3919|8175->3923|8205->3931|8287->3985|8301->3989|8334->4000|8416->4054|8430->4058|8464->4070|8546->4124|8560->4128|8596->4142|8678->4196|8692->4200|8728->4214|8810->4268|8824->4272|8859->4285|8940->4334|8983->4348
                  LINES: 23->1|24->2|29->3|34->4|36->6|43->13|43->13|44->14|45->15|45->15|46->16|46->16|46->16|47->17|48->18|48->18|49->19|49->19|49->19|50->20|58->28|58->28|59->29|59->29|59->29|60->30|61->31|61->31|62->32|62->32|62->32|63->33|64->34|64->34|65->35|65->35|65->35|66->36|69->39|69->39|70->40|70->40|70->40|71->41|73->43|73->43|74->44|74->44|74->44|75->45|76->46|76->46|77->47|77->47|77->47|78->48|79->49|79->49|80->50|80->50|80->50|81->51|82->52|82->52|83->53|83->53|83->53|84->54|86->56|86->56|87->57|87->57|87->57|88->58|89->59|89->59|91->61|91->61|91->61|92->62|93->63|93->63|94->64|94->64|94->64|95->65|96->66|96->66|97->67|97->67|97->67|98->68|100->70|100->70|101->71|113->83|113->83|113->83|117->87|117->87|117->87|121->91|121->91|121->91|125->95|125->95|125->95|129->99|129->99|129->99|133->103|133->103|133->103|137->107|137->107|137->107|141->111|141->111|141->111|145->115|145->115|145->115|160->130|160->130|160->130|161->131|163->133|163->133|163->133|164->134|164->134|164->134|165->135|165->135|165->135|166->136|166->136|166->136|167->137|167->137|167->137|168->138|168->138|168->138|170->140|172->142
                  -- GENERATED --
              */
          