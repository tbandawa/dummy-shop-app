pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Dummy Shop"
include(":app")
include(":data")
include(":design")
include(":features:auth")
include(":features:cart")
include(":features:products")
include(":features:home")
include(":features:settings")
include(":features:orders")
include(":features:notifications")
