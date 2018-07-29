# DSC Visiting Card

This is the first project from Android Basic Developer Nanodegree. 
Develop single screen app which display some information.  

I had tried here making two cardviews with image and text. The major purpose of this project is to learn Kotlin through Udacity's basic projects. 

We have seen some points in this project:
1. No need of `findViewById()`, we can directly use the id name which we have written in layout file
2. setOnClickListener on this cardView, 
 `video_cardView.setOnClickListener{
            // Do anything on Click
        }`
3. Calling Intent
 `val intentBrowser = Intent(Intent.ACTION_VIEW,uri)
          startActivity(intentBrowser)`

---

### From Java To Kotlin
#### Constants and Variables
> Java

```java
String name = "Akshay";
final String name = "Akshay";
```

> Kotlin

```kotlin
var name = "Akshay"
val name = "Akshay"
```

---
#### Class methods
> Java

```java
public class Person {

    public void displayName(String name) {
        
    }

}
```

> Kotlin

```kotlin
fun displayName(name: String) {
  
}
```

---
