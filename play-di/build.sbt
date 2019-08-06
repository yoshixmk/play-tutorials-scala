name := """play-di"""

version := "2.8.x"

scalaVersion := "2.13.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test
libraryDependencies += "com.softwaremill.macwire" %% "macros" % "2.3.2" % "provided"

scalacOptions ++= Seq(
    "-feature",
    "-deprecation",
    "-Xfatal-warnings"
)
