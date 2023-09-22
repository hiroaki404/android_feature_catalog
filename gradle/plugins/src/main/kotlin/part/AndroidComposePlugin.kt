package part

import androidLibrary
import debugImplementation
import implementation
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile

@Suppress("unused")
class AndroidComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            androidLibrary {

                composeOptions {
                    kotlinCompilerExtensionVersion = "1.5.2"
                }

                target.tasks.withType(KotlinCompile::class.java).configureEach {
                    kotlinOptions {
                        JavaVersion.VERSION_17.toString()
                    }
                }

                buildFeatures {
                    compose = true
                    buildConfig = true
                }

            }

            val libs: VersionCatalog =
                extensions.getByType<VersionCatalogsExtension>().named("libs")

            fun VersionCatalog.getLibrary(library: String) = findLibrary(library).get()
            dependencies {
                implementation(libs.getLibrary("activity-compose"))
                implementation(libs.getLibrary("compose-ui"))
                implementation(libs.getLibrary("compose-ui-tooling"))
                implementation(libs.getLibrary("compose-preview"))
                implementation(libs.getLibrary("compose-foundation"))
                implementation(libs.getLibrary("compose-ui-test"))
                debugImplementation(libs.getLibrary("compose-ui-test-manifest"))
                implementation(libs.getLibrary("compose-navigation"))
                debugImplementation(libs.getLibrary("compose-ui-tooling"))
            }
        }
    }
}