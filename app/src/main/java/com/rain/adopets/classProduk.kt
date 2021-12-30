package com.rain.adopets

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Parcelable
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
import java.lang.Exception

@Parcelize
class classProduk(var idProduk: Int,
                  var namaProduk: String,
                  var hargaProduk: Int,
                  var urlGambarProduk: String,
                  var description: String ): Parcelable {

    var savedBitmap : Bitmap? = null

    fun getBitmapBackground() : Bitmap{
        var getBitmap = Picasso.get().load(urlGambarProduk).get()
        Thread.sleep(700)
        getBitmap = singletonData.cropThis(getBitmap)
        return getBitmap
    }
}