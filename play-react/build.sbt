lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
        inThisBuild(List(
          organization := "com.example",
          scalaVersion := "2.12.3"
        )),
        name := "PlayAnzai"
)

libraryDependencies ++= Seq(
  guice,
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
)
