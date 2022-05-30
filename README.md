# MImageBlurDetection
 ##### This library detects blur in the image
 ###
---
## Quick Start


#### Settings Gradle
```sh
include ':MImageBlurDetection'
include ':sdk'
```

#### MainActivity
```sh
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         
        val result = MImageBlurDetection.isBlurredImage(image = bitmap)
        println("Result: " + result)
    }
```
