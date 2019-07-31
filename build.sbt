lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """play-scala-forms-example""",
    version := "2.8.x",
    scalaVersion := "2.13.0",
    libraryDependencies ++= Seq(
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0-M3" % Test,
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    )
  )