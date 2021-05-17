package com.example.mvpexample.data.source.remote.helper

import android.graphics.Bitmap

import android.graphics.BitmapFactory

import android.os.AsyncTask
import android.widget.ImageView
import java.io.IOException
import java.io.InputStream
import java.lang.ref.WeakReference
import java.net.URL

class LoadImageTask constructor(imageView: ImageView) :
    AsyncTask<String, Unit, Bitmap?>() {

    private var imageViewWeakReference: WeakReference<ImageView>? = null

    init {
        imageViewWeakReference = WeakReference(imageView)
    }

    override fun doInBackground(vararg strings: String): Bitmap? {
        var bitmap: Bitmap? = null
        try {
            val inputStream: InputStream = URL(strings[0]).openStream()
            bitmap = BitmapFactory.decodeStream(inputStream)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return bitmap
    }

    override fun onPostExecute(bitmap: Bitmap?) {
        bitmap?.let {
            imageViewWeakReference?.get()?.setImageBitmap(bitmap)
        }
    }

}
