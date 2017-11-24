# Bindapter
## You will never build an adapter again


Bindapter use the power of DataBinding to build a flexible RecyclerView.Adapter which will save you a lot of time.

Bindapter is totally built with Kotlin + Love 💖.

<img src="https://github.com/silmood/Bindapter/blob/master/capture/bindapter_record.gif" width="300"/>

# Usage

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


# Setup

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
implementation 'com.silmood.bindapter:bindapter:0.1.1'
```

  Gradle 2.X.X

```groovy
compile 'com.silmood.bindapter:bindapter:0.1.1'
```

# Listening Events
If you want to add interaction in your views you just have to add a `Handler` (or whatever you like name it) class when you create a Bindapter:

### Kotlin
```kotlin
class Handler {
    fun onClick(view: View) { ... }
    fun onClickImage(view: View, item: ItemModel) { ... }
}

val bindapter = Bindapter<ItemModel>(R.layout.item,
                    itemVariableId = BR.item,
                    handler = Handler(),
                    handlerId = BR.handler)
```

### Java
```java
public class Handler {
    public void onClick(View view) { ... }
    public void onClickImage(View view, ItemModel item) { ... }
}

Bindapter<ItemModel> bindapter = new Bindapter<>(R.layout.item, 
                                        BR.item, 
                                        new Handler(), 
                                        BR.handler);

```

This way you can use it in your layout.

```xml
<layout xmlns:android="http://schemas.android.com/apk/res/android">
    <data>
        <variable
            name="item"
            type="com.example.app.Item"/>
        <variable 
            name="handler" 
            type="com.example.app.Handler"/>
    </data>

   <ImageView
        android:id="@+id/img"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="@{handler::onClick}"
        app:imgUrl="@{item.image}"/>
</layout>
```

If you need to receive the model when an item is clicked, you can implement it this way:

```xml
   <ImageView
        android:id="@+id/img"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="@{(view) -> handler.onClickImage(view, item)}"
        app:imgUrl="@{item.image}"/>
```

More info about [here](https://developer.android.com/topic/libraries/data-binding/index.html#event_handling)


# Binding Adapters
A binding adapter is a way to define custom behaviors to set properties in a view. For example, load images with Glide/Picasso or set TextView's color according to a model property. [More info](https://developer.android.com/reference/android/databinding/BindingAdapter.html)

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
@BindingAdapter({"bind:imgUrl"})
public static void loadImage(ImageView view, String url) {
   Picasso.with(view.getContext()).load(url).into(view);
}
```

Once it is declared you can use it in your layout:
```xml

   <ImageView
        android:id="@+id/img"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:imgUrl="@{item.image}"/>
```


# FAQ

* **My BR. class/variables are missing ¿What can i do?**

The BR class isn't correctly generated yet. After define your layout **you have to build again your project**


* **There is a problem building the project: 'Internal compiler error'**

It's possible you have commit a mistake in your layout file defining types with Data Binding. Check your gradle console to know where exactly is the problem.

# Code Style

This project is written on [Kotlin](https://kotlinlang.org/) and uses [ktlint](https://github.com/shyiko/ktlint).
If you find that one of your pull reviews does not pass the CI server check due to a code style conflict, you can
easily fix it by running: `./gradlew :bindapter:ktlintFormat`, or running IntelliJ/Android Studio's code formatter.


# TODO

* Support multiple view types for different models
* Support multiple view types for the same model
