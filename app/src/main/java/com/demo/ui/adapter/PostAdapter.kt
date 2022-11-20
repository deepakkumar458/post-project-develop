package com.demo.ui.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo.databinding.PostSingleRowLayoutBinding
import com.demo.persistance.entities.ApiResponse
import com.demo.ui.MainActivity

class PostAdapter(val mContext : Context , val mList : List<ApiResponse> ):RecyclerView.Adapter<PostAdapter.ViewHolder>(){


    inner class ViewHolder(val mBinding : PostSingleRowLayoutBinding):RecyclerView.ViewHolder(mBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bsBinding = PostSingleRowLayoutBinding.inflate(LayoutInflater.from(mContext) , parent , false)
        return ViewHolder(bsBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = mList.get(position)
        holder.mBinding.titleTv.setText(list.title)

        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable("postData", list)
            (mContext as MainActivity).loadFragment(bundle)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

}