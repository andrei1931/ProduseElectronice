package com.kot.produseelectronice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productList = generateProductList()
        val productListView: ListView = findViewById(R.id.listView_products)

        val productAdapter = ProductAdapter(this, productList)
        productListView.adapter = productAdapter

        productListView.setOnItemClickListener(AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedProduct = productList[position]
            showProductDetails(selectedProduct)
        })
    }

    private fun showProductDetails(product: Product) {
        val intent = Intent(this, ProductDetailsActivity::class.java)
        intent.putExtra("PRODUCT_NAME", product.name)
        intent.putExtra("PRODUCT_DESCRIPTION", product.description)
        intent.putExtra("PRODUCT_PRICE", product.price)
        intent.putExtra("PRODUCT_IMAGE_URL", product.imageUrl)
        startActivity(intent)
    }

    private fun generateProductList(): List<Product> {

        return listOf(
            Product("Laptop", "Powerful laptop for your work", 1200.0, "url_laptop_image"),
            Product("Smartphone", "The latest smartphone model", 800.0, "url_smartphone_image"),

        )
    }
}