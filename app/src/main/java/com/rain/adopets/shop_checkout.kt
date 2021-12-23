package com.rain.adopets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_shop_checkout.*

class shop_checkout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_checkout)

        val user = singletonData.accList[singletonData.currentAccId]
        val promptAddress : String = "(Please tap the edit button to input your address)"
        val promptPhone : String = "(Please tap the edit button to input your phone number)"

        if(user.shippingAddress.equals("")){
            alamat.setText(promptAddress)
        }
        else{
            alamat.setText(user.shippingAddress)
        }

        if(user.phoneNumber.equals("")){
            alamat.setText(promptPhone)
        }
        else{
            alamat.setText(user.phoneNumber)
        }

    }

}