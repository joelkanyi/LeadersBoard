package com.kanyideveloper.gadsleaderboard.ui.view

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import com.kanyideveloper.gadsleaderboard.R
import com.kanyideveloper.gadsleaderboard.adapters.LearningAdapter
import com.kanyideveloper.gadsleaderboard.viewmodels.LearningViewModel
import kotlinx.android.synthetic.main.fragment_learning_leaders.*


class LearningLeaders : Fragment() {
    private lateinit var viewModel: LearningViewModel
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter : LearningAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View =  inflater.inflate(R.layout.fragment_learning_leaders, container, false)
        progressBar = view.findViewById<ProgressBar>(R.id.learning_progress_bar)
        viewModel = AndroidViewModelFactory(Application()).create(LearningViewModel::class.java)

        viewModel.getTopLearner()

        viewModel.showProgress.observe(viewLifecycleOwner, Observer {
            if(it){
                progressBar.visibility = VISIBLE
            }
            else{
                progressBar.visibility = GONE
            }
        })

        viewModel.topLearnersList.observe(viewLifecycleOwner, Observer {
            adapter.setTopLeanersList(it)
        })
        adapter = LearningAdapter(Application())
        learning_leaders_recycler.adapter = adapter

        return view
    }

}