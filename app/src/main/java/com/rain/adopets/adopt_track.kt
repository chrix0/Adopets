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
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

class adopt_track : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adopt_track)
        val actionbar = supportActionBar
        actionbar!!.title = "Track"
        val sdf = SimpleDateFormat("dd/M/yyyy")
        home.setOnClickListener(){
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra(RETURN_LAST_TAB,"ADOPT")
            var data = singletonData.curAdopting
            var curDate = Calendar.getInstance()
            var year = curDate.get(Calendar.YEAR)
            var month = curDate.get(Calendar.MONTH)
            var day = curDate.get(Calendar.DAY_OF_MONTH)
            //HOUR = 1 - 12, HOUR_OF_DAY = 24
            var hour = curDate.get(Calendar.HOUR_OF_DAY)
            var minute = curDate.get(Calendar.MINUTE)
            singletonData.adoptHistory.add(
                classAdoptHistory(
                    singletonData.adoptHistory.size+1,
                    data.nama,
                    data.jenKel,
                    data.lokasi,
                    "${day}-${month}-${year} ${DecimalFormat("00").format(hour)}:${DecimalFormat("00").format(minute)}",
                    data.pic
                )
            )
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