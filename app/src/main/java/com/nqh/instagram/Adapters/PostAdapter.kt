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
import com.nqh.instagram.model.InterfaceModel
import com.nqh.instagram.R
import com.nqh.instagram.model.PostModel

class PostAdapter(
    private var listData: List<PostModel>,
    val context: Context,
    val clickListener: InterfaceModel
) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {  //bắt sự kiện quản lý từng thành phần view
        val img_home = view.findViewById<ImageView>(R.id.img_home)
        val tv_home = view.findViewById<TextView>(R.id.tv_home)
        val view_all = view.findViewById<ConstraintLayout>(R.id.view_all)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder { //truyền layout vào
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bai_viet, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) { //duyệt tuần tự , không phụ thuôc dữ liệu đầu vào
        val item = listData[position]
        Glide.with(context).asBitmap().load(item.avatar).into(holder.img_home) //load cái gì, đổ vào(into) cái gì
        holder.tv_home.text = item.name

        holder.img_home.setOnClickListener {
            clickListener.click(item)
        }

        holder.view_all.setOnClickListener{

        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}










