package com.rain.adopets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Target
import android.graphics.drawable.Drawable

import com.squareup.picasso.Picasso

import android.graphics.Bitmap
import androidx.palette.graphics.Palette
import com.squareup.picasso.Picasso.LoadedFrom
import dev.jorgecastillo.androidcolorx.library.RGBColor
import dev.jorgecastillo.androidcolorx.library.asRgb
import java.lang.Exception


class oa_recommend : AppCompatActivity() {

    public lateinit var urlBitmap : Bitmap
    var petColor = singletonData.OASession.petHex.asRgb()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oa_recommend)
    }

    fun createPaletteSync(bitmap: Bitmap): Palette = Palette.from(bitmap).maximumColorCount(16).generate()

    fun checkColor(color : Int) : MutableList<classProduk> {
        var temp : MutableList<classProduk> = mutableListOf()

        for(i : classProduk in singletonData.petOutfitList){
            lateinit var takeBitmap: Bitmap

            var target = object : Target {
                override fun onBitmapLoaded(bitmap: Bitmap, from: LoadedFrom) {
                    urlBitmap = bitmap
                }

                override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                }

                override fun onPrepareLoad(placeHolderDrawable: Drawable) {
                }
            }

            Picasso.get().load(i.urlGambarProduk).into(target)

            var color = createPaletteSync(urlBitmap)
            var dominantItemColor = color.dominantSwatch!!.rgb.asRgb()

            if (calculate(petColor, dominantItemColor)){
                temp.add(i)
            }
        }

        return temp
    }

    fun calculate(rgb1 : RGBColor, rgb2 : RGBColor) : Boolean{
        var r = Math.abs(rgb1.red - rgb2.red)
        var g = Math.abs(rgb1.green - rgb2.green)
        var b = Math.abs(rgb1.blue - rgb2.blue)

        var pR : Float= (r / 255f)
        var pG : Float= (g / 255f)
        var pB : Float= (b / 255f)

        var similiarity : Float = 100f - ((pR + pG + pB) / 3 * 100)

        if(similiarity >= 85){
            return true
        }
        return false
    }
}