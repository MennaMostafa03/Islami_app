package com.example.islami_app.ui.screens.main.sura_details

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.islami_app.R
import com.example.islami_app.ui.screens.main.fragments.quran.quranList.SurasData

class SurasDetailsActivity : AppCompatActivity() {

    lateinit var sura: SurasData
    lateinit var ayat: TextView
    lateinit var suraEn: TextView
    lateinit var suraAr: TextView
    lateinit var backArrow: ImageView

    companion object {
        const val SURAS_KEY = "suras"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suras_details)
        initViews()
        initListeners()
        suraContent()
    }

    fun initViews() {
        ayat = findViewById(R.id.ayat)
        suraEn = findViewById(R.id.suranameEn)
        suraAr = findViewById(R.id.suranameAr)
        backArrow = findViewById(R.id.arrowback)

        sura =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getSerializableExtra(SURAS_KEY, SurasData::class.java)
            } else {
                intent.getSerializableExtra(SURAS_KEY) as SurasData
            }!!

        suraEn.text = sura.nameEn
        suraAr.text = sura.nameAr
    }

    fun initListeners(){
        backArrow.setOnClickListener{
            finish()
        }
    }

    fun suraContent(){
        var fileName = "${sura.index}.txt"
        var inputStream = assets.open("suras/$fileName")
        var i = 1
        var aya = ""

        inputStream.reader().forEachLine { line ->
            if(line.isNotEmpty()) {
                aya += "$line ($i) "
                i++
            }
            ayat.text = aya
        }
    }
}


