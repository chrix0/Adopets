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
        /*
        var target = object : Target {
              override fun onBitmapLoaded(bitmap: Bitmap, from: Picasso.LoadedFrom) {
                  urlBitmap = bitmap
              }

              override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
              }
              //Parameter placeholdernya perlu diberi null safety.. karena ketika dijalankan placeholdernya dicari ..
              override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
              }
        }
        Picasso.get().load(urlGambarProduk).into(target)
         */
        val getBitmap = Picasso.get().load(urlGambarProduk).get()
        Thread.sleep(500)
        return getBitmap
    }
}