sbt-aspectjweaver
=================

Adds the AspectJ Weaver JAR to builds using sbt-native-packager.

This is part of the AspectJ project at https://eclipse.org/aspectj/

It adds the Weaver JAR as a Java agent at startup time, allowing
for weaving of pointcuts into Java bytecode at startup.

Prerequisites
-------------
The plugin assumes that sbt-native-packager has been included in your SBT build configuration.

Installation
------------

Use the appropriate version for Play/SBT Native Packager:

|Play | SBT Native Packager | Plugin |
|-----|---------------------|--------|
|2.4  |1.0.x                |0.0.2   |
|2.6  |1.2.x                |0.1.0   |

Add the following to your `project/plugins.sbt` file:

```scala
addSbtPlugin("com.gilt.sbt" % "sbt-aspectjweaver" % "0.1.0")
```

To use the AspectJ Weaver settings in your project, add the `AspectJWeaver` auto-plugin to your project.

```scala
enablePlugins(AspectJWeaver)
```

Configuration
-------------

To use a specific AspectJ Weaver version, add the following to your `build.sbt` file:

```scala
aspectJWeaverVersion := "1.8.10"
```
