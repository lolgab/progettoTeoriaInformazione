scalaVersion := "2.12.6"

libraryDependencies += "com.lihaoyi" %% "utest" % "0.6.0" % "test"

testFrameworks += new TestFramework("utest.runner.Framework")

//Test / fork := true

libraryDependencies += {
  val version = scalaBinaryVersion.value match {
    case "2.10" => "1.0.3"
    case _ ⇒ "1.1.2"
  }
  "com.lihaoyi" % "ammonite" % version % "test" cross CrossVersion.full
}

sourceGenerators in Test += Def.task {
  val file = (sourceManaged in Test).value / "amm.scala"
  IO.write(file, """object amm extends App { ammonite.Main.main(args) }""")
  Seq(file)
}.taskValue
