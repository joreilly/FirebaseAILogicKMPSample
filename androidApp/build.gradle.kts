plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.googleServices)
}

android {
    namespace = "dev.johnoreilly.vertexai"
    compileSdk = 37

    defaultConfig {
        applicationId = "dev.johnoreilly.vertexai"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        buildConfig = false
    }
}

dependencies {
    implementation(projects.shared)

    implementation(compose.runtime)
    implementation(libs.androidx.activity.compose)

    implementation(libs.koin.android)

    implementation(project.dependencies.platform(libs.firebase.bom))
    implementation(libs.firebase.common)

    debugImplementation(libs.androidx.compose.ui.tooling)
}
