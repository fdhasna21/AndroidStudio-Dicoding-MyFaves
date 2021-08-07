package com.fdhasna21.androidstudio_dicoding_myfaves

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_group_detail.*
import kotlinx.android.synthetic.main.row_recycler.view.*

class RowAdapter(val data:ArrayList<Group>, val context: Context)
    :RecyclerView.Adapter<RowAdapter.ViewHolder>(){
    private lateinit var onItemClickCallback: OnItemClickCallback

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val groupImage = itemView.row_image
        val groupName = itemView.row_group_name
        val groupIntro = itemView.row_group_desc
        val seeMore = itemView.row_see_more
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_recycler, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data.get(position)
        holder.groupName.text = item.name
        holder.groupIntro.text = item.intro
        holder.seeMore.setOnClickListener{
            onItemClickCallback.onItemClicked(data[holder.adapterPosition])
        }
        Glide.with(context)
            .load(item.logo)
            .into(holder.groupImage)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Group)
    }
}