import smithy4s.codegen.Smithy4sCodegenPlugin

ThisBuild / scalaVersion := "2.13.10"

val example = project
  .in(file("modules/example"))
  .enablePlugins(Smithy4sCodegenPlugin)
  .settings(
    libraryDependencies ++= Seq(
      "com.disneystreaming.smithy" % "smithytranslate-traits" % "0.3.1" % Smithy4s,
      // "com.disneystreaming.alloy" % "alloy-core" % "0.1.11",
      // "com.disneystreaming.alloy" %% "alloy-openapi" % "0.1.11",
      // "com.disneystreaming.alloy" % "alloy-core" % "0.1.11" % Smithy4s,
      // "com.disneystreaming.alloy" %% "alloy-openapi" % "0.1.11" % Smithy4s,
      "com.disneystreaming.smithy4s" %% "smithy4s-core" % smithy4sVersion.value,
      "com.disneystreaming.smithy4s" %% "smithy4s-http4s" % smithy4sVersion.value,
      "com.disneystreaming.smithy4s" %% "smithy4s-http4s-swagger" % smithy4sVersion.value,
      "org.http4s" %% "http4s-ember-server" % "0.23.18"
    )
  )
