enablePlugins(GitVersioning)

git.useGitDescribe := true

organization := "com.gilt.sbt"

crossSbtVersions := Vector("0.13.16", "1.0.1")

name := "sbt-aspectjweaver"

sbtPlugin := true

scalacOptions ++= List(
  "-unchecked",
  "-deprecation",
  "-Xlint",
  "-encoding", "UTF-8"
)

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.0" % "provided")

publishMavenStyle := false

bintrayOrganization := Some("giltgroupe")

bintrayPackageLabels := Seq("sbt", "aspectj", "aspectjweaver", "sbt-native-packager")

bintrayRepository := "sbt-plugin-releases"

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
