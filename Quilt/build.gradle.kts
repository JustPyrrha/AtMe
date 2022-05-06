plugins {
    id("org.quiltmc.loom") version "0.12.+"
    `maven-publish`
}

val minecraftVersion: String by project
val modName: String by project
val modId: String by project
val quiltLoaderVersion: String by project
val quiltStdlibVersion: String by project

val baseArchiveName = "${modName}-common-${minecraftVersion}"

base {
    archivesName.set(baseArchiveName)
}

repositories {
    maven("https://maven.quiltmc.org/repository/release/") {
        name = "Quilt (Release)"
    }

    maven("https://maven.quiltmc.org/repository/snapshot/") {
        name = "Quilt (Snapshot)"
        content {
            includeGroup("org.quiltmc.fabric_api_qsl")
            includeGroupByRegex("org\\.quiltmc\\.qsl(?:\\.[a-z_]+)?")
        }
    }
}

loom {
    runs {
        create("quilt-client") {
            client()
            configName = "Quilt Client"
            ideConfigGenerated(true)
            runDir("run")
        }
        create("quilt-server") {
            server()
            configName = "Quilt Server"
            ideConfigGenerated(true)
            runDir("run")
        }
    }
}


dependencies {

    minecraft("com.mojang:minecraft:${minecraftVersion}")
    mappings(loom.officialMojangMappings())
    modImplementation("org.quiltmc:quilt-loader:${quiltLoaderVersion}")

    modImplementation("org.quiltmc:qsl:${quiltStdlibVersion}") {
        exclude(group = "net.fabricmc")
    }

    implementation(group = "com.google.code.findbugs", name = "jsr305", version = "3.0.1")
    implementation(project(":Common"))
}

tasks.processResources {
    from(project(":Common").sourceSets.main.get().resources)
    inputs.property("version", project.version)

    filesMatching("quilt.mod.json") {
        expand("version" to project.version)
    }
}

tasks.withType<JavaCompile> {
    source(project(":Common").sourceSets.main.get().allSource)
}

tasks.jar {
    from("LICENSE") {
        rename { "${it}_${modName}"}
    }
}

publishing {
    publications {
        register("mavenJava", MavenPublication::class) {
            artifactId = baseArchiveName
            from(components["java"])
        }
    }

    repositories {
        maven("file://${System.getenv("local_maven")}")
    }
}