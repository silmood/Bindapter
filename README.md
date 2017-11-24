# Bindapter
## You will never build an adapter again


Bindapter use the power of DataBinding to build a flexible RecyclerView.Adapter which will save you a lot of time.

Bindapter is totally built with Kotlin + Love 💖.

<img src="https://github.com/silmood/Bindapter/blob/master/capture/bindapter_record.gif" width="300"/>

## Usage

Only create your view using databinding

```xml
<layout xmlns:android="http://schemas.android.com/apk/res/android">
    <data>
        <variable
            name="item"
            type="com.example.app.Item"/>
    </data>

   <TextView
        android:id="@+id/img"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@{item.title}"/>
</layout>
```

Then create your Bindapter

```kotlin
val adapter = Bindapter<ItemModel>(R.layout.item_view, BR.item)
```

And then set it to your RecyclerView

```kotlin
recyclerView.adapter = adapter
```

**As simple as that, now you can spend your time on more important things**


## Setup

1. Active DataBinding in your project `build.gradle`

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

# Binding Adapters
A binding adapter is a way to define custom behaviors to set properties in a view. For example, load images with Glide/Picasso or set TextView color according to a model property. [More info](https://developer.android.com/reference/android/databinding/BindingAdapter.html)

### Kotlin
The sample app contains a file named `BindingAdapters.kt`. This is the way you have to define them; just creating Kotlin file an put the functions there.

```kotlin
@BindingAdapter("imgUrl")
fun loadImage(imageView: ImageView, url: String) {
    Glide.with(imageView.context)
            .load(url)
            .into(imageView)
}

@BindingAdapter("ratingColor")
fun ratingColor(textView: TextView, ratingPercent: String) {
    val percantage = ratingPercent.toInt()
    val context = textView.context

    val color = when {
        percantage > 95 -> ContextCompat.getColor(context, R.color.positive_1)
        percantage > 90 -> ContextCompat.getColor(context, R.color.positive_2)
        else -> ContextCompat.getColor(context, R.color.negative)
    }

    textView.setTextColor(color)
}
```

### Java
If you are using Java you just have to define your binding adapters as static methods.

```java
@BindingAdapter({"bind:imageUrl", "bind:error"})
public static void loadImage(ImageView view, String url, Drawable error) {
   Picasso.with(view.getContext()).load(url).error(error).into(view);
}
```



# Code Style

This project is written on [Kotlin](https://kotlinlang.org/) and uses [ktlint](https://github.com/shyiko/ktlint).
If you find that one of your pull reviews does not pass the CI server check due to a code style conflict, you can
easily fix it by running: `./gradlew :bindapter:ktlintFormat`, or running IntelliJ/Android Studio's code formatter.


# TODO

* Support multiple view types for different models
* Support multiple view types for the same model
