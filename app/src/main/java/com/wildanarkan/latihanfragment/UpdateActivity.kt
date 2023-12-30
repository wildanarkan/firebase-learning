package com.wildanarkan.latihanfragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UpdateActivity : AppCompatActivity() {
    private lateinit var edtOwner : EditText
    private lateinit var edtBrand : EditText
    private lateinit var edtProduct : EditText
    private lateinit var edtCodeProduct : EditText
    private lateinit var edtPrice : EditText
    private lateinit var btnUpdate : Button

    private lateinit var databaseReference: DatabaseReference


    private fun initialize(){
        edtOwner = findViewById(R.id.edt_update_owner)
        edtBrand = findViewById(R.id.edt_update_brand)
        edtProduct = findViewById(R.id.edt_update_product)
        edtCodeProduct = findViewById(R.id.edt_update_code_product)
        edtPrice = findViewById(R.id.edt_update_price)
        btnUpdate = findViewById(R.id.btn_update)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        initialize()
        getExtra()

    }

    private fun getExtra(){
        val owner = intent.getStringExtra("owner")
        val brand = intent.getStringExtra("brand")
        val product = intent.getStringExtra("product")
        val codeProduct = intent.getStringExtra("codeProduct")
        val price = intent.getStringExtra("price")

        edtOwner.setText(owner)
        edtBrand.setText(brand)
        edtProduct.setText(product)
        edtCodeProduct.setText(codeProduct)
        edtPrice.setText(price)

        btnUpdate.setOnClickListener {
//                val ownerInput = binding.edtOwner.text.toString()
//                val brandInput = binding.edtBrand.text.toString()
//                val productInput = binding.edtProduct.text.toString()
//                val codeProductInput = binding.edtCodeProduct.text.toString()
//                val priceInput = binding.edtPrice.text.toString()

            databaseReference = FirebaseDatabase.getInstance().getReference("Product Information")
            val productData = ProductData(
                edtOwner.text.toString(),
                edtBrand.text.toString(),
                edtProduct.text.toString(),
                edtCodeProduct.text.toString(),
                edtPrice.text.toString()
            )
            databaseReference.child(edtCodeProduct.text.toString()).setValue(productData)
                .addOnSuccessListener {
                    edtOwner.text.clear()
                    edtBrand.text.clear()
                    edtProduct.text.clear()
                    edtCodeProduct.text.clear()
                    edtPrice.text.clear()

                    Toast.makeText(applicationContext, "Updated", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                }.addOnFailureListener {
                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}