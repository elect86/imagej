
plugins { java }

repositories {
    maven("https://maven.scijava.org/content/groups/public")
    mavenCentral()
}

dependencies {
    implementation(imgLib2.core)
    implementation(imgLib2.roi)
    implementation(sciJava.common)
    implementation(sciJava.table)
    implementation("edu.ucar:udunits:4.3.18")
    testImplementation("junit:junit:4.13")
}

group = "sciJava"
version = "0.0.2"