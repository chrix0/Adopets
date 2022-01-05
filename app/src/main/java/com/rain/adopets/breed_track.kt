package com.rain.adopets

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_adopt_track.*
import kotlinx.android.synthetic.main.activity_adopt_track.home
import kotlinx.android.synthetic.main.activity_breed_track.*
import java.text.DecimalFormat
import java.util.*

class breed_track : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breed_track)
        val actionbar = supportActionBar
        actionbar!!.title = "Track"
        actionbar.setDisplayHomeAsUpEnabled(true)
        home.setOnClickListener(){
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra(RETURN_LAST_TAB,"BREED")
            var data = singletonData.curBreeding
            var curDate = Calendar.getInstance()
            var year = curDate.get(Calendar.YEAR)
            var month = curDate.get(Calendar.MONTH)
            var day = curDate.get(Calendar.DAY_OF_MONTH)
            var hour = curDate.get(Calendar.HOUR_OF_DAY)
            var minute = curDate.get(Calendar.MINUTE)
            singletonData.breedHistory.add(
                classBreedHistory(
                    singletonData.adoptHistory.size+1,
                    data.nama,
                    data.jenKel,
                    data.lokasi,
                    data.price,
                    "${day}-${month}-${year} ${DecimalFormat("00").format(hour)}:${DecimalFormat("00").format(minute)}",
                    data.pic
                )
            )
            startActivity(intent)
        }
        cancelx.setOnClickListener(){
            var dialog = AlertDialog.Builder(this)
                .setTitle("Cancel the order?")
                .setPositiveButton("OK", DialogInterface.OnClickListener{ dialogInterface, i ->
                    var intent = Intent(this, MainActivity::class.java)
                    intent.putExtra(RETURN_LAST_TAB,"BREED")
                    startActivity(intent)
                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener{ dialogInterface, i ->
                })
            dialog.show()
        }
    }
}