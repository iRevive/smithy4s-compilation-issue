1) Generate smithy definition from OpenAPI spec:

```shell
$ cd modules/example/src/main/smithy
$ smithytranslate openapi-to-smithy --input openapi-schema.yaml .
```

Output:
```
Writing .../smith4s-compilation-issue/modules/example/src/main/smithy/alloy/common.smithy
Writing .../smith4s-compilation-issue/modules/example/src/main/smithy/alloy/openapi.smithy
Writing .../smith4s-compilation-issue/modules/example/src/main/smithy/openapi_schema.smithy
```

2) Try to compile

```shell
$ sbt compile
```

Output:
```
sbt:smith4s-compilation-issue> compile
Feb 21, 2023 9:46:18 PM software.amazon.smithy.model.loader.ModelLoader load
WARNING: No ModelLoader was able to load .../smith4s-compilation-issue/modules/example/src/main/smithy/simple-schema.yaml
Feb 21, 2023 9:46:18 PM software.amazon.smithy.model.loader.ModelLoader load
WARNING: No ModelLoader was able to load .../smith4s-compilation-issue/modules/example/src/main/smithy/openapi-schema.yaml
Feb 21, 2023 9:46:18 PM software.amazon.smithy.model.loader.LoaderShapeMap validateConflicts
WARNING: Ignoring duplicate but equivalent shape definition: alloy.openapi#openapiExtensions defined at jar:file:/Users/xyz/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/com/disneystreaming/alloy/alloy-core/0.1.11/alloy-core-0.1.11.jar!/META-INF/smithy/openapi/openapi.smithy [8, 1] and .../smith4s-compilation-issue/modules/example/src/main/smithy/alloy/openapi.smithy [8, 1]
Feb 21, 2023 9:46:18 PM software.amazon.smithy.model.loader.LoaderShapeMap validateConflicts
WARNING: Ignoring duplicate but equivalent shape definition: alloy.common#languageCodeFormat defined at jar:file:/Users/xyz/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/com/disneystreaming/alloy/alloy-core/0.1.11/alloy-core-0.1.11.jar!/META-INF/smithy/common/common.smithy [20, 1] and .../smith4s-compilation-issue/modules/example/src/main/smithy/alloy/common.smithy [33, 1]
Feb 21, 2023 9:46:18 PM software.amazon.smithy.model.loader.LoaderShapeMap validateConflicts
WARNING: Ignoring duplicate but equivalent shape definition: alloy.common#countryCodeFormat defined at jar:file:/Users/xyz/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/com/disneystreaming/alloy/alloy-core/0.1.11/alloy-core-0.1.11.jar!/META-INF/smithy/common/common.smithy [14, 1] and .../smith4s-compilation-issue/modules/example/src/main/smithy/alloy/common.smithy [11, 1]
Feb 21, 2023 9:46:18 PM software.amazon.smithy.model.loader.LoaderShapeMap validateConflicts
WARNING: Ignoring duplicate but equivalent shape definition: alloy.common#emailFormat defined at jar:file:/Users/xyz/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/com/disneystreaming/alloy/alloy-core/0.1.11/alloy-core-0.1.11.jar!/META-INF/smithy/common/common.smithy [8, 1] and .../smith4s-compilation-issue/modules/example/src/main/smithy/alloy/common.smithy [18, 1]
Feb 21, 2023 9:46:18 PM software.amazon.smithy.model.loader.LoaderShapeMap validateConflicts
WARNING: Ignoring duplicate but equivalent shape definition: alloy.common#languageTagFormat defined at jar:file:/Users/xyz/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/com/disneystreaming/alloy/alloy-core/0.1.11/alloy-core-0.1.11.jar!/META-INF/smithy/common/common.smithy [26, 1] and .../smith4s-compilation-issue/modules/example/src/main/smithy/alloy/common.smithy [41, 1]
Feb 21, 2023 9:46:18 PM software.amazon.smithy.model.loader.LoaderShapeMap validateConflicts
WARNING: Ignoring duplicate but equivalent shape definition: alloy.common#hexColorCodeFormat defined at jar:file:/Users/xyz/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/com/disneystreaming/alloy/alloy-core/0.1.11/alloy-core-0.1.11.jar!/META-INF/smithy/common/common.smithy [31, 1] and .../smith4s-compilation-issue/modules/example/src/main/smithy/alloy/common.smithy [25, 1]
[info] compiling 14 Scala sources to .../smith4s-compilation-issue/modules/example/target/scala-2.13/classes ...
[error] .../smith4s-compilation-issue/modules/example/target/scala-2.13/src_managed/main/scala/openapi_schema/OpenapiSchemaService.scala:43:11: object openapi is not a member of package alloy
[error]     alloy.openapi.OpenapiExtensions(Map("x-original-swagger-version" -> smithy4s.Document.fromString("2.0"))),
[error]           ^
[error] .../smith4s-compilation-issue/modules/example/target/scala-2.13/src_managed/main/scala/openapi_schema/OpenapiSchemaService.scala:82:13: object openapi is not a member of package alloy
[error]       alloy.openapi.OpenapiExtensions(Map("x-serviceIds" -> smithy4s.Document.array(smithy4s.Document.fromString("weaviate.classifications.get")))),
[error]             ^
[error] two errors found
[error] (example / Compile / compileIncremental) Compilation failed
[error] Total time: 1 s, completed Feb 21, 2023, 9:46:19 PM
sbt:smith4s-compilation-issue>
```