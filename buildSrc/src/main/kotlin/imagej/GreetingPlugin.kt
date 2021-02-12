import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings

class GreetingPlugin : Plugin<Settings> {
    override fun apply(settings: Settings) {
        println("apply")
    }
}
