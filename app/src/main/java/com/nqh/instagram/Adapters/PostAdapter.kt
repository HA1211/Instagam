package com.nqh.instagram.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nqh.instagram.Model.PostModel
import com.nqh.instagram.R

class PostAdapter(
    private var listData: List<PostModel>
) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {  //bắt sự kiện quản lý từng thành phần view
        val tvHome = view.findViewById<TextView>(R.id.tvHome)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder { //truyền layout vào
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bai_viet, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) { //duyệt tuần tự , không phụ thuôc dữ liệu đầu vào, không truy
        val item = listData[position]
        holder.tvHome.text = item.name
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}










