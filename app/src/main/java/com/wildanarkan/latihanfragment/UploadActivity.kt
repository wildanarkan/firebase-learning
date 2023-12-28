package com.wildanarkan.latihanfragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.wildanarkan.latihanfragment.databinding.ActivityUploadBinding

class UploadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUploadBinding
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUpload.setOnClickListener {
            val ownerInput = binding.edtOwner.text.toString()
            val brandInput = binding.edtBrand.text.toString()
            val productInput = binding.edtProduct.text.toString()
            val codeProductInput = binding.edtCodeProduct.text.toString()
            val priceInput = binding.edtPrice.text.toString()

            databaseReference = FirebaseDatabase.getInstance().getReference("Product Information")
            val productData = ProductData(ownerInput, brandInput, productInput, codeProductInput, priceInput)
            databaseReference.child(codeProductInput).setValue(productData).addOnSuccessListener {
                binding.edtOwner.text.clear()
                binding.edtBrand.text.clear()
                binding.edtProduct.text.clear()
                binding.edtCodeProduct.text.clear()
                binding.edtPrice.text.clear()

                Toast.makeText(applicationContext, "Uploaded", Toast.LENGTH_SHORT).show()
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }.addOnFailureListener{
                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}