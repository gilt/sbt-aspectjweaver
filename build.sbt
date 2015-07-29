organization := "com.gilt.sbt"

name := "sbt-aspectjweaver"

sbtPlugin := true

scalacOptions ++= List(
  "-unchecked",
  "-deprecation",
  "-Xlint",
  "-encoding", "UTF-8"
)

javaVersionPrefix in javaVersionCheck := Some("1.7")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.0.3" % "provided")

version := "git describe --tags --dirty --always".!!.stripPrefix("v").trim

publishMavenStyle := false

bintrayOrganization := Some("giltgroupe")

bintrayPackageLabels := Seq("sbt", "aspectj", "aspectjweaver", "sbt-native-packager")

bintrayRepository := "sbt-plugin-releases"

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
