package com.example.islami_app.ui.screens.main.fragments.quran.quranList

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami_app.R

class SurasAdapter(val suraList: List<SurasData>, val onClick: (SurasData) -> Unit) : RecyclerView.Adapter<SurasAdapter.surasContentVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): surasContentVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_suras_item, parent,  false)
        return surasContentVH(view)
    }

    override fun onBindViewHolder(holder: surasContentVH, position: Int) {
        var item = suraList[position]

        holder.suranameEn.text = item.nameEn
        holder.suranameAr.text = item.nameAr
        holder.suraNum.text = item.index.toString()
        holder.suraverses.text = "${item.verses} Verses"

        holder.itemView.setOnClickListener {
            onClick(item)
        }
    }

    override fun getItemCount(): Int {
        return suraList.size
    }
    class surasContentVH(itemView: View) : RecyclerView.ViewHolder(itemView){
        val suranameEn : TextView = itemView.findViewById(R.id.surasNameEn)
        val suranameAr : TextView = itemView.findViewById(R.id.surasNameAr)
        val suraverses : TextView = itemView.findViewById(R.id.versesNum)
        val suraNum : TextView = itemView.findViewById(R.id.surasNum)
    }

}