package com.wildanarkan.latihanfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val newslist: ArrayList<ProductData>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_product,
            parent,false)
        return  MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newslist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newslist[position]
        holder.tvOwner.text = currentItem.owner
        holder.tvBrand.text = currentItem.brand
        holder.tvProduct.text = currentItem.product
        holder.tvCodeProduct.text = currentItem.codeProduct
        holder.tvPrice.text = currentItem.price
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val tvOwner : TextView = itemView.findViewById(R.id.tv_owner)
        val tvBrand : TextView = itemView.findViewById(R.id.tv_brand)
        val tvProduct : TextView = itemView.findViewById(R.id.tv_product)
        val tvCodeProduct : TextView = itemView.findViewById(R.id.tv_code_product)
        val tvPrice : TextView = itemView.findViewById(R.id.tv_price)


    }
}