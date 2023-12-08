package com.nqh.instagram.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nqh.instagram.Model.InterfaceModel
import com.nqh.instagram.Model.PostModel
import com.nqh.instagram.R

class PostAdapter(
    private var listData: List<PostModel>,
    val context: Context,
    val clickListener: InterfaceModel
) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {  //bắt sự kiện quản lý từng thành phần view
        val img_home = view.findViewById<ImageView>(R.id.img_home)
        val tv_home = view.findViewById<TextView>(R.id.tv_home)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder { //truyền layout vào
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bai_viet, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) { //duyệt tuần tự , không phụ thuôc dữ liệu đầu vào, không truy
        val item = listData[position]
        Glide.with(context).asBitmap().load(item.id).into(holder.img_home)
        holder.tv_home.text = item.name

        holder.img_home.setOnClickListener {
            clickListener.click(item)
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}










