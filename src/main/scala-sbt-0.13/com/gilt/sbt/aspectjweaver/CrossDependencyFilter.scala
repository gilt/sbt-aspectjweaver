package com.gilt.sbt.aspectjweaver

import sbt._
import sbt.Keys._
import com.typesafe.sbt.SbtNativePackager._
import com.typesafe.sbt.packager.Keys.bashScriptExtraDefines
import com.typesafe.sbt.packager.archetypes.scripts.BashStartScriptPlugin

trait CrossDependencyFilter {

  val configName = "aspectjweaver-agent"

  val aspectJWeaverFilter: DependencyFilter =
    configurationFilter(configName) && artifactFilter(`type` = "jar")

}
