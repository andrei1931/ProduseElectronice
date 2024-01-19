package com.kot.produseelectronice

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class ProductDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val productNameTextView: TextView = findViewById(R.id.text_product_name_details)
        val productDescriptionTextView: TextView = findViewById(R.id.text_product_description_details)
        val productPriceTextView: TextView = findViewById(R.id.text_product_price_details)
        val productImageView: ImageView = findViewById(R.id.image_product_details)

        val productName = intent.getStringExtra("PRODUCT_NAME")
        val productDescription = intent.getStringExtra("PRODUCT_DESCRIPTION")
        val productPrice = intent.getDoubleExtra("PRODUCT_PRICE", 0.0)
        val productImageUrl = intent.getStringExtra("PRODUCT_IMAGE_URL")

        productNameTextView.text = productName
        productDescriptionTextView.text = productDescription
        productPriceTextView.text = "Price: $productPrice"
        Glide.with(this).load(productImageUrl).into(productImageView)
    }
}
