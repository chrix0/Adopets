package com.rain.adopets

import android.graphics.Bitmap
import androidx.palette.graphics.Palette
import com.google.gson.Gson
import dev.jorgecastillo.androidcolorx.library.HEXColor
import dev.jorgecastillo.androidcolorx.library.RGBColor
import dev.jorgecastillo.androidcolorx.library.asHex
import dev.jorgecastillo.androidcolorx.library.asRgb
import java.text.DecimalFormat
import java.text.NumberFormat

object singletonData {

    //1. DATABASE + METHOD FITUR =============================================

    // LOGIN SIGNUP + BASKET
    var accList : MutableList<classAccount> = mutableListOf(
        classAccount(
            0,
            "TESTACCOUNT",
            "TEST",
            "Test Account",
            "testaccount@gmail.com",
            mutableListOf(),
            mutableListOf(),
            "",
            mutableListOf()
        )
    )

    var currentAccId : Int = 0

    fun subtotalInCart() : Int{
        var total = 0
        for (i : classItemBasket in accList[currentAccId].cartContent){
            total += i.hargaProduk * i.quantity
        }
        return total
    }

    fun totalInCart() : Int = subtotalInCart() + 5000

    // SHOP PRODUCTS
    var petFoodList : MutableList<classProduk> = mutableListOf(
        classProduk(
            1,
            "Royal Canin Veterinary Dog - Hypoallergenic DR 21 2kg",
            390000,
            "https://shop-cdn-m.mediazs.com/bilder/royal/canin/veterinary/dog/hypoallergenic/dr/4/400/81168_elvetis_royalcanin_veterinaydiet_hypoallergenic_4.jpg",
            "Complete dry food for dogs over one year, with food intolerances. Especially formulated to reduce ingredient and nutrient intolerances. With selected sources of protein and carbohydrate",
        ),
        classProduk(
            2,
            "Royal Canin Maxi Adult 4kg",
            340000,
            "https://shop-cdn-m.mediazs.com/bilder/royal/canin/maxi/adult/8/400/80729_pla_royalcanin_maxiadult_15kg_hs_01_8.jpg",
            "Balanced dry food for large dogs (26-45kg) between the ages of 15 months and 5 years, designed to support a healthy immune system and smooth joint function, with extra large kibble and weight control.",
        ),
        classProduk(
            3,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        //Add stuff
        classProduk(
            4,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        classProduk(
            5,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        classProduk(
            6,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        classProduk(
            7,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        classProduk(
            8,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        )
    )

    var petUtensilList : MutableList<classProduk> = mutableListOf(
        classProduk(
            1,
            "Royal Canin Veterinary Dog - Hypoallergenic DR 21 2kg",
            390000,
            "https://shop-cdn-m.mediazs.com/bilder/royal/canin/veterinary/dog/hypoallergenic/dr/4/400/81168_elvetis_royalcanin_veterinaydiet_hypoallergenic_4.jpg",
            "Complete dry food for dogs over one year, with food intolerances. Especially formulated to reduce ingredient and nutrient intolerances. With selected sources of protein and carbohydrate",
        ),
        classProduk(
            2,
            "Royal Canin Maxi Adult 4kg",
            340000,
            "https://shop-cdn-m.mediazs.com/bilder/royal/canin/maxi/adult/8/400/80729_pla_royalcanin_maxiadult_15kg_hs_01_8.jpg",
            "Balanced dry food for large dogs (26-45kg) between the ages of 15 months and 5 years, designed to support a healthy immune system and smooth joint function, with extra large kibble and weight control.",
        ),
        classProduk(
            3,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        //Add stuff
        classProduk(
            4,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        classProduk(
            5,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        classProduk(
            6,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        classProduk(
            7,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        classProduk(
            8,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        )
    )


    var petOutfitList : MutableList<classProduk> = mutableListOf(
        classProduk(
            1,
            "Royal Canin Veterinary Dog - Hypoallergenic DR 21 2kg",
            390000,
            "https://shop-cdn-m.mediazs.com/bilder/royal/canin/veterinary/dog/hypoallergenic/dr/4/400/81168_elvetis_royalcanin_veterinaydiet_hypoallergenic_4.jpg",
            "Complete dry food for dogs over one year, with food intolerances. Especially formulated to reduce ingredient and nutrient intolerances. With selected sources of protein and carbohydrate",
        ),
        classProduk(
            2,
            "Royal Canin Maxi Adult 4kg",
            340000,
            "https://shop-cdn-m.mediazs.com/bilder/royal/canin/maxi/adult/8/400/80729_pla_royalcanin_maxiadult_15kg_hs_01_8.jpg",
            "Balanced dry food for large dogs (26-45kg) between the ages of 15 months and 5 years, designed to support a healthy immune system and smooth joint function, with extra large kibble and weight control.",
        ),
        classProduk(
            3,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        //Add stuff
        classProduk(
            4,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        classProduk(
            5,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        classProduk(
            6,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        classProduk(
            7,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        classProduk(
            8,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        )
    )

    //Outfit Analyzer (Untuk memudahkan resetting aja)
    lateinit var OASession : classOASession

    // Adopt
    var adoptList : MutableList<classAdopt> = mutableListOf(
        classAdopt(
            1,
            "Lord Umam",
            "Ginger Cat",
            "Male",
            "Medan, Indonesia",
            "A cat is a furry animal that has a long tail and sharp claws. Cats are often kept as pets. 2. countable noun. Cats are lions, tigers, and other wild animals in the same family.",
            "https://www.kucinglucu.net/wp-content/uploads/2018/05/kucing-ngeselin07.jpg"
        ),
        classAdopt(
            2,
            "Lord Umam",
            "Ginger Cat",
            "Male",
            "Medan, Indonesia",
            "A cat is a furry animal that has a long tail and sharp claws. Cats are often kept as pets. 2. countable noun. Cats are lions, tigers, and other wild animals in the same family.",
            "https://www.kucinglucu.net/wp-content/uploads/2018/05/kucing-ngeselin07.jpg"
        ),
        classAdopt(
            3,
            "Joe",
            "Random Dog",
            "Male",
            "Medan, Indonesia",
            "A dog is not a furry animal that has a long tail and sharp claws. Cats are often kept as pets. 2. countable noun. Cats are lions, tigers, and other wild animals in the same family.",
            "https://images.unsplash.com/photo-1516222338250-863216ce01ea?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Y29vbCUyMGRvZ3xlbnwwfHwwfHw%3D&w=1000&q=80"
        ),
        classAdopt(
            4,
            "Joe",
            "Random Dog",
            "Male",
            "Medan, Indonesia",
            "A dog is not a furry animal that has a long tail and sharp claws. Cats are often kept as pets. 2. countable noun. Cats are lions, tigers, and other wild animals in the same family.",
            "https://images.unsplash.com/photo-1516222338250-863216ce01ea?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Y29vbCUyMGRvZ3xlbnwwfHwwfHw%3D&w=1000&q=80"
        )
    )
    var currentAdoptId : Int = 0
    //2. UNIVERSAL METHOD + LIBRARY INIT ============================================

    fun formatHarga(harga : Int) : String{
        var formatter : DecimalFormat = NumberFormat.getInstance() as DecimalFormat
        formatter.applyPattern("#,###")
        return formatter.format(harga)
    }

    fun formatAlamat(alamat : MutableList<String>) = "${alamat[0]}, ${alamat[1]}, ${alamat[2]}, ID ${alamat[3]}"

    //Ini dipakai ketika mau ubah objek jadi JSON biar pengiriman data ke activity lain lebih gampang.
    val toJson : Gson = Gson()

    //Analyzer. Sering dipake return nilai RGB.
    /*
    fun colorCheck(pic : Bitmap) : Int{
        // Fungsi untuk mengenerate palette
        fun createPaletteSync(bitmap: Bitmap): Palette = Palette.from(bitmap).maximumColorCount(8).generate()
        var color = createPaletteSync(pic)

        var dominant = color.dominantSwatch!!.rgb
        return dominant
    }
    */

}