
plugins { java }

repositories {
    maven("https://maven.scijava.org/content/groups/public")
    mavenCentral()
}

dependencies {
    implementation("net.imglib2:imglib2:5.10.0")
    implementation("net.imglib2:imglib2-roi:0.10.2")
    implementation("org.scijava:scijava-common:2.83.3")
    implementation("org.scijava:scijava-table:0.6.1")
    implementation("edu.ucar:udunits:4.3.18")
    testImplementation("junit:junit:4.13")
}