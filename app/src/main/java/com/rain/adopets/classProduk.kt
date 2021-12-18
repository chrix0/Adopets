package com.rain.adopets

import android.graphics.drawable.Drawable
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class classProduk(
    var idProduk : Int ,var namaProduk : String,
    var hargaProduk : Int, var urlGambarProduk : String,
    var description : String) : Parcelable