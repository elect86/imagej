rootProject.name = "core"

//rootProject.buildFileName = "build.gradle.kts"

pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if(requested.id.id == "sciJava.catalogs")
                useModule("com.github.elect86:sciJava-catalogs:28e80e76")
        }
    }
    repositories {
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
}

plugins { id("sciJava.catalogs") }