package com.gilt.sbt.aspectjweaver

import sbt._
import sbt.librarymanagement.DependencyFilter

trait CrossDependencyFilter {

  val configName = "Aspectjweaver-agent"

  val aspectJWeaverFilter: DependencyFilter =
    configurationFilter(configName) && artifactFilter(`type` = "jar")
}
