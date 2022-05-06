pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net/") {
            name = "Fabric"
        }
        maven("https://repo.spongepowered.org/repository/maven-public/") {
            name = "Sponge Snapshots"
        }
        maven("https://maven.quiltmc.org/repository/release") {
            name = "Quilt (Release)"
        }

        maven("https://maven.quiltmc.org/repository/snapshot") {
            name = "Quilt (Snapshot)"
        }

        maven("https://server.bbkr.space/artifactory/libs-release/") {
            name = "Cotton"
        }
        
        mavenCentral()
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "net.minecraftforge.gradle") {
                useModule("${requested.id}:ForgeGradle:${requested.version}")
            }
        }
    }
}

rootProject.name = "AtMe"
include("Common", "Quilt", "Fabric", "Forge")