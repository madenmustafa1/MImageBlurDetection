package com.maden.blurdetectioncustom


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val myDrawable: Drawable? = ContextCompat.getDrawable(applicationContext, R.drawable.id2)
        //val bitmap: Bitmap = (myDrawable as BitmapDrawable).bitmap
        //val result = MImageBlurDetection.isBlurredImage(image = bitmap)
        //println("result: $result")
    }
}