import com.carrefour.phenix.sbt.build.DependenciesKeys._
import com.carrefour.phenix.sbt.build._
import sbt.Keys._

val PhenixPlatformVersion = "1.4.0"
val PhenixUtilsVersion = "0.27.1"
val PhenixSupportVersion = "1.8.1"
val ClaraVersion = "0.6.0"
val ReferentialPersisterVersion = "0.30.1"

val commonSettings = Seq(organization := "com.carrefour.phenix"
  , parallelExecution in IntegrationTest := false
  , testForkedParallel in IntegrationTest := false
  , fork in IntegrationTest := true
  , fork in Test := true
  , concurrentRestrictions := Seq(Tags.limitAll(1))
  , testForkedParallel in Test := true)

lazy val root = BuildDefinition.defineRoot("sandbox", commonSettings)
  .aggregate(encoder)



lazy val encoder = BuildDefinition
  .defineModule("encoder",
    "encoder",
    commonSettings
  )
  .settings(
    libraryDependencies += "org.apache.spark" %% "spark-core" % dependencies.value.versions.spark2Offline
    , libraryDependencies += "org.apache.spark" %% "spark-sql" % dependencies.value.versions.spark2Offline
  )

lazy val configuration = BuildDefinition
  .defineModule("configuration", "configuration")
.settings(
  libraryDependencies += "org.apache.spark" %% "spark-core" % dependencies.value.versions.spark2Offline,
  libraryDependencies += "com.carrefour.phenix" %% "core" % PhenixPlatformVersion,
  dependencyOverrides += "com.iheart" %% "ficus" % "1.4.1",
  libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"

)

