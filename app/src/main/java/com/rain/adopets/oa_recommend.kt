package com.rain.adopets

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Target
import android.graphics.drawable.Drawable

import com.squareup.picasso.Picasso

import android.graphics.Bitmap
import android.os.AsyncTask
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso.LoadedFrom
import dev.jorgecastillo.androidcolorx.library.RGBColor
import dev.jorgecastillo.androidcolorx.library.asRgb
import kotlinx.android.synthetic.main.activity_oa_recommend.*
import java.lang.Exception
import kotlinx.coroutines.*

@Suppress("DEPRECATION")
class oa_recommend : AppCompatActivity() {
    // Need fix:
    // - Add async or find better solution ok
    // - Purchase history, time msh blm dalam bentuk 00:00 ok
    // - Fix ukuran gambar di recycler products ok

    var petColor = singletonData.OASession.petHex.asRgb()

    var firstnAnalog = mutableListOf<classProduk>()
    var firstnComplement = mutableListOf<classProduk>()

    lateinit var context : Context

    @Suppress("DEPRECATED")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oa_recommend)

        context = this
        Async().execute()
    }

    inner class Async : AsyncTask<Void,Void,Unit>(){
        var dialog = ProgressDialog(context);
        override fun doInBackground(vararg p0: Void?): Unit? {
            if (!singletonData.allImageProcessed){
                for(i in 0 until singletonData.petOutfitList.size){
                    singletonData.petOutfitList[i].savedBitmap = singletonData.petOutfitList[i].getBitmapBackground()
                }
                singletonData.allImageProcessed = true
            }
            firstnAnalog = checkColor(singletonData.OASession.rec[0].asRgb())
            firstnComplement = mutableListOf()
            firstnComplement.addAll(checkColor(singletonData.OASession.rec[1].asRgb()))
            firstnComplement.removeAll(checkColor(singletonData.OASession.rec[2].asRgb()))
            firstnComplement.addAll(checkColor(singletonData.OASession.rec[2].asRgb()))

            return null
        }
        override fun onPreExecute() {
            super.onPreExecute()
            dialog.setMessage("Processing.. \nDo not worry. It will be faster next time.")
            dialog.setCancelable(false)
            dialog.show()
        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)
            if (dialog.isShowing()) {
                dialog.dismiss();
            }

            var analog = recycler_products_adapter(firstnAnalog){
                val info = Intent(context, shop_infoProduk::class.java)
                info.putExtra(SHOW_PRODUCT_INFO, it)
                info.putExtra(CHANGE_TITLE,"Product Info")
                startActivity(info)
            }
            itemAnalog.adapter = analog
            itemAnalog.layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL, false)

            var comp = recycler_products_adapter(firstnComplement){
                val info = Intent(context, shop_infoProduk::class.java)
                info.putExtra(SHOW_PRODUCT_INFO, it)
                info.putExtra(CHANGE_TITLE,"Product Info")
                startActivity(info)
            }
            itemComp.adapter = comp
            itemComp.layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL, false)

        }
    }

    fun createPaletteSync(bitmap: Bitmap): Palette = Palette.from(bitmap).maximumColorCount(16).generate()

    fun checkColor(color : RGBColor) : MutableList<classProduk> {
        var temp : MutableList<classProduk> = mutableListOf()
        var loaded = true

        for(i : classProduk in singletonData.petOutfitList){
            /*
            var loaded = false
            var target = object : Target {
                override fun onBitmapLoaded(bitmap: Bitmap, from: LoadedFrom) {
                    urlBitmap = bitmap
                    loaded = true
                }

                override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                }
                //Parameter placeholdernya perlu diberi null safety.. karena ketika dijalankan placeholdernya dicari ..
                override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                }
            }

            Picasso.get().load(i.urlGambarProduk).into(target)
            Thread.sleep(1000)
         */
             /*
            if(loaded){
                var color = createPaletteSync(urlBitmap!!)
                var dominantItemColor = color.dominantSwatch!!.rgb.asRgb()

                if (judge(petColor, dominantItemColor)){
                    temp.add(i)
                }
            }
              */
            if(loaded){
                var color = createPaletteSync(i.savedBitmap!!)
                var dominantItemColor = color.dominantSwatch!!.rgb.asRgb()

                if (judge(petColor, dominantItemColor)){
                    temp.add(i)
                }
            }
        }
        return temp
    }

    fun judge(rgb1 : RGBColor, rgb2 : RGBColor) : Boolean{

        var focus = ""
        var rgbof2 = mutableListOf<Int>(rgb2.red, rgb2.green, rgb2.blue)
        var copy = rgbof2.sortedBy { it }
        var maxIndex = rgbof2.indexOf(copy[0])

        focus = when(maxIndex){
            0 -> "RED"
            1 -> "GREEN"
            2 -> "BLUE"
            else -> "ANY"
        }

        var r = Math.abs(rgb1.red - rgb2.red)
        var g = Math.abs(rgb1.green - rgb2.green)
        var b = Math.abs(rgb1.blue - rgb2.blue)

        var pR : Float= (r / 255f)
        var pG : Float= (g / 255f)
        var pB : Float= (b / 255f)

        var similiarity : Float = 100f - ((pR + pG + pB) / 3 * 100)

        if(similiarity >= 80){
            return true
        }

        return false
    }
}