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
        multiDexEnabled = true
        testInstrumentationRunner = "com.alireza.eliqtask.config.HiltTestRunner"


        buildConfigField("String", "BASE_URL", project.properties["BASE_URL"].toString())
        vectorDrawables {
            useSupportLibrary = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    val coreKtxVersion = "1.10.1"
    val appCompatVersion = "1.6.1"
    val materialVersion = "1.9.0"
    val swipeToRefreshVersion = "1.2.0-alpha01"
    val constraintLayoutVersion = "2.1.4"
    val multidexVersion = "2.0.1"
    val retrofitVersion = "2.9.0"
    val loggingInterceptorVersion = "5.0.0-alpha.11"
    val lifecycleVersion = "2.7.0-alpha01"
    val lifecycleExtensionsVersion = "2.2.0"
    val fragmentVersion = "1.7.0-alpha03"
    val activityVersion = "1.8.0-alpha07"
    val moshiVersion = "1.15.0"
    val moshiKotlinVersion = "1.8.0"
    val coroutinesVersion = "1.7.3"
    val roomVersion = "2.6.0-beta01"
    val hiltVersion = "2.47"
    val hiltCompilerVersion = "2.44.2"
    val junitVersion = "4.13.2"
    val mockitoKotlinVersion = "4.1.0"
    val mockitoInlineVersion = "2.8.47"
    val androidxTestVersion = "1.5.0"
    val androidxTestExtVersion = "1.1.5"
    val androidxTestRunnerVersion = "1.5.2"
    val androidxArchCoreVersion = "2.2.0"
    val espressoVersion = "3.5.1"
    val composeBom = platform("androidx.compose:compose-bom:2023.08.00")


    implementation(composeBom)
    implementation("androidx.compose.material3:material3")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")

    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.material3:material3-window-size-class")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")

    implementation("androidx.core:core-ktx:$coreKtxVersion")
    implementation("androidx.appcompat:appcompat:$appCompatVersion")
    implementation("com.google.android.material:material:$materialVersion")
    implementation("androidx.constraintlayout:constraintlayout:$constraintLayoutVersion")
    implementation( "androidx.multidex:multidex:$multidexVersion")

    implementation("androidx.swiperefreshlayout:swiperefreshlayout:$swipeToRefreshVersion")

    implementation("com.google.dagger:hilt-android:$hiltVersion")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-extensions:$lifecycleExtensionsVersion")

    implementation("androidx.fragment:fragment-ktx:$fragmentVersion")
    implementation("androidx.activity:activity-ktx:$activityVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    implementation("androidx.room:room-ktx:$roomVersion")
    implementation("androidx.room:room-runtime:$roomVersion")

    implementation("com.squareup.retrofit2:converter-moshi:$retrofitVersion")
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$loggingInterceptorVersion")
    implementation("com.squareup.moshi:moshi-kotlin:$moshiVersion")


    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycleVersion")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:$moshiKotlinVersion")


    debugImplementation("androidx.fragment:fragment-ktx:$fragmentVersion")
    debugImplementation("androidx.fragment:fragment-testing:$fragmentVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    testImplementation("junit:junit:$junitVersion")
    testImplementation("com.google.dagger:hilt-android-testing:$hiltVersion")
    testImplementation("org.mockito.kotlin:mockito-kotlin:$mockitoKotlinVersion")
    testImplementation("org.mockito:mockito-inline:$mockitoInlineVersion")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")
    testImplementation("androidx.test:rules:$androidxTestVersion")
    testImplementation("androidx.test:runner:$androidxTestRunnerVersion")
    testImplementation("androidx.test:core-ktx:$androidxTestVersion")
    testImplementation("androidx.arch.core:core-testing:$androidxArchCoreVersion")
    testImplementation("androidx.test.ext:junit:$androidxTestExtVersion")


    androidTestImplementation("androidx.test.ext:junit:$androidxTestExtVersion")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoVersion")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")
    androidTestImplementation("com.google.dagger:hilt-android-testing:$hiltVersion")
    androidTestImplementation("org.mockito.kotlin:mockito-kotlin:$mockitoKotlinVersion")
    androidTestImplementation("org.mockito:mockito-inline:$mockitoInlineVersion")
    androidTestImplementation("androidx.arch.core:core-testing:$androidxArchCoreVersion")
    androidTestImplementation(composeBom)
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")


    kaptAndroidTest("com.google.dagger:hilt-compiler:$hiltVersion")
}