package com.rain.adopets

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class classBreed(
    var id:Int,
    var nama:String,
    var tipe:String,
    var jenKel:String,
    var lokasi:String,
    var desk:String,
    var pic:String,
    var price:String,
    var health:String,
    ) : Parcelable