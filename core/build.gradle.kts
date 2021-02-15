plugins { java }

repositories {
    maven ("https://maven.scijava.org/content/groups/public")
    mavenCentral()
}

dependencies {
    implementation("sciJava:common")
    implementation(imagej.launcher)
    implementation(imagej.notebook)
    implementation(imagej.ops)
    implementation(imagej.updater)
    implementation(scifio.scifio)
    implementation(sciJava.common)
    implementation(imagej.legacy)
    implementation(imagej.meshIo)
    implementation(imagej.pluginsBatch)
    implementation(imagej.deprecated)
    implementation(imagej.pluginsCommands)
    implementation(imagej.pluginsTools)
    implementation(imagej.pluginsUploaderSsh)
    implementation(imagej.pluginsUploaderWebdav)
    implementation(imagej.scripting)
    implementation(imagej.uiSwing)
    implementation(sciJava.ioHttp)
    implementation(sciJava.pluginsCommands)
    implementation(sciJava.pluginsIoTable)
    implementation(sciJava.pluginsPlatforms)
    implementation(sciJava.pluginsTextMarkdown)
    implementation(sciJava.pluginsTextPlain)
    implementation(sciJava.scriptEditor)
    testImplementation(misc.junit)
}