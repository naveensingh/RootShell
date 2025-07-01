plugins {
    id("com.android.library")
    id("maven-publish")
}

group = "com.stericson"
version = "1.0.0"

android {
    namespace = "com.stericson.RootShell"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
        targetSdk = 34
        version = project.version.toString()
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            consumerProguardFiles("proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    publishing {
        singleVariant("release")
    }
}

dependencies {
    testImplementation("junit:junit:4.12")
}

publishing.publications {
    create<MavenPublication>("release") {
        afterEvaluate {
            from(components["release"])
        }
    }
}