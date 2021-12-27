package com.rain.adopets

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.jorgecastillo.androidcolorx.library.*
import kotlinx.android.synthetic.main.activity_oa_result.*
import kotlinx.android.synthetic.main.activity_shop_checkout.*

class OA_result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oa_result)

        val actionbar = supportActionBar
        actionbar!!.title = "Analysis Result"
        actionbar.setDisplayHomeAsUpEnabled(true)

        imagePet.setImageBitmap(singletonData.OASession.petPic)
        imageOutfit.setImageBitmap(singletonData.OASession.outiftPic)

        var petHex = Color.parseColor("${singletonData.OASession.petHex}")
        var outfitHex = Color.parseColor("${singletonData.OASession.outfitHex}")

        val compliment = petHex.complimentary()
        val analogous = petHex.analogous()
        singletonData.OASession.rec.addAll(mutableListOf(compliment.asHex(),
            analogous.first.asHex(), analogous.second.asHex()))

        var rec = singletonData.OASession.rec
        var rgb1 = outfitHex.asRgb()


        var Over85 = false
        for (i : HEXColor in rec){
            var rgb2 = i.asRgb()
            var r = Math.abs(rgb1.red - rgb2.red)
            var g = Math.abs(rgb1.green - rgb2.green)
            var b = Math.abs(rgb1.blue - rgb2.blue)

            var pR = (r / 255)
            var pG = (g / 255)
            var pB = (b / 255)

            var similiarity : Int = 100 - ((pR + pG + pB) / 3 * 100)

            if(similiarity >= 85){
                Over85 = true
            }
            singletonData.OASession.similiar.add(similiarity)
        }

        var sim =  singletonData.OASession.similiar

        color1.setBackgroundColor(Color.parseColor("${rec[0]}"))
        color2.setBackgroundColor(Color.parseColor("${rec[1]}"))
        color3.setBackgroundColor(Color.parseColor("${rec[2]}"))
        color1.text = "${sim[0].toString()}"
        color2.text = "${sim[1].toString()}"
        color3.text = "${sim[2].toString()}"

        when(Over85){
            true ->{
                resultTitle.text = "PASS"
                resultTitle.setTextColor(Color.GREEN)
                resultExplain.text = "Your color choice of your pet's outfit looks good! You can check for more outfits by pressing the button below."
            }
            else ->{
                resultTitle.text = "FAULTY"
                resultTitle.setTextColor(Color.RED)
                resultExplain.text = "Your color choice of your pet's outfit seems to be unsuitable. You can follow one of the recommended colors or tap the button below to check for outfits which are suitable for yout pet! "
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}