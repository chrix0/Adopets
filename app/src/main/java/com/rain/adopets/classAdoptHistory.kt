package com.rain.adopets

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class classAdoptHistory(
    var id:Int,
    var nama:String,
    var jenKel:String,
    var lokasi:String,
    var date:String,
    var pic:String
    ):
    Parcelable