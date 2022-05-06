pluginManagement {
    repositories {
        maven("https://repo.galacticraft.net/repository/common-proxy/") {
            name = "AllProxies"
        }
        resolutionStrategy {
            eachPlugin {
                if (requested.id.id == "net.minecraftforge.gradle") {
                    useModule("${requested.id}:ForgeGradle:${requested.version}")
                }
            }
        }
    }
}

rootProject.name = "AtMe"
include("Common", "Quilt", "Fabric", "Forge")