name := """SOEN6441_Project"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.6"

libraryDependencies += guice

libraryDependencies ++= Seq(
  javaWs
)

libraryDependencies += ehcache

libraryDependencies += "org.junit.jupiter" % "junit-jupiter-api" % "5.8.1" % Test


libraryDependencies += "org.mockito" % "mockito-core" % "4.0.0" % Test

libraryDependencies += "javax.xml.bind" % "jaxb-api" % "2.3.1"



val AkkaVersion = "2.6.17"
libraryDependencies += "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % AkkaVersion % Test
libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion % Test
libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % AkkaVersion % Test
libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % AkkaVersion % Test
libraryDependencies += "com.typesafe.akka" %% "akka-protobuf-v3" % AkkaVersion % Test
libraryDependencies += "com.typesafe.akka" %% "akka-serialization-jackson" % AkkaVersion % Test
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % AkkaVersion % Test