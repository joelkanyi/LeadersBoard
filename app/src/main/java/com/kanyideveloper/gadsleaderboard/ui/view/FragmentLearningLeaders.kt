package com.kanyideveloper.gadsleaderboard.ui.view


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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kanyideveloper.gadsleaderboard.R
import com.kanyideveloper.gadsleaderboard.adapters.LearningAdapter
import com.kanyideveloper.gadsleaderboard.viewmodels.MainViewModel



class FragmentLearningLeaders() : Fragment() {
    private lateinit var viewModel: MainViewModel
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter : LearningAdapter
    private lateinit var recycler : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_learning_leaders, container, false)
    }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = view.findViewById(R.id.learning_progress_bar)
        recycler = view.findViewById(R.id.learning_leaders_recycler)

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

        recycler.layoutManager = LinearLayoutManager(context!!)
        adapter = LearningAdapter(context!!)
        recycler.adapter = adapter
    }

}