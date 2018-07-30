scalaVersion := "2.12.6"

libraryDependencies += "com.lihaoyi" %% "utest" % "0.6.0" % "test"

testFrameworks += new TestFramework("utest.runner.Framework")

Test / fork := true
