package com.gilt.sbt.aspectjweaver

import sbt._
import sbt.Keys._
import com.typesafe.sbt.SbtNativePackager._
import com.typesafe.sbt.packager.Keys.bashScriptExtraDefines
import com.typesafe.sbt.packager.archetypes.scripts.BashStartScriptPlugin

trait CrossDependencyFilter {
  val aspectJWeaverFilter: DependencyFilter =
    configurationFilter("aspectjweaver-agent") && artifactFilter(`type` = "jar")

}
