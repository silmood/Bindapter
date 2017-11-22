# Bindapter
## You will never build an adapter again

***Work In Progress***

Bindapter use the power of DataBinding to build a flexible RecyclerView.Adapter which will save you a lot of time.

Bindapter is totally built with Kotlin + Love 💖.

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
