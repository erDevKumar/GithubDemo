package com.erkumardevender.githubdemo.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erkumardevender.githubdemo.BR
import com.erkumardevender.githubdemo.R
import com.erkumardevender.githubdemo.data.models.PullRequest
import com.erkumardevender.githubdemo.databinding.ActivityClosedPrsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClosedPRListActivity:AppCompatActivity() {

    private val viewModel: GitRepoPRViewModel by viewModels()
    private lateinit var binding:ActivityClosedPrsBinding
    private lateinit var adapter:PullRequestsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
        setAdapter()
        binding.swipeRefreshLayout.setOnRefreshListener {
            adapter.clearItems()
            viewModel.fetchClosedPRs(this::onPRsFetched)
        }
        if (savedInstanceState==null) {
            viewModel.fetchClosedPRs(this::onPRsFetched)
            binding.swipeRefreshLayout.isRefreshing = true
        }
    }

    private fun onPRsFetched(prList: List<PullRequest>){
        adapter.addItems(prList)
        binding.swipeRefreshLayout.isRefreshing=false
    }

    private fun performDataBinding(){
        binding=DataBindingUtil.setContentView(this, R.layout.activity_closed_prs)
        binding.lifecycleOwner=this
        binding.setVariable(BR.pullRequestViewModel,viewModel)
        binding.executePendingBindings()
    }

    private fun setAdapter(){
        adapter= PullRequestsAdapter(viewModel.closedPRList.value as ArrayList<PullRequest>)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        binding.pullRequests.layoutManager = linearLayoutManager
        binding.pullRequests.adapter = adapter
        val itemDecor = DividerItemDecoration(this, RecyclerView.VERTICAL)
        binding.pullRequests.addItemDecoration(itemDecor)
    }

}