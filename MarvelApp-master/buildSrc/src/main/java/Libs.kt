package com.mte.marvelapp

import Versions

object Libs {
    object AndroidX{
        const val core = "androidx.core:core-ktx:" + Versions.coreKtx
        const val appCompat = "androidx.appcompat:appcompat:" + Versions.appCompat
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:" + Versions.constraint
        const val navigationUI = "androidx.navigation:navigation-ui-ktx:" + Versions.navigation
        const val navigation = "androidx.navigation:navigation-fragment-ktx:" + Versions.navigation
        const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:" + Versions.navigation
        const val swipeRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:" + Versions.swipeRefresh
        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:" + Versions.livedata
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:" + Versions.runtime
        const val extensions = "androidx.lifecycle:lifecycle-extensions:" + Versions.extensions
        const val viewModelLifeCycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:" + Versions.viewModel
        const val dataStore = "androidx.datastore:datastore-preferences:" + Versions.dataStore
        const val dataStoreCore = "androidx.datastore:datastore-core:" + Versions.dataStore
    }

    object Google{
        const val material = "com.google.android.material:material:" + Versions.material
        const val gson = "com.google.code.gson:gson:" + Versions.gson
    }

    object Test{
        const val junit = "junit:junit:" + Versions.junit
        const val testExt = "androidx.test.ext:junit:" + Versions.testExt
        const val espresso = "androidx.test.espresso:espresso-core:" + Versions.espresso
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:" + Versions.retrofit
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:" + Versions.retrofit
        const val moshiConverter = "com.squareup.retrofit2:converter-moshi:" + Versions.retrofit
        const val okhttp = "com.squareup.okhttp3:okhttp:" + Versions.ok_http
        const val interceptor = "com.squareup.okhttp3:logging-interceptor:" + Versions.ok_http
        const val moshi = "com.squareup.moshi:moshi-kotlin:" + Versions.moshi
        const val codegen = "com.squareup.moshi:moshi-kotlin-codegen:" + Versions.moshi
        const val logger = "com.orhanobut:logger:" + Versions.logger
    }

    object Hilt {
        const val android = "com.google.dagger:hilt-android:" + Versions.hilt
        const val compiler = "com.google.dagger:hilt-android-compiler:" + Versions.hiltCompiler
        const val plugin = "com.google.dagger:hilt-android-gradle-plugin:" + Versions.hilt
    }

    object Coroutines {
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:" + Versions.coroutines
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:" + Versions.coroutinesCore
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:" + Versions.glide
        const val compiler = "com.github.bumptech.glide:compiler:" + Versions.glide
    }

    object Coil {
        const val coil = "io.coil-kt:coil:" + Versions.coil
    }

}