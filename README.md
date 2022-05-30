# MImageBlurDetection
 ##### This library detects blur in the image
 ###
---
## Quick Start

#### App Gradle
```sh
     implementation 'com.github.madenmustafa1:MImageBlurDetection:1.0.3'
```
#### Project Gradle
```sh
buildscript {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```
or
#### Settings Gradle
```sh
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

#### MainActivity
```sh
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val result = MImageBlurDetection.isBlurredImage(image = bitmap)
    }
```
