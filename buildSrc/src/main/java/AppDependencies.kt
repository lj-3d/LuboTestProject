import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {
    //std lib
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    //android ui
    private val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    //core
    private val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycle}"
    private val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycle}"
    private val lifeCycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycle}"
    private val viewModelSavedState =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifeCycle}"
    private val lifeCycleKapt = "androidx.lifecycle:lifecycle-compiler:${Versions.lifeCycle}"

    //data net
    private val retrofitClient = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    private val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    //data db
    private val roomDbClient = "androidx.room:room-runtime:${Versions.room}"
    private val roomDbKtxSupport = "androidx.room:room-ktx:${Versions.room}"
    private val roomDbClientCompilerKapt = "androidx.room:room-compiler:${Versions.room}"


    //test libs
    private val junit = "junit:junit:${Versions.junit}"
    private val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    private val baseImplementationLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(coreKtx)
    }

    private val coreImplementationLibraries = arrayListOf<String>().apply {
        addAll(baseImplementationLibraries)
        add(viewModel)
        add(liveData)
        add(lifeCycle)
        add(viewModelSavedState)
    }

    val applicationImplementationLibraries = arrayListOf<String>().apply {
        add(appcompat)
        add(constraintLayout)
    }

    val dataImplementationLibraries = arrayListOf<String>().apply {
        addAll(baseImplementationLibraries)
        add(retrofitClient)
        add(retrofitConverter)
        add(roomDbClient)
        add(roomDbKtxSupport)
        add(roomDbClientCompilerKapt)
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