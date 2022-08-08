package com.erkumardevender.githubdemo.presentation

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erkumardevender.githubdemo.data.models.PullRequest
import com.erkumardevender.githubdemo.databinding.ItemPullRequestBinding
import kotlinx.coroutines.flow.MutableStateFlow

class PullRequestsAdapter(private val pullRequests: ArrayList<PullRequest>) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemPullRequestBinding=ItemPullRequestBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PullRequestViewHolder(itemPullRequestBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PullRequestViewHolder).onBind(position)
    }

    override fun getItemCount(): Int {
        return pullRequests.size
    }

    fun clearItems(){
        pullRequests.clear()
        notifyDataSetChanged()
    }

    fun addItems(pullRequests: List<PullRequest>){
        val indexToBeNotified=pullRequests.size
        this.pullRequests.addAll(pullRequests)
        notifyItemRangeChanged(indexToBeNotified,pullRequests.size)
    }

    fun addItem(pullRequest:PullRequest){
        val indexToBeNotified=pullRequests.size
        this.pullRequests.add(pullRequest)
        notifyItemChanged(indexToBeNotified)
    }

    inner class PullRequestViewHolder(private val itemPullRequestBinding: ItemPullRequestBinding)
        :RecyclerView.ViewHolder(itemPullRequestBinding.root){

            fun onBind(position:Int){
                itemPullRequestBinding.pullRequest=MutableStateFlow(pullRequests[position])
            }
    }


}