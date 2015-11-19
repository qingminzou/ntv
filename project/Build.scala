import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "myFirstApp"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
       // Add play modules
      javaCore, javaJdbc, javaEbean, filters,
      "postgresql" % "postgresql" % "9.1-901.jdbc4"
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
     
       // ---- For terracotta config ----
      // resolvers += "Terracotta repository" at "http://www.terracotta.org/download/reflector/releases/",

      // ---- For Memcached version of cache
      resolvers += "Sonatype OSS Snapshots Repository" at "http://oss.sonatype.org/content/groups/public",
      resolvers += "Spy Repository" at "http://files.couchbase.com/maven2",
      resolvers += "jade4j-releases" at "https://raw.github.com/neuland/jade4j/master/releases/"
    )

}
