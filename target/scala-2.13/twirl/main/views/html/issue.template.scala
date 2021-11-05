
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

object issue extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[List[String],HashMap[String, Integer],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(titles : List[String], wordCount : HashMap[String, Integer]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<html>
    <head>
        <title>issues</title>
        <style>
            .row """),format.raw/*7.18*/("""{"""),format.raw/*7.19*/("""
                """),format.raw/*8.17*/("""display: flex;
            """),format.raw/*9.13*/("""}"""),format.raw/*9.14*/("""
            """),format.raw/*10.13*/(""".column """),format.raw/*10.21*/("""{"""),format.raw/*10.22*/("""
                """),format.raw/*11.17*/("""flex: 50%;
            """),format.raw/*12.13*/("""}"""),format.raw/*12.14*/("""
        """),format.raw/*13.9*/("""</style>
    </head>
    <body>

        <div class="row">
            <div class="column">
                """),_display_(/*19.18*/for( (k,v) <- wordCount) yield /*19.42*/{_display_(Seq[Any](format.raw/*19.43*/("""

                """),format.raw/*21.17*/("""<p>Word: """),_display_(/*21.27*/k),format.raw/*21.28*/(""", Count: """),_display_(/*21.38*/v),format.raw/*21.39*/("""</p>

                """)))}),format.raw/*23.18*/("""
            """),format.raw/*24.13*/("""</div>
            <div class="column">
                """),_display_(/*26.18*/for(title <- titles) yield /*26.38*/{_display_(Seq[Any](format.raw/*26.39*/("""
                    """),format.raw/*27.21*/("""<p>title : """),_display_(/*27.33*/title),format.raw/*27.38*/("""</p>
                """)))}),format.raw/*28.18*/("""
            """),format.raw/*29.13*/("""</div>
        </div>

    </body>
</html>"""))
      }
    }
  }

  def render(titles:List[String],wordCount:HashMap[String, Integer]): play.twirl.api.HtmlFormat.Appendable = apply(titles,wordCount)

  def f:((List[String],HashMap[String, Integer]) => play.twirl.api.HtmlFormat.Appendable) = (titles,wordCount) => apply(titles,wordCount)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/issue.scala.html
                  HASH: fc79d62ef6b357685a24e1f8eb5f27b3aae9276a
                  MATRIX: 938->1|1093->63|1120->64|1228->145|1256->146|1300->163|1354->190|1382->191|1423->204|1459->212|1488->213|1533->230|1584->253|1613->254|1649->263|1785->372|1825->396|1864->397|1910->415|1947->425|1969->426|2006->436|2028->437|2082->460|2123->473|2207->530|2243->550|2282->551|2331->572|2370->584|2396->589|2449->611|2490->624
                  LINES: 27->1|32->2|33->3|37->7|37->7|38->8|39->9|39->9|40->10|40->10|40->10|41->11|42->12|42->12|43->13|49->19|49->19|49->19|51->21|51->21|51->21|51->21|51->21|53->23|54->24|56->26|56->26|56->26|57->27|57->27|57->27|58->28|59->29
                  -- GENERATED --
              */
          