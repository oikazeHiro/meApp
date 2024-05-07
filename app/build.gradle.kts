plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    kotlin("plugin.serialization")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.me.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.me.app"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        ndk {
            abiFilters.addAll(listOf(
                "arm64-v8a",
                "x86_64",
            ))
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.androidx.material3.window.size)
    implementation(libs.androidx.material.icons.extended)

    // 导航
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.navigation.navigation.fragment.ktx25)
    implementation(libs.androidx.navigation.navigation.ui.ktx25)
    implementation(libs.androidx.navigation.navigation.dynamic.features.fragment7)

    // koin 依赖注入框架
    implementation(libs.koin.androidx.compose)
    // okhttp
    implementation(libs.okhttp)
    // json
    implementation(libs.kotlinx.serialization.json)
    // 这个库提供了一组类似于可组合项的设置来帮助android Jetpack组合 开发人员构建复杂的设置屏幕，而无需所有样板文件。
    implementation(libs.github.ui.tiles)
    // retrofit
    implementation(libs.squareup.retrofit)
    // room 使用 Room 持久保留数据
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.paging)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.room.compiler2)
    // Coil 是一个 Android 图片加载库，通过 Kotlin 协程的方式加载图片
    implementation(libs.io.coil.kt.coil2)
    // Comparist是一组库，旨在为Jetpack Compose提供开发人员通常需要但尚未提供的功能。
    implementation(libs.com.google.accompanist.accompanist.permissions2)
    implementation(libs.accompanist.navigation.animation)
    // mmkv
    implementation(libs.mmkv.static)
    implementation(libs.markdown)
}


ksp {
    arg("room.schemaLocation", "$projectDir/schemas")
    arg("room.incremental", "true")
}