resolvers += "Flyway" at "https://flywaydb.org/repo" // 追加

// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.6.11")

addSbtPlugin("org.flywaydb" % "flyway-sbt" % "4.2.0") // 追加