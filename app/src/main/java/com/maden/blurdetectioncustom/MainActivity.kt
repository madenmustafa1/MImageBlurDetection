package com.maden.blurdetectioncustom

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.maden.mimageblurdetection.MImageBlurDetection
import org.opencv.android.OpenCVLoader

class MainActivity : AppCompatActivity() {





    /*
    companion object {
        val TAG = "MainActivity"
        fun startOpenCV(){
            if(OpenCVLoader.initDebug()) {
                Log.d(TAG, "OpenCV installed successfully");
            } else {
                Log.d(TAG, "OpenCV not installed");
            }
        }
    }
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val myDrawable: Drawable? = ContextCompat.getDrawable(applicationContext, R.drawable.id2)
        val bitmap: Bitmap = (myDrawable as BitmapDrawable).bitmap
        val result = MImageBlurDetection.isBlurredImage(image = bitmap)

        println("result: $result")

    }
}