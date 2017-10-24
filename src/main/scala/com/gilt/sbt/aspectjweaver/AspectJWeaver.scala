package com.gilt.sbt.aspectjweaver

import sbt._
import com.typesafe.sbt.packager.Keys.bashScriptExtraDefines
import com.typesafe.sbt.packager.archetypes.scripts.BashStartScriptPlugin
import com.typesafe.sbt.SbtNativePackager._
import sbt.Keys.{ivyConfigurations, libraryDependencies, mappings, update}
import sbt.{AutoPlugin, File, UpdateReport, config, settingKey, taskKey}

object AspectJWeaver extends AutoPlugin with CrossDependencyFilter {

  override def requires = BashStartScriptPlugin

  object autoImport {
    val aspectJWeaverVersion = settingKey[String]("AspectJWeaver version")
    val aspectJWeaverAgent = taskKey[File]("AspectJWeaver agent jar location")
  }

  import autoImport._

  val ajConfig = config("aspectjweaver-agent").hide

  override def projectSettings = Seq(
    ivyConfigurations += ajConfig,
    aspectJWeaverVersion := "1.8.10",
    aspectJWeaverAgent := findAspectJWeaverAgent(update.value),
    libraryDependencies += "org.aspectj" % "aspectjweaver" % aspectJWeaverVersion.value % ajConfig,
    mappings in Universal += aspectJWeaverAgent.value -> "aspectjweaver/aspectjweaver.jar",
    bashScriptExtraDefines += """addJava "-javaagent:${app_home}/../aspectjweaver/aspectjweaver.jar""""
  )

  def findAspectJWeaverAgent(report: UpdateReport) = report.matching(aspectJWeaverFilter).head
}
