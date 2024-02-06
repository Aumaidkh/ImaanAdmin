// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Dependencies.hiltAgp)
        classpath(Dependencies.Navigation.safeArgs)
       // classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10")
    }
}
allprojects {
    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class) {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}