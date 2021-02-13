plugins {
    java
}

repositories {
    mavenCentral()
    maven("https://maven.scijava.org/content/groups/public")
}

dependencies {
    //    implementation(project(":core"))
    implementation(batik.xmlgraphicsCommons)
    implementation(bonej.utilities)
    implementation(fiji.trakem2Transform)
    implementation(groovy.yaml)
    implementation(imagej.core)
    //    implementation(libs.hsqldb)
    //    implementation(ima)
}

object Imagej {
    val baseAdr = "https://github.com/imagej/imagej"
    val repos = arrayOf("", "-common")
}


val git = Git()

class Git {

    fun clone(url: String, project: String) {
        val dst = file(project.ifEmpty { "core" })
        execIn(dst,
            "git init",
            "git remote add origin $url",
            "git fetch",
            "git checkout master")
    }
}

tasks {
    val cleanIfNeededAndClone by registering {
        doLast {
            for (repo in Imagej.repos) {
                val dir = repo.drop(1).ifEmpty { "core" }
                val doesExist = file("$dir/.git").exists()
                if (!doesExist) {
                    dir.clean() // FIXME?
                    val url = "${Imagej.baseAdr}$repo.git"
                    git.clone(url, dir)
                }
            }
        }
    }

    val cleanRepos by registering {
        doLast {
            for (repo in Imagej.repos)
                repo.drop(1).ifEmpty { "core" }.clean()
        }
    }
}

fun String.clean() {
    file(this).listFiles()?.forEach {
        if ("gradle" !in it.name)
            it.deleteRecursively()
    }
}

fun execIn(dir: File, vararg cmds: String) {
    for (cmd in cmds)
        rootProject.exec {
            workingDir = dir
            commandLine(cmd.split(Regex("\\s+")))
        }
}