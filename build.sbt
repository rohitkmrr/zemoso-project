name := """play-java"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  
 "mysql" % "mysql-connector-java" % "5.1.27"
)


lazy val models = (project in file(".")).enablePlugins(PlayJava, PlayEbean)





fork in run := true