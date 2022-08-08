plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-android")
    id ("dagger.hilt.android.plugin")
}

android {
    compileSdk= Versions.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk =Versions.MIN_SDK_VERSION
        targetSdk =Versions.TARGET_SDK_VERSION

        version=1.0
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField ("String", "BASE_URL", "\"https://api.github.com/\"")
        buildConfigField ("String", "ACCESS_TOKEN", "\"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\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    api(Deps.KOTLIN)
    api(Deps.KOTLIN_COROUTINE_CORE)
    api(Deps.KOTLIN_COROUTINE_ANDROID)

    addRetrofitOkHttpAsApi()

    releaseApi(Deps.CHUCKER_NO_OP)
    debugApi(Deps.CHUCKER)

    api(Deps.ANDROID_X_CORE)
    api(Deps.ANDROID_X_COMPAT)
    api(Deps.ANDROID_MATERIAL)
    api(Deps.ANDROID_X_ANNOTATION)
    api(Deps.ANDROID_X_LIFECYCLE_KTX)
    api(Deps.ANDROID_X_ACTIVITY_KTX)
    api(Deps.ANDROID_X_FRAGMENT_KTX)

    testApi(Deps.JUNIT)
    androidTestApi(Deps.ANDROID_X_TEST_EXT)
    androidTestApi(Deps.ANDROID_X_TEST_ESPRESSO_CORE)

    implementation(Deps.HILT_ANDROID)
    kapt (Deps.HILT_COMPILER)
}