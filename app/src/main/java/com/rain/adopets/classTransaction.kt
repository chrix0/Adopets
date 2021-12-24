package com.rain.adopets

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.time.LocalDate
import java.util.*

@Parcelize
data class classTransaction(
    var items: MutableList<classItemBasket> = mutableListOf(),
    var method: String = "",
    var address: MutableList<String> = mutableListOf(),
    var phoneNumber: String = "",
    var datePurchase : String = "",
    var subTotal : Int = 0,
    var shippingCost : Int = 0,
    var Total : Int = 0
) : Parcelable