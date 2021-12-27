package com.rain.adopets

import android.graphics.Bitmap
import dev.jorgecastillo.androidcolorx.library.HEXColor

class classOASession{
    lateinit var petPic : Bitmap
    lateinit var outiftPic : Bitmap
    lateinit var petHex : HEXColor
    lateinit var outfitHex : HEXColor
    lateinit var rec : MutableList<HEXColor>
    lateinit var similiar : MutableList<Int>
}

