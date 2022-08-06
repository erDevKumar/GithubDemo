import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import Versions

fun DependencyHandler.addRetrofitOkHttpAsApi() {

    api(Deps.OK_HTTP_CORE)
    api(Deps.OK_HTTP_LOG_INTERCEPTOR)

    api(Deps.RETROFIT_CORE)
    api(Deps.RETROFIT_CONVERTER_GSON)
    api(Deps.RETROFIT_ADAPTER_RXJAVA)

}

private fun DependencyHandler.api(dependencyNotation: Any): Dependency? =
    add("api", dependencyNotation)

private fun DependencyHandler.implement(dependencyNotation: Any):Dependency?=
    add("implementation",dependencyNotation)