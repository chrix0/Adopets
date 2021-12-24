package com.rain.adopets

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_shop_checkout.*
import kotlinx.android.synthetic.main.activity_shop_checkout.subtotal
import java.util.*

class shop_checkout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_checkout)

        val user = singletonData.accList[singletonData.currentAccId]
        var curDate = Calendar.getInstance()
        var year = curDate.get(Calendar.YEAR)
        var month = curDate.get(Calendar.MONTH)
        var day = curDate.get(Calendar.DAY_OF_MONTH)
        //HOUR = 1 - 12, HOUR_OF_DAY = 24
        var hour = curDate.get(Calendar.HOUR_OF_DAY)
        var minute = curDate.get(Calendar.MINUTE)

        var transaksi : classTransaction = classTransaction(datePurchase = "$day-${month}-${year} ${hour}:${minute}")

        val promptAddress : String = "(Please tap the edit button to input your address)"
        val promptPhone : String = "(Please tap the edit button to input your phone number)"

        if(user.shippingAddress.equals("")){
            alamat.setText(promptAddress)
        }
        else{
            transaksi.address = user.shippingAddress
            alamat.setText(user.shippingAddress)
        }

        if(user.phoneNumber.equals("")){
            alamat.setText(promptPhone)
        }
        else{
            transaksi.phoneNumber = user.phoneNumber
            alamat.setText(user.phoneNumber)
        }

        kartu.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                transaksi.method = kartu.text.toString()
            }
        }

        virtual.setOnCheckedChangeListener { compoundButton, b ->
            if(b){
                transaksi.method = virtual.text.toString()
            }
        }

        ubahAlamat.setOnClickListener {
            var layout = layoutInflater.inflate(R.layout.dialog_shop_checkout_address,null)
            var dialog = AlertDialog.Builder(this).apply{
                setView(layout)
                setTitle("Change Shipping Address")
            }
            var creator = dialog.create()

            var address = layout.findViewById<EditText>(R.id.tbAddress)
            var province = layout.findViewById<EditText>(R.id.tbProvince)
            var city = layout.findViewById<EditText>(R.id.tbCity)
            var postal = layout.findViewById<EditText>(R.id.tbPostal)
            var done = layout.findViewById<Button>(R.id.saveAddress)

            done.setOnClickListener {
                if(address.text.toString().equals("")
                    || province.text.toString().equals("")
                    || city.text.toString().equals("")
                    || postal.text.toString().equals("")
                ){
                    Toast.makeText(this,"You need to fill every field.",Toast.LENGTH_SHORT)
                }
                else{
                    user.shippingAddress = "${address.text.toString()}, ${city.text.toString()}, ${province.text.toString()}, ID ${postal.text.toString()}"
                    singletonData.accList[singletonData.currentAccId].shippingAddress = user.shippingAddress
                    transaksi.phoneNumber = user.shippingAddress
                    alamat.setText(user.shippingAddress)
                    Toast.makeText(this,"Your address has been successfully updated.",Toast.LENGTH_SHORT)
                    creator.cancel()
                }
            }

            creator.show()
        }

        ubahTelp.setOnClickListener {
            var layout = layoutInflater.inflate(R.layout.dialog_shop_checkout_phone,null)
            var dialog = AlertDialog.Builder(this).apply{
                setView(layout)
                setTitle("Change Phone Number")
            }
            var creator = dialog.create()

            var phone = layout.findViewById<EditText>(R.id.tbPhoneNumber)
            var done = layout.findViewById<Button>(R.id.savePhone)
            var cancel = layout.findViewById<Button>(R.id.cancelPhone)

            //Code here
            done.setOnClickListener {
                if(phone.text.toString().equals("")){
                    Toast.makeText(this,"You need to enter your phone number.",Toast.LENGTH_SHORT)
                }
                else{
                    user.phoneNumber = phone.text.toString()
                    singletonData.accList[singletonData.currentAccId].phoneNumber = user.phoneNumber
                    transaksi.phoneNumber = user.phoneNumber
                    telp.setText(user.phoneNumber)
                    Toast.makeText(this,"Your phone number has been successfully updated.",Toast.LENGTH_SHORT)
                    creator.cancel()
                }
            }

            creator.show()

        }

        var ongkos : Int = 5000
        subtotal.setText("Rp." +singletonData.formatHarga(singletonData.subtotalInCart()))
        ongkir.setText(singletonData.formatHarga(ongkos))
        total.setText(singletonData.formatHarga(singletonData.totalInCart()))
    }
}