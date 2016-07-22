name := """play-java"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  
 "mysql" % "mysql-connector-java" % "5.1.27",
   "org.postgresql" % "postgresql" % "9.4-1202-jdbc42",
  "org.webjars" % "angularjs" % "1.3.0-beta.2",
  "org.webjars" % "requirejs" % "2.1.11-1"
)


lazy val models = (project in file(".")).enablePlugins(PlayJava, PlayEbean)





fork in run := true