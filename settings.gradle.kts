import java.net.URI

/*
 * This file was generated by the Gradle 'init' task.
 *
 * The settings file is used to specify which projects to include in your build.
 *
 * Detailed information about configuring a multi-project build in Gradle can be found
 * in the user manual at https://docs.gradle.org/6.6.1/userguide/multi_project_builds.html
 */

rootProject.name = "imagej"


includeBuild("core")

//dependencyResolutionManagement {
//    repositories {
//        mavenCentral()
//        maven("https://maven.scijava.org/content/groups/public")
//    }
//}
//
//sourceControl {
//    gitRepository(URI("https://github.com/imagej/imagej.git")) {
//        producesModule("net.imagej:imagej")
//    }
//}
//
