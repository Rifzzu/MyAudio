package com.example.myaudio

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAudioAdapter(private val listItem: ArrayList<Audio>) : RecyclerView.Adapter<ListAudioAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_audio, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val(name, desc, detail,photo) = listItem[position]
        holder.imgPhoto.setImageResource(photo)
        holder.itemName.text = name
        holder.itemDescription.text = desc
        holder.itemDetail.text = detail

        holder.itemView.setOnClickListener{
            val it_Detail = Intent(holder.itemView.context, AudioDetail::class.java)
            it_Detail.putExtra("key_detail", listItem[holder.adapterPosition])
            holder.itemView.context.startActivity(it_Detail)
        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.photoItem)
        val itemName: TextView = itemView.findViewById(R.id.nameItem)
        val itemDescription: TextView = itemView.findViewById(R.id.descItem)
        val itemDetail: TextView = itemView.findViewById(R.id.detailItem)
    }
}
