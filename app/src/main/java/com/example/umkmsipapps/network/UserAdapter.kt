package com.example.projectumkm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.umkmsipapps.R
import com.example.umkmsipapps.model.DataItem

class UserAdapter(private var users: MutableList<DataItem>) :
    RecyclerView.Adapter<UserAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder{
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list_user,parent,false)
        return ListViewHolder(view)

    }

    fun addUser(newUsers: DataItem){
        users.add(newUsers)
        notifyItemInserted(users.lastIndex)
    }

    fun clear(){
        users.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = users.size
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = users[position]
        Glide.with(holder.itemView.context)
            .load(user.avatar)
            .apply(RequestOptions().override(80,80).placeholder(R.drawable.ic_launcher_foreground))
            .transform(CircleCrop())
            .into(holder.ivAvatar)
        holder.tvUserName.text = "${user.firstname} ${user.lastname}"
        holder.tvUserName.text = user.firstname
        holder.tvEmail.text = user.email
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvUserName: TextView = itemView.findViewById(R.id.itemName)
        var tvEmail: TextView = itemView.findViewById(R.id.itemEmail)
        var ivAvatar: ImageView = itemView.findViewById(R.id.itemAvatar)
    }



}