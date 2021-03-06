package com.rain.adopets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarMenuView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.fragmentContainerView)
        navBottom.setupWithNavController(navController)

        navController.navigate(R.id.adopt_Main_Frag)
        titleText.text = getString(R.string.adopt)

        navBottom.setOnItemSelectedListener {
            when(it.itemId){
                R.id.adopt_Main_Frag -> {
                    navController.navigate(R.id.adopt_Main_Frag)
                    titleText.text = getString(R.string.adopt)
                    true
                }
                R.id.breed_Main_Frag -> {
                    navController.navigate(R.id.breed_Main_Frag)
                    titleText.text = getString(R.string.breed)
                    true
                }
                R.id.profile_Main_Frag -> {
                    navController.navigate(R.id.profile_Main_Frag)
                    titleText.text = getString(R.string.profile)
                    true
                }
                R.id.shop_Main_Frag -> {
                    navController.navigate(R.id.shop_Main_Frag)
                    titleText.text = getString(R.string.shop)
                    true
                }
                R.id.wiki_Main_Frag -> {
                    navController.navigate(R.id.wiki_Main_Frag)
                    titleText.text = getString(R.string.wiki)
                    true
                }
                else ->
                    false
            }
        }

        var intentData = intent
        when(intentData.hasExtra(RETURN_LAST_TAB)){
            (intentData.getStringExtra(RETURN_LAST_TAB).equals("SHOP")) -> {
                navBottom.selectedItemId = R.id.shop_Main_Frag
            }
            (intentData.getStringExtra(RETURN_LAST_TAB).equals("ADOPT")) -> {
                navBottom.selectedItemId = R.id.adopt_Main_Frag
            }
            (intentData.getStringExtra(RETURN_LAST_TAB).equals("BREED")) -> {
                navBottom.selectedItemId = R.id.breed_Main_Frag
            }

            (intentData.getStringExtra(RETURN_LAST_TAB).equals("PROFILE")) -> {
                navBottom.selectedItemId = R.id.profile_Main_Frag
            }
        }
    }
}