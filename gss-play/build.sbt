name := """gss-play"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  guice,
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test,
  "com.google.api-client"   % "google-api-client"          % "1.23.0",
  "com.google.oauth-client" % "google-oauth-client-jetty"  % "1.23.0",
  "com.google.apis"         % "google-api-services-sheets" % "v4-rev486-1.23.0"
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
