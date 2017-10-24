package com.gilt.sbt.aspectjweaver

import sbt._
import sbt.librarymanagement.DependencyFilter

trait CrossDependencyFilter {

  val aspectJWeaverFilter: DependencyFilter =
    configurationFilter("aspectjweaver-agent") && artifactFilter(`type` = "jar")
}
