import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {

    //std lib
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    //android ui
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val BRVAH =
        "com.github.CymChad:BaseRecyclerViewAdapterHelper:${Versions.brvah}"

    //core
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycle}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycle}"
    const val lifeCycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycle}"
    const val viewModelSavedState =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifeCycle}"
    const val lifeCycleKapt = "androidx.lifecycle:lifecycle-compiler:${Versions.lifeCycle}"

    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"


    //data net
    const val retrofitClient = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"

    //data db
    const val roomDbClient = "androidx.room:room-runtime:${Versions.room}"
    const val roomDbKtxSupport = "androidx.room:room-ktx:${Versions.room}"
    const val roomDbClientCompilerKapt = "androidx.room:room-compiler:${Versions.room}"


    //test libs
    const val junit = "junit:junit:${Versions.junit}"
    const val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    val baseImplementationLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(coreKtx)
    }

    val coreImplementationLibraries = arrayListOf<String>().apply {
        add(appcompat)
        addAll(baseImplementationLibraries)
        add(viewModel)
        add(liveData)
        add(lifeCycle)
        add(viewModelSavedState)
        add(coroutinesAndroid)
    }

    val applicationImplementationLibraries = arrayListOf<String>().apply {
        addAll(baseImplementationLibraries)
    }

    val localDataImplementationLibraries = arrayListOf<String>().apply {
        addAll(baseImplementationLibraries)
        add(roomDbClient)
        add(roomDbKtxSupport)
        add(roomDbClientCompilerKapt)
        add(coroutinesCore)
    }

    val networkDataImplementationLibraries = arrayListOf<String>().apply {
        addAll(baseImplementationLibraries)
        add(retrofitClient)
        add(retrofitConverter)
        add(interceptor)
        add(coroutinesCore)
    }

    val presentationImplementationLibraries = arrayListOf<String>().apply {
        add(recyclerView)
        add(BRVAH)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
    }
}

//util functions for adding the different type dependencies from build.gradle.kts file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.api(list: List<String>) {
    list.forEach { dependency ->
        add("api", dependency)
    }
}

fun DependencyHandler.project(project: String) {
    add("implementation project", project)
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}