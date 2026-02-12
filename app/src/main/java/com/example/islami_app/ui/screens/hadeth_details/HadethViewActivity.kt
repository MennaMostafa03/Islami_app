package com.example.islami_app.ui.screens.hadeth_details

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.islami_app.R
import com.example.islami_app.ui.screens.fragments.hadeth.HadethDM
import com.example.islami_app.ui.screens.main.fragments.quran.quranList.SurasData
import com.example.islami_app.ui.screens.main.sura_details.SurasDetailsActivity.Companion.SURAS_KEY

class HadethViewActivity : AppCompatActivity() {

    companion object{
        const val HADETH_KEY = "hadeth"
    }
    lateinit var content : TextView
    lateinit var hadeth : HadethDM
    lateinit var hadethTitleAr : TextView
    lateinit var backarrow : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadeth_view)

        initViews()
        initListeners()
    }

    fun initViews() {
        backarrow = findViewById(R.id.arrowback)
        content = findViewById(R.id.hadeth)
        hadethTitleAr = findViewById(R.id.hadethTitleAr)

        hadeth = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(HADETH_KEY, HadethDM::class.java)
        } else {
            intent.getSerializableExtra(HADETH_KEY) as HadethDM
        }!!

        hadethTitleAr.text = hadeth.title
        content.text = hadeth.content

    }

    fun initListeners(){
        backarrow.setOnClickListener{
            finish()
        }
    }


}