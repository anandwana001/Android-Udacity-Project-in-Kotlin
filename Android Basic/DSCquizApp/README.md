# DSC Quiz App

This is the second project from Android Basic Developer Nanodegree in Kotlin. 
Develop quiz app where user can interact with User Input.

I had tried here making list of 10 questions which includes `Checkboxes`, `RadioButtons`, `EditText` and a final `Button` to submit the answers and show the result on `TextView`.

We have seen some points in this project:
1. `when()` operator
`when(bool) { 
    true -> {}
    false -> {}
}`
2. `!!` not-null assertion operator 
3. `.trim { it <= ' ' }`
4. `text_view.text = edit_text.text.toString()`

---

### From Java To Kotlin
#### Switch 
> Java

```java
switch(value2){
case value1:
break;
case value2:
break;
default
}
```

> Kotlin

```kotlin
when(value2){
    value1 -> {}
    value2 -> {}
    else -> {}
}
```
---
