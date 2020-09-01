package com.kanyideveloper.gadsleaderboard.ui.view

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import com.kanyideveloper.gadsleaderboard.R
import com.kanyideveloper.gadsleaderboard.viewmodels.LearningViewModel


class LearningLeaders : Fragment() {
    private lateinit var viewModel: LearningViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View =  inflater.inflate(R.layout.fragment_learning_leaders, container, false)
        viewModel = AndroidViewModelFactory(Application()).create(LearningViewModel::class.java)
        return view
    }

}