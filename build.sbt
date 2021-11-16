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