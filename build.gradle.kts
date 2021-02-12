plugins {
    java
}

repositories {
    mavenCentral()
    maven("https://maven.scijava.org/content/groups/public")
}

dependencies {
    //    implementation(project(":core"))
    implementation("net.imagej:imagej:2.2.0")
}

object imagej {
    val repo = "https://github.com/imagej/imagej"
    val projects = arrayOf("")
}


val git = Git()

class Git {

    fun clone(url: String) {
        val dst = file("core")
        rootProject.exec {
            workingDir = dst
            commandLine("git", "init")
        }
        println(url)
        rootProject.exec {
            workingDir = dst
            commandLine("git", "remote", "add", "origin", url)
        }
        rootProject.exec {
            workingDir = dst
            commandLine("git", "fetch")
        }
        rootProject.exec {
            workingDir = dst
            commandLine("git", "checkout", "master")
        }
    }
}

tasks {
    val cleanAndClone by registering {
        doLast {
            for (project in imagej.projects) {
                clean()
                git.clone("${imagej.repo}$project.git")
            }
        }
    }
}

fun clean() {
    file("core").listFiles()?.forEach {
        if (it.name != "build.gradle.kts" && it.name != ".gradle")
            it.deleteRecursively()
    }
}

rootProject.childProjects.forEach { (s, project) ->
    println("[$s]=$project")
}

val imagejCore = """
    plugins { java }

    repositories {
        maven ("https://maven.scijava.org/content/groups/public")
        mavenCentral()
    }

    dependencies {
        implementation("net.imagej:imagej-common:0.34.0")
        implementation("net.imagej:imagej-launcher:6.0.1")
        implementation("net.imagej:imagej-notebook:0.7.1")
        implementation("net.imagej:imagej-ops:0.45.5")
        implementation("net.imagej:imagej-updater:0.10.5")
        implementation("io.scif:scifio:0.41.1")
        implementation("org.scijava:scijava-common:2.85.0")
        runtimeOnly("net.imagej:imagej-legacy:0.37.4")
        runtimeOnly("net.imagej:imagej-mesh-io:0.1.2")
        runtimeOnly("net.imagej:imagej-plugins-batch:0.1.1")
        runtimeOnly("net.imagej:imagej-deprecated:0.1.4")
        runtimeOnly("net.imagej:imagej-plugins-commands:0.8.1")
        runtimeOnly("net.imagej:imagej-plugins-tools:0.3.1")
        runtimeOnly("net.imagej:imagej-plugins-uploader-ssh:0.3.2")
        runtimeOnly("net.imagej:imagej-plugins-uploader-webdav:0.3.2")
        runtimeOnly("net.imagej:imagej-scripting:0.8.2")
        runtimeOnly("net.imagej:imagej-ui-swing:0.23.2")
        runtimeOnly("org.scijava:scijava-io-http:0.2.1")
        runtimeOnly("org.scijava:scijava-plugins-commands:0.2.3")
        runtimeOnly("org.scijava:scijava-plugins-io-table:0.4.0")
        runtimeOnly("org.scijava:scijava-plugins-platforms:0.3.1")
        runtimeOnly("org.scijava:scijava-plugins-text-markdown:0.1.3")
        runtimeOnly("org.scijava:scijava-plugins-text-plain:0.1.3")
        runtimeOnly("org.scijava:script-editor:0.5.6")
        testImplementation("junit:junit:4.13")
    }
""".trimIndent()