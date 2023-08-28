plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.alireza.eliqtask"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.alireza.eliqtask"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

kapt {
    correctErrorTypes = true
}

dependencies {

//    def fragment_version "1.7.0-alpha03"

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("com.google.dagger:hilt-android:2.47")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.11")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0-alpha01")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0-alpha01")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")

    implementation("androidx.fragment:fragment-ktx:1.7.0-alpha03")
    debugImplementation("androidx.fragment:fragment-ktx:1.7.0-alpha03")
    debugImplementation("androidx.fragment:fragment-testing:1.7.0-alpha03")
    implementation("androidx.activity:activity-ktx:1.8.0-alpha07")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    implementation("androidx.room:room-ktx:2.6.0-beta01")
    implementation("androidx.room:room-runtime:2.6.0-beta01")


    kapt("com.google.dagger:hilt-android-compiler:2.47")
    kapt("androidx.room:room-compiler:2.6.0-beta01")
    kapt("androidx.lifecycle:lifecycle-compiler:2.7.0-alpha01")


    testImplementation("junit:junit:4.13.2")
    testImplementation("com.google.dagger:hilt-android-testing:2.47")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
    testImplementation("org.mockito:mockito-inline:2.8.47")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
    testImplementation("androidx.test:rules:1.5.0")
    testImplementation("androidx.test:runner:1.5.2")
    testImplementation("androidx.test:core-ktx:1.5.0")
    testImplementation("androidx.arch.core:core-testing:2.2.0")


    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.47")
    androidTestImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
    androidTestImplementation("org.mockito:mockito-inline:2.8.47")
    androidTestImplementation("androidx.test.ext:junit:2.47")
    androidTestImplementation("androidx.arch.core:core-testing:2.2.0")


    kaptAndroidTest("com.google.dagger:hilt-compiler:2.44.2")
}