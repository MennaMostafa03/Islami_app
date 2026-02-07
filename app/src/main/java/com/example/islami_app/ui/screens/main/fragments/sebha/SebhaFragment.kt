package com.example.islami_app.ui.screens.main.fragments.quran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.islami_app.R


class SebhaFragment : Fragment() {
    var counter = 0
    var index = 0
    val zeker = listOf("سبحان الله","الحمد الله","الله اكبر","لا اله الا الله")

    lateinit var tasbehaCounter : TextView
    lateinit var tasabehContent : TextView
    lateinit var sebhaBody : ImageView

    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sebha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initiate()
        tasbeha()

    }
    fun initiate(){
         tasbehaCounter = view!!.findViewById(R.id.tasbehaCounter)
         tasabehContent = view!!.findViewById(R.id.tasabeh)
         sebhaBody = view!!.findViewById(R.id.sebhaBody)
    }

    fun tasbeha(){
        tasabehContent.text = zeker[index]
        tasbehaCounter.text = counter.toString()

        sebhaBody.setOnClickListener {
            if(counter < 33){
                counter++
                tasbehaCounter.text = counter.toString()
                tasabehContent.text = zeker[index]
                sebhaBody.animate().rotationBy(10f).setDuration(500).start()
            }else {
                counter = 0
                tasabehContent.text = zeker[index++]

            }
            if(index == 4){
                index = 0
            }
        }
    }
}