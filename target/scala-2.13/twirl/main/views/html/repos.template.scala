
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

object repos extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Repos,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(repo : Repos):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""
"""),format.raw/*4.1*/("""<html>
    <head>
        <title>Repository</title>
        <style>
                .row """),format.raw/*8.22*/("""{"""),format.raw/*8.23*/("""
                    """),format.raw/*9.21*/("""display: flex;
                """),format.raw/*10.17*/("""}"""),format.raw/*10.18*/("""
                """),format.raw/*11.17*/(""".column """),format.raw/*11.25*/("""{"""),format.raw/*11.26*/("""
                    """),format.raw/*12.21*/("""flex: 50%;
                """),format.raw/*13.17*/("""}"""),format.raw/*13.18*/("""
                """),format.raw/*14.17*/("""h1 """),format.raw/*14.20*/("""{"""),format.raw/*14.21*/("""
                    """),format.raw/*15.21*/("""color: white;
                    padding-top: 55px;
                    padding-left: 55px;
                """),format.raw/*18.17*/("""}"""),format.raw/*18.18*/("""
                """),format.raw/*19.17*/(""".welcomeHeader """),format.raw/*19.32*/("""{"""),format.raw/*19.33*/("""
                    """),format.raw/*20.21*/("""background-color: #92d13d;
                    height: 150px;
                """),format.raw/*22.17*/("""}"""),format.raw/*22.18*/("""
        """),format.raw/*23.9*/("""</style>
    </head>
    <body>
        <div class="welcomeHeader">
            <h1>Repository</h1>
        </div>


        <div>
            <table>
                <tr>
                    <th>Respository Name</th>
                    <th>"""),_display_(/*35.26*/repo/*35.30*/.getRepoName),format.raw/*35.42*/("""</th>
                </tr>
                <tr>
                    <th>ID</th>
                    <th>"""),_display_(/*39.26*/repo/*39.30*/.getID),format.raw/*39.36*/("""
                """),format.raw/*40.17*/("""</tr>
                <tr>
                    <th>Author Name</th>
                    <th>"""),_display_(/*43.26*/repo/*43.30*/.getAuthorName),format.raw/*43.44*/("""</th>
                </tr>
                <tr>
                    <th>Description</th>
                    <th>"""),_display_(/*47.26*/repo/*47.30*/.getDescription),format.raw/*47.45*/("""</th>
                </tr>
                <tr>
                    <th>Topics</th>
                    <th>"""),_display_(/*51.26*/repo/*51.30*/.getTopics),format.raw/*51.40*/("""</th>
                </tr>
                <tr>
                    <th>Visibility</th>
                    <th>"""),_display_(/*55.26*/repo/*55.30*/.getVisibility),format.raw/*55.44*/("""</th>
                </tr>
                <tr>
                    <th>Default Branch</th>
                    <th>"""),_display_(/*59.26*/repo/*59.30*/.getDefault_branch),format.raw/*59.48*/("""</th>
                </tr>
                <tr>
                    <th>Created Date</th>
                    <th>"""),_display_(/*63.26*/repo/*63.30*/.getCreatedDate),format.raw/*63.45*/("""</th>
                </tr>
                <tr>
                    <th>Updated Date</th>
                    <th>"""),_display_(/*67.26*/repo/*67.30*/.getUpdateDate),format.raw/*67.44*/("""</th>
                </tr>
                <tr>
                    <th>Pushed Date</th>
                    <th>"""),_display_(/*71.26*/repo/*71.30*/.getPushedDate),format.raw/*71.44*/("""</th>
                </tr>


            </table>
        </div>


    </body>
</html>"""))
      }
    }
  }

  def render(repo:Repos): play.twirl.api.HtmlFormat.Appendable = apply(repo)

  def f:((Repos) => play.twirl.api.HtmlFormat.Appendable) = (repo) => apply(repo)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/repos.scala.html
                  HASH: 2f56b1b07a2694d0cc2c9618a90dbf7b2bb5c502
                  MATRIX: 610->1|932->21|1040->36|1067->37|1183->126|1211->127|1259->148|1318->179|1347->180|1392->197|1428->205|1457->206|1506->227|1561->254|1590->255|1635->272|1666->275|1695->276|1744->297|1881->406|1910->407|1955->424|1998->439|2027->440|2076->461|2182->539|2211->540|2247->549|2517->792|2530->796|2563->808|2696->914|2709->918|2736->924|2781->941|2901->1034|2914->1038|2949->1052|3091->1167|3104->1171|3140->1186|3277->1296|3290->1300|3321->1310|3462->1424|3475->1428|3510->1442|3655->1560|3668->1564|3707->1582|3850->1698|3863->1702|3899->1717|4042->1833|4055->1837|4090->1851|4232->1966|4245->1970|4280->1984
                  LINES: 23->1|28->2|33->3|34->4|38->8|38->8|39->9|40->10|40->10|41->11|41->11|41->11|42->12|43->13|43->13|44->14|44->14|44->14|45->15|48->18|48->18|49->19|49->19|49->19|50->20|52->22|52->22|53->23|65->35|65->35|65->35|69->39|69->39|69->39|70->40|73->43|73->43|73->43|77->47|77->47|77->47|81->51|81->51|81->51|85->55|85->55|85->55|89->59|89->59|89->59|93->63|93->63|93->63|97->67|97->67|97->67|101->71|101->71|101->71
                  -- GENERATED --
              */
          