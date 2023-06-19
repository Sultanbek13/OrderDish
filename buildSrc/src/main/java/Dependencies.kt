object Android {
    const val compile_sdk_version = 33
    const val min_sdk_version = 24
    const val target_sdk_version = 33
    const val version_code = 1
    const val version_name = "1.0"
}

object Modules {
    const val core_network = ":core-network"
    const val core_database = ":core-database"
    const val core_util = ":core-util"
    const val feature_main = ":feature-main"
    const val feature_category = ":feature-category"
    const val feature_product = ":feature-product"
    const val feature_basket = ":feature-basket"
}

object Versions {
    const val ktx = "1.7.0"
    const val appcompat = "1.6.1"
    const val material = "1.9.0"
    const val constraint_layout = "2.1.4"
    const val coil = "2.2.2"
    const val core_testing = "2.1.0"
    const val coroutines = "1.6.4"
    const val espresso_core = "3.5.1"
    const val fragment = "1.5.3"
    const val gradle = "7.3.0"
    const val gson = "2.9.1"
    const val junit = "4.13.2"
    const val kakao = "2.4.0"
    const val koin = "3.2.0"
    const val kotlin = "1.7.20"
    const val lifecycle = "2.5.1"
    const val mockk = "1.13.2"
    const val navigation = "2.5.2"
    const val okhttp = "4.10.0"
    const val recycler_view = "1.2.1"
    const val retrofit = "2.9.0"
    const val test_core = "1.4.0"
    const val test_ext = "1.1.5"
    const val test_rules = "1.4.0"
    const val test_runner = "1.4.0"
    const val glide = "4.15.1"
    const val kirich = "1.5.9"
    const val room = "2.4.3"
}

object Libs {
    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val coil = "io.coil-kt:coil:${Versions.coil}"
    const val coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val gson = "com.google.code.gson:gson:$${Versions.gson}"
    const val koin = "io.insert-koin:koin-android:${Versions.koin}"
    const val koin_core = "io.insert-koin:koin-core:${Versions.koin}"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val okhttp_logging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val recycler_view = "androidx.recyclerview:recyclerview:${Versions.recycler_view}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val kirich_full = "com.github.kirich1409:viewbindingpropertydelegate:${Versions.kirich}"
    const val kirich_noreflection = "com.github.kirich1409:viewbindingpropertydelegate-noreflection:${Versions.kirich}"
    const val room_runtime = "androidx.room:room-runtime:${Versions.room}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.room}"
    const val room_compiler = "androidx.room:room-compiler:${Versions.room}"
}

object TestLibs {
    const val core_testing = "androidx.arch.core:core-testing:${Versions.core_testing}"
    const val coroutines_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val espresso_contrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso_core}"
    const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"
    const val fragment_testing = "androidx.fragment:fragment-testing:${Versions.fragment}"
    const val junit = "junit:junit:${Versions.junit}"
    const val kakao = "com.agoda.kakao:kakao:${Versions.kakao}"
    const val koin_test = "io.insert-koin:koin-test:${Versions.koin}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val mockk_android = "io.mockk:mockk-android:${Versions.mockk}"
    const val test_core = "androidx.test:core:${Versions.test_core}"
    const val test_ext = "androidx.test.ext:junit:${Versions.test_ext}"
    const val test_rules = "androidx.test:rules:${Versions.test_rules}"
    const val test_runner = "androidx.test:runner:${Versions.test_runner}"
}