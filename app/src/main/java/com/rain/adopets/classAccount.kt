package com.rain.adopets

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class classAccount(
    var id : Int,
    var userName: String,
    var password: String,
    var fullName: String,
    var email: String,
    var cartContent: MutableList<classItemBasket>,
    var shippingAddress : String = "",
    var phoneNumber : String = ""
) : Parcelable