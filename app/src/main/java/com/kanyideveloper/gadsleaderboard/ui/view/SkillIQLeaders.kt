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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kanyideveloper.gadsleaderboard.R
import com.kanyideveloper.gadsleaderboard.adapters.SkillIQAdapter
import com.kanyideveloper.gadsleaderboard.viewmodels.SkillViewModel


class SkillIQLeaders : Fragment() {

    private lateinit var skillViewModel : SkillViewModel
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter : SkillIQAdapter
    private lateinit var recyclerView : RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View =  inflater.inflate(R.layout.fragment_skill_i_q_leaders, container, false)
        progressBar = view.findViewById(R.id.skills_progress_bar)
        recyclerView = view.findViewById(R.id.skill_iq_leaders_recycler)

        skillViewModel = AndroidViewModelFactory(Application()).create(SkillViewModel::class.java)

        skillViewModel.getTopSkillIQLeaders()

        skillViewModel.showProgress.observe(viewLifecycleOwner, Observer {
            if(it){
                progressBar.visibility = View.VISIBLE
            }
            else{
                progressBar.visibility = View.GONE
            }
        })

        skillViewModel.topSkillIQLeadersList.observe(viewLifecycleOwner, Observer {
            adapter.setTopSkillIQLeadersList(it)
        })

        recyclerView.layoutManager = LinearLayoutManager(context!!)
        adapter = SkillIQAdapter(context!!)
        recyclerView.adapter = adapter

        return view
    }

}