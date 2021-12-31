package com.rain.adopets

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_adopt_form.*
import kotlinx.android.synthetic.main.activity_adopt_track.*
import kotlinx.android.synthetic.main.activity_adopt_track.home
import kotlinx.android.synthetic.main.activity_breed_track.*

class adopt_track : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adopt_track)
        val actionbar = supportActionBar
        actionbar!!.title = "Track"
        home.setOnClickListener(){
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra(RETURN_LAST_TAB,"ADOPT")
            startActivity(intent)
        }
        cancelxy.setOnClickListener(){
            var dialog = AlertDialog.Builder(this)
                .setTitle("Cancel the adopt?")
                .setPositiveButton("OK", DialogInterface.OnClickListener{ dialogInterface, i ->
                    var intent = Intent(this, MainActivity::class.java)
                    intent.putExtra(RETURN_LAST_TAB,"ADOPT")
                    startActivity(intent)
                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener{ dialogInterface, i ->
                })
            dialog.show()
        }
    }
}