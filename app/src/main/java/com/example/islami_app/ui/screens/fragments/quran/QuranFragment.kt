package com.example.islami_app.ui.screens.main.fragments.quran

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami_app.R
import com.example.islami_app.ui.screens.main.fragments.quran.quranList.SurasAdapter
import com.example.islami_app.ui.screens.main.sura_details.SurasDetailsActivity
import com.route.islamic43.ui.Constants

class QuranFragment : Fragment() {
    lateinit var quranRecyclerView : RecyclerView
    lateinit var adapter : SurasAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quranRecyclerView = view.findViewById(R.id.quranrecyclerview)

        adapter = SurasAdapter(Constants.quranSurahs){
            val intent = Intent(activity, SurasDetailsActivity::class.java)
            intent.putExtra(SurasDetailsActivity.SURAS_KEY, it)
            startActivity(intent)
        }

        quranRecyclerView.adapter = adapter
    }

}