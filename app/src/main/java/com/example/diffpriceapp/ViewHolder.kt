package com.example.diffpriceapp

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_list_item.view.*
import kotlinx.android.synthetic.main.layout_list_item.view.resultedit

class ViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    private val AnameTextView = itemView.Aname
    private val BnameTextView = itemView.Bname
    private val AsizeTextView = itemView.Sizea
    private val  BsizeTextView = itemView.sizeb
    private val  ApriceTextView = itemView.pricea
    private val  BpriceTextView = itemView.priceb
    private val resultTextView = itemView.resultedit
    private val topicTextView =  itemView.topic
    fun bind(product: Product) {
        topicTextView.text = product.Producttopic
        AnameTextView.text = product.ProductAname
        BnameTextView.text = product.ProductBname
        AsizeTextView.text = product.ProductAsize
        BsizeTextView.text = product.ProductBsize
        ApriceTextView.text = product.ProductAprice
        BpriceTextView.text = product.ProductBprice
        resultTextView.text = product.result ?: "Unknown"
        itemView.setOnClickListener {
            val intent = Intent(itemView.context,
                Edit::class.java)
            intent.putExtra(Edit.EXTRA_STUDENT_ID,
                product.Producttopic)
            itemView.context.startActivity(intent)
        }

    }
}