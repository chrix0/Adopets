package com.rain.adopets

import java.util.*

data class classTransaction(
    var items: MutableList<classItemBasket>,
    var method: String,
    var address: String,
    var phoneNumber: String,
    var datePurchase : Date
)