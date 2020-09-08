package com.kanyideveloper.gadsleaderboard.ui.view

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kanyideveloper.gadsleaderboard.R
import com.kanyideveloper.gadsleaderboard.adapters.LearningAdapter
import com.kanyideveloper.gadsleaderboard.adapters.SkillIQAdapter
import com.kanyideveloper.gadsleaderboard.viewmodels.MainViewModel


class SkillIQLeaders : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter : SkillIQAdapter
    private lateinit var recycler : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill_i_q_leaders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = view.findViewById<ProgressBar>(R.id.skills_progress_bar)
        recycler = view.findViewById(R.id.skill_iq_leaders_recycler)

        viewModel.getTopSkillIQLeaders()

        viewModel.showSkillProgress.observe(viewLifecycleOwner, Observer {
            if(it){
                progressBar.visibility = View.VISIBLE
            }
            else{
                progressBar.visibility = View.GONE
            }
        })

        viewModel.topSkillIQLeadersList.observe(viewLifecycleOwner, Observer {
            adapter.setTopSkillIQLeadersList(it)
        })

        recycler.layoutManager = LinearLayoutManager(context!!)
        adapter = SkillIQAdapter(context!!)
        recycler.adapter = adapter
    }
}

