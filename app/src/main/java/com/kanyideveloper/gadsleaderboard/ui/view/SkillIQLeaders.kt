package com.kanyideveloper.gadsleaderboard.ui.view

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import com.kanyideveloper.gadsleaderboard.R
import com.kanyideveloper.gadsleaderboard.viewmodels.SkillViewModel

class SkillIQLeaders : Fragment() {

    private lateinit var skillViewModel: SkillViewModel
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view : View =  inflater.inflate(R.layout.fragment_skill_i_q_leaders, container, false)
        progressBar = view.findViewById<ProgressBar>(R.id.skills_progress_bar)


        skillViewModel = AndroidViewModelFactory(Application()).create(SkillViewModel::class.java)

        skillViewModel.getTopSkillers()

        skillViewModel.showProgress.observe(viewLifecycleOwner, Observer {
            if(it){
                progressBar.visibility = View.VISIBLE
            }
            else{
                progressBar.visibility = View.GONE
            }
        })

        return view
    }

}