package com.example.islami_app.ui.screens.fragments.hadeth

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.islami_app.R
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.log

class HadethAdapter(val ahadeth:  MutableList<HadethDM>, val onCLick: (HadethDM) -> Unit) : RecyclerView.Adapter<HadethAdapter.hadethVH>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): hadethVH {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.activity_hadeth_details, parent, false)

        return hadethVH(view)
    }

    override fun onBindViewHolder(
        holder: hadethVH,
        position: Int
    ) {
        var hadeth = ahadeth[position]

        holder.hadethTitle.text = hadeth.title
        holder.hadethContent.text = hadeth.content

        holder.itemView.setOnClickListener {
            onCLick(hadeth)
        }
    }

    override fun getItemCount(): Int {
        return ahadeth.size
    }

    class hadethVH(itemView: View) : RecyclerView.ViewHolder(itemView){
        val hadethTitle : TextView = itemView.findViewById(R.id.hadethname)
        val hadethContent : TextView = itemView.findViewById(R.id.hadethContent)
    }
}