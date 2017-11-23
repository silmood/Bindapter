# Bindapter
## You will never build an adapter again


Bindapter use the power of DataBinding to build a flexible RecyclerView.Adapter which will save you a lot of time.

Bindapter is totally built with Kotlin + Love 💖.

<img src="https://github.com/silmood/Bindapter/blob/master/capture/bindapter_record.gif" width="300"/>

## Usage

Only create your Bindapter

```kotlin
val adapter = Bindapter<ItemModel>(R.layout.item_view, BR.data_binding_variable)
```

And then set it to your RecyclerView

```kotlin
recyclerView.adapter = adapter
```

**As simple as that, now you can spend your time on more important things**


## Setup

1. Active DataBinding in your project `buil.gradle`

```groovy
android {
    dataBinding {
        enabled true
    }
}
```

1.1 ***If you are using Kotlin***  - Configure Databinding Compiler with Kapt

```groovy
apply plugin: 'kotlin-kapt'

dependencies {
  kapt 'com.android.databinding:compiler:3.0.1'
}
```

2. Configure maven url in your root `build.gradle` *This one is temporal 😄*

```groovy
allProjects {
    repositories {
        maven { url  "http://dl.bintray.com/silmood/bindapter" }
    }
}
```

3. Import Bindapter

  Gradle 3.X.X

```groovy
implementation 'com.silmood.bindapter:bindapter:0.1.0'
```

  Gradle 2.X.X

```groovy
compile 'com.silmood.bindapter:bindapter:0.1.0'
```

Code style
--------------------------

This project is written on [Kotlin](https://kotlinlang.org/) and uses [ktlint](https://github.com/shyiko/ktlint).
If you find that one of your pull reviews does not pass the CI server check due to a code style conflict, you can
easily fix it by running: `./gradlew :bindapter:ktlintFormat`, or running IntelliJ/Android Studio's code formatter.
