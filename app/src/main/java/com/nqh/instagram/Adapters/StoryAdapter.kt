package com.nqh.instagram.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nqh.instagram.R
import com.nqh.instagram.model.InterfaceModel
import com.nqh.instagram.model.PostModel

class StoryAdapter(
    private val listDataStory: List<PostModel>,
    private val context: Context,
    private val clickListenerStory: InterfaceModel
) : RecyclerView.Adapter<StoryAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img_story = view.findViewById<ImageView>(R.id.img_story)
        val tv_user_name = view.findViewById<TextView>(R.id.tv_user_name)
        val view_all_story = view.findViewById<ConstraintLayout>(R.id.view_all_story)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listDataStory.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemStory = listDataStory[position]
        Glide.with(context).asBitmap().load(itemStory.avatar).into(holder.img_story)
        holder.tv_user_name.text = itemStory.name

        /*holder.img_story.setOnClickListener {
            clickListenerStory.click(itemStory)
        }
        holder.view_all_story.setOnClickListener{

        }*/
    }
}


