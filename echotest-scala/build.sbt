name := "echotest-scala"

version := "0.4"

libraryDependencies ++= Seq(
  "com.lihaoyi"       %% "mainargs"        % "0.7.8",
  "com.github.sbt.junit" % "jupiter-interface" % "0.19.0" % Test, // required only for plain JUnit testing
  "org.scalatest"     %% "scalatest"       % "3.2.20"   % Test,
  "org.scalacheck"    %% "scalacheck"      % "1.20.0"   % Test,
  "org.scalatestplus" %% "scalacheck-1-19" % "3.2.20.0" % Test
)

enablePlugins(JavaAppPackaging)
