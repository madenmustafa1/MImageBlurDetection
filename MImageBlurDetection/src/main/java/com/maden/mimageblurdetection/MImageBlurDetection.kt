package com.maden.mimageblurdetection

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import org.opencv.android.OpenCVLoader
import org.opencv.android.Utils
import org.opencv.core.CvType
import org.opencv.core.Mat
import org.opencv.imgproc.Imgproc

object MImageBlurDetection {
    init {
        startOpenCV()
    }

    private const val TAG = "MImageBlurDetection"
    private fun startOpenCV(){
        if(OpenCVLoader.initDebug()) {
            Log.d(TAG, "OpenCV installed successfully");
        } else {
            Log.d(TAG, "OpenCV not installed");
        }
    }


    @Synchronized
    fun isBlurredImage(image: Bitmap): Boolean {
        return try {
            val opt = BitmapFactory.Options()
            opt.inDither = true
            opt.inPreferredConfig = Bitmap.Config.ARGB_8888
            val l = CvType.CV_8UC1
            val matImage = Mat()
            Utils.bitmapToMat(image, matImage)
            val matImageGrey = Mat()
            Imgproc.cvtColor(matImage, matImageGrey, Imgproc.COLOR_BGR2GRAY)
            val dst2 = Mat()
            Utils.bitmapToMat(image, dst2)
            val laplacianImage = Mat()
            dst2.convertTo(laplacianImage, l)
            Imgproc.Laplacian(matImageGrey, laplacianImage, CvType.CV_8U)
            val laplacianImage8bit = Mat()
            laplacianImage.convertTo(laplacianImage8bit, l)
            System.gc()
            val bmp = Bitmap.createBitmap(
                laplacianImage8bit.cols(),
                laplacianImage8bit.rows(), Bitmap.Config.ARGB_8888
            )
            Utils.matToBitmap(laplacianImage8bit, bmp)
            val pixels = IntArray(bmp!!.height * bmp.width)
            bmp.getPixels(
                pixels, 0, bmp.width, 0, 0, bmp.width,
                bmp.height
            )
            if (bmp != null) if (!bmp.isRecycled) {
                bmp.recycle()
            }
            var maxLap = -16777216
            for (i in pixels.indices) {
                if (pixels[i] > maxLap) {
                    maxLap = pixels[i]
                }
            }
            val soglia = -6118750
            maxLap < soglia || maxLap == soglia
        } catch (e: NullPointerException) {
            false
        } catch (e: OutOfMemoryError) {
            false
        }
    }
}