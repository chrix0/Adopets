package com.rain.adopets

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class classWiki(
    var id:Int,
    var nama:String,
    var desk:String,
    var pic:String,
    var desk2:String,
    var pic2:String,
    var tipe:String,
    var pic3:String
) : Parcelable