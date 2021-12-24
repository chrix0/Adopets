package com.rain.adopets

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class classAdopt(var id:Int, var nama:String, var tipe:String, var jenKel:String, var lokasi:String, var desk:String, var pic:String):
    Parcelable