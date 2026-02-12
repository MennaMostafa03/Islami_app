package com.example.islami_app.ui.screens.main.fragments.quran

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.islami_app.R
import com.example.islami_app.ui.screens.fragments.hadeth.HadethAdapter
import com.example.islami_app.ui.screens.fragments.hadeth.HadethDM
import com.example.islami_app.ui.screens.hadeth_details.HadethViewActivity

class HadethFragment : Fragment() {
    lateinit var recyclerView : RecyclerView
    lateinit var adapter : HadethAdapter

    var ahadeth: MutableList<HadethDM> = emptyList<HadethDM>().toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        readHadeth()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hadeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    fun initViews() {
        recyclerView = view!!.findViewById(R.id.recyclerview)
        adapter = HadethAdapter(ahadeth){
            val intent = Intent(activity, HadethViewActivity::class.java)
            intent.putExtra(HadethViewActivity.HADETH_KEY, it)
            startActivity(intent)
        }
        recyclerView.adapter =  adapter
    }
    fun readHadeth(){
        val inputStream = activity!!.assets.open("h1.txt")
        var title = ""
        var content = ""
        inputStream.reader().forEachLine {
            if(title.isEmpty()){
                title = it
            } else {
                if (it.equals("#")) {
                    ahadeth.add(HadethDM(title, content))
                    content = ""
                    title = ""
                    return@forEachLine
                }
                content += it
            }
        }
        ahadeth.add(HadethDM(title, content))
        println(ahadeth)
    }
}