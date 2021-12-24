package com.rain.adopets

import java.time.LocalDate
import java.util.*

data class classTransaction(
    var items: MutableList<classItemBasket> = mutableListOf(),
    var method: String = "",
    var address: String = "",
    var phoneNumber: String = "",
    var datePurchase : String = ""
)