package com.example.islami.ui.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.islami.R

class TasbeehFragment : Fragment() {
    lateinit var constraintLayout: ConstraintLayout
    lateinit var sebha: ImageView
    private var counter = 0
    private var currentZekr = 0

    lateinit var textViewCounter: TextView
    lateinit var textViewZekr: TextView

    private val zekrList = listOf(
        "سبحان الله",
        "الحمد لله",
        "الله أكبر",
        "سبحان الله وبحمده، سبحان الله العظيم"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tasbeeh, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val angle = 30F
        constraintLayout = requireView().findViewById(R.id.constraint_layout_tasbeeh)
        sebha = requireView().findViewById(R.id.body_sebha)
        textViewCounter = requireView().findViewById(R.id.counter_tv)
        textViewZekr = requireView().findViewById(R.id.zekr_tv)
        constraintLayout.setOnClickListener {
            sebha.rotation += angle
            if (counter < 33) {
                counter++
            } else {
                counter = 1
                currentZekr = if (currentZekr < zekrList.size - 1) ++currentZekr else 0
                textViewZekr.text = zekrList[currentZekr]
            }

            textViewCounter.text = counter.toString()


        }


    }
}