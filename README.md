# Diagonalify
#### Min SDK 9

![Banner](art/banner.png)
## Screnshots

![Screenshot](art/screenshot_1.png)    ![Screenshot](art/screenshot_2.png)


## Usage
Use the gradle dependency and add these lines in your build.gradle file:

```xml
repositories {
        jcenter()
}

dependencies {
    compile ' library ka gradle'
    
}
```


## Basic Usage
```xml
 
    <developer.shivam.library.DiagonalView android:id="@+id/diagonal_view"
        android:layout_width="match_parent"
        android:layout_height="250dp"
        android:src="@drawable/gir_cover"
        android:scaleType="centerCrop"
     />

```

## Custom Attributes

### To set Diagonal Color
```xml
        diagonal:diagonalColor="#FFFFFF"
```
### To set Background Color
```xml
        diagonal:backgroundColor="#50F44336"
```
### To set Diagonal Angle
```xml
        diagonal:angle="15"
```

## License
Copyright (c) 2016 Shivam Satija

Licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)
