scalaVersion := "2.12.4"

libraryDependencies += "com.lihaoyi" %% "utest" % "0.6.0" % "test"

testFrameworks += new TestFramework("utest.runner.Framework")
