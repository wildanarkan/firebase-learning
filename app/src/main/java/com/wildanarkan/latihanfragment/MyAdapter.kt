package com.wildanarkan.latihanfragment

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.material3.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(
    private val onDelete: (codeProduct: String) -> Unit
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val newsList = mutableListOf<ProductData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_product,
            parent,false)
        return  MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newsList[position]
        holder.tvOwner.text = currentItem.owner
        holder.tvBrand.text = currentItem.brand
        holder.tvProduct.text = currentItem.product
        holder.tvCodeProduct.text = currentItem.codeProduct
        holder.tvPrice.text = currentItem.price

        holder.btnUpdate.setOnClickListener{
            val intent = Intent(holder.itemView.context, UpdateActivity::class.java).apply {
                putExtra("owner", currentItem.owner)
                putExtra("brand", currentItem.brand)
                putExtra("product", currentItem.product)
                putExtra("codeProduct", currentItem.codeProduct)
                putExtra("price", currentItem.price)
            }
            holder.itemView.context.startActivity(intent)
        }

        holder.btnDelete.setOnClickListener{
            onDelete(currentItem.codeProduct.orEmpty())
        }


    }

    fun submitData(data: List<ProductData>) {
        newsList.clear()
        newsList.addAll(data)
        this.notifyDataSetChanged()
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val tvOwner : TextView = itemView.findViewById(R.id.tv_owner)
        val tvBrand : TextView = itemView.findViewById(R.id.tv_brand)
        val tvProduct : TextView = itemView.findViewById(R.id.tv_product)
        val tvCodeProduct : TextView = itemView.findViewById(R.id.tv_code_product)
        val tvPrice : TextView = itemView.findViewById(R.id.tv_price)

        val btnUpdate: ImageView = itemView.findViewById(R.id.btn_update)
        val btnDelete: ImageView = itemView.findViewById(R.id.btn_delete)
    }
}