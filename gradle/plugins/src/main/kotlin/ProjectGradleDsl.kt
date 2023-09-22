import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

internal fun DependencyHandler.`implementation`(dependencyNotation: Any): Dependency? {
    return add("implementation", dependencyNotation)
}

internal fun DependencyHandler.`ksp`(dependencyNotation: Any): Dependency? {
    return add("ksp", dependencyNotation)
}

internal fun DependencyHandler.`testImplementation`(dependencyNotation: Any): Dependency? {
    return add("testImplementation", dependencyNotation)
}

internal fun DependencyHandler.`androidTestImplementation`(dependencyNotation: Any): Dependency? {
    return add("androidTestImplementation", dependencyNotation)
}

internal fun DependencyHandler.`debugImplementation`(dependencyNotation: Any): Dependency? {
    return add("debugImplementation", dependencyNotation)
}