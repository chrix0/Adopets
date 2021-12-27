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
            9,
            "Royal Canin Veterinary Dog - Hypoallergenic DR 21 2kg",
            390000,
            "https://shop-cdn-m.mediazs.com/bilder/royal/canin/veterinary/dog/hypoallergenic/dr/4/400/81168_elvetis_royalcanin_veterinaydiet_hypoallergenic_4.jpg",
            "Complete dry food for dogs over one year, with food intolerances. Especially formulated to reduce ingredient and nutrient intolerances. With selected sources of protein and carbohydrate",
        ),
        classProduk(
            10,
            "Royal Canin Maxi Adult 4kg",
            340000,
            "https://shop-cdn-m.mediazs.com/bilder/royal/canin/maxi/adult/8/400/80729_pla_royalcanin_maxiadult_15kg_hs_01_8.jpg",
            "Balanced dry food for large dogs (26-45kg) between the ages of 15 months and 5 years, designed to support a healthy immune system and smooth joint function, with extra large kibble and weight control.",
        ),
        classProduk(
            11,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        //Add stuff
        classProduk(
            12,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        classProduk(
            13,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        classProduk(
            14,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        classProduk(
            15,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        classProduk(
            16,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        )
    )


    var petOutfitList : MutableList<classProduk> = mutableListOf(
        classProduk(
            17,
            "Hotel Doggy Utilty Style Dog Puffer Coat, Orange Rust - X-Small",
            430000,
            "https://img.chewy.com/is/catalog/289551_MAIN._AC_SY300_V1635447081_.jpg",
            "Remember to measure your pet for the paw-fect fit. Your dog will be the coolest canine on the block wearing this Hotel Doggy Utility Style Dog Puffer! This corduroy jacket and fleece hoody is made from polyester and has a warm lining to keep your buddy nice and cozy during those colder months. The Hotel Doggy Utility Dog Coat is the perfect statement piece for daily walks.",
        ),
        classProduk(
            18,
            "Frisco Dog & Cat Cable Knitted Sweater - Medium",
            180000,
            "https://img.chewy.com/is/catalog/144255_MAIN._AC_SY300_V1575302596_.jpg",
            "Remember to measure your pet for the paw-fect fit. Now your pal can stay comfy while looking dapper with the Frisco Dog & Cat Cable Knitted Sweater. This high-quality knit sweater is ultra-soft and warm so it’s perfect for chillier nights, and is easy to put on thanks to the pullover design. Dress up your pooch or kitty in this classic fashion staple whenever you’re going out or enjoying a cozy night in. Go ahead—cuddle up! This sweater feels luxuriously soft to the touch and looks just as stylish.",
        ),
        classProduk(
            19,
            "Frisco Dog & Cat Cozy Plush Fleece PJs, Llamas - Medium",
            190000,
            "https://img.chewy.com/is/catalog/268486_MAIN._AC_SY300_V1637728623_.jpg",
            "Maximize your pet’s coziness with these PJs you and your pet will both adore. They’re made of soft, thick polyester, and they fit snugly for your pet’s comfort. Plus, these jammies help limit excess shedding around the house by trapping your pet’s hair and dander, and they’ve got an adorable llama design to keep them looking cute while they cozy up and smile for their closeups during all your themed photo ops.",
        ),
        //Add stuff
        classProduk(
            20,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete`` adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        classProduk(
            21,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        classProduk(
            22,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        classProduk(
            23,
            "Animonda vom Feinsten Adult Grain-Free (Poultry & Veal) 6 x 150g",
            98000,
            "https://shop-cdn-m.mediazs.com/bilder/animonda/vom/feinsten/adult/grainfree/x/g/8/400/80676_pla_animonda_vomfeinsten_adult_mitgefluegel_kalb_150g_hs_01_8.jpg",
            "Complete adult dog food with plenty of meat. No added grain or soya, very tasty with high quality meat. Even for food-sensitive dogs & no artificial additives.",
        ),
        classProduk(
            24,
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