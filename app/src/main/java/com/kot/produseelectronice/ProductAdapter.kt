package com.kot.produseelectronice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class ProductAdapter(private val context: Context, private val productList: List<Product>) : BaseAdapter() {

    override fun getCount(): Int = productList.size

    override fun getItem(position: Int): Any = productList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val product = getItem(position) as Product
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_product, parent, false)

        val productNameTextView: TextView = view.findViewById(R.id.text_product_name)
        val productPriceTextView: TextView = view.findViewById(R.id.text_product_price)
        val productImageView: ImageView = view.findViewById(R.id.image_product)

        productNameTextView.text = product.name
        productPriceTextView.text = "Price: ${product.price}"
        Glide.with(context).load(product.imageUrl).into(productImageView)

        return view
    }
}
