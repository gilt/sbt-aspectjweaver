package com.gilt.sbt.aspectjweaver

import sbt._
import sbt.Keys._

import com.typesafe.sbt.SbtNativePackager._
import com.typesafe.sbt.packager.archetypes.JavaAppPackaging
import com.typesafe.sbt.packager.archetypes.JavaAppPackaging.autoImport.bashScriptExtraDefines

object AspectJWeaver extends AutoPlugin {
  object autoImport {
    val aspectJWeaverVersion = settingKey[String]("AspectJWeaver version")
    val aspectJWeaverAgent = taskKey[File]("AspectJWeaver agent jar location")
  }

  import autoImport._

  override def requires = JavaAppPackaging

  val ajConfig = config("aspectjweaver-agent").hide

  override lazy val projectSettings = Seq(
    ivyConfigurations += ajConfig,
    aspectJWeaverVersion := "1.8.8",
    aspectJWeaverAgent := findAspectJWeaverAgent(update.value),
    libraryDependencies += "org.aspectj" % "aspectjweaver" % aspectJWeaverVersion.value % ajConfig,
    mappings in Universal += aspectJWeaverAgent.value -> "aspectjweaver/aspectjweaver.jar",
    bashScriptExtraDefines += """addJava "-javaagent:${app_home}/../aspectjweaver/aspectjweaver.jar""""
  )

  private[this] val aspectJWeaverFilter: DependencyFilter =
    configurationFilter("aspectjweaver-agent") && artifactFilter(`type` = "jar")

  def findAspectJWeaverAgent(report: UpdateReport) = report.matching(aspectJWeaverFilter).head
}
