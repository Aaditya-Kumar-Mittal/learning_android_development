package com.example.learningandroiddev

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapterClassOne(private val dataList: ArrayList<RecyclerViewDataClassOne>) : RecyclerView.Adapter<RecyclerViewAdapterClassOne.ViewHolderClassOne>() {

    var onItemClick: ((RecyclerViewDataClassOne) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClassOne {
        // This method will be called whenever RecyclerView needs a new ViewHolder of the given type to represent an item.
        // This method is used to initialize the ViewHolder and its views.

        val recyclerItemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_recycler_view_custom_item1, parent, false)
        return ViewHolderClassOne(recyclerItemView)
    }

    override fun onBindViewHolder(holder: ViewHolderClassOne, position: Int) {
        // This method attaches the element variable with data variable
        holder.rvImage.setImageResource(dataList[position].dataImage)
        holder.rvTitle.text = dataList[position].dataTitle
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(dataList[position])
        }
    }

    override fun getItemCount(): Int {
        // This method returns the size of the data list
        return dataList.size
    }

    class ViewHolderClassOne(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvImage = itemView.findViewById<ImageView>(R.id.recyclerViewImage)
        val rvTitle = itemView.findViewById<TextView>(R.id.recyclerViewTextTitle)
    }
}