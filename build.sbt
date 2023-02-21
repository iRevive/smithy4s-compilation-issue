import smithy4s.codegen.Smithy4sCodegenPlugin

ThisBuild / scalaVersion := "2.13.10"

val example = project
  .in(file("modules/example"))
  .enablePlugins(Smithy4sCodegenPlugin)
  .settings(
    // Smithy4s actively protects against automatic generation of namespaces starting with
    // "alloy", "aws", "smithy" and "smithy4s". You can force it to take these namespaces
    // into consideration, but you then have to provide an exhaustive list of the namespaces
    // you want to generate
    //
    // NB : the smithy files generated by smithy-translate do not have vocation to be ingested
    // directly by smithy4s. In theory the users have to process them manually (or automate
    // it however they want) to ensure that the resulting smithy spec makes sense in the context
    // of smithy4s. It is not necessarily the case, as there are patterns in openapi
    // that do not make sense in smithy, or that smithy4s can simply not process
    //
    smithy4sAllowedNamespaces := List(
      "alloy.openapi",
      "openapi_schema",
      "smithytranslate"
    ),
    libraryDependencies ++= Seq(
      "com.disneystreaming.smithy" % "smithytranslate-traits" % "0.3.1" % Smithy4s,
      "com.disneystreaming.alloy" %% "alloy-openapi" % "0.1.11" % Smithy4s,
      "com.disneystreaming.smithy4s" %% "smithy4s-core" % smithy4sVersion.value,
      "com.disneystreaming.smithy4s" %% "smithy4s-http4s" % smithy4sVersion.value,
      "com.disneystreaming.smithy4s" %% "smithy4s-http4s-swagger" % smithy4sVersion.value,
      "org.http4s" %% "http4s-ember-server" % "0.23.18"
    )
  )
