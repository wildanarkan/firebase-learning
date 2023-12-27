package com.wildanarkan.latihanfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.wildanarkan.latihanfragment.data.AppDatabase
import com.wildanarkan.latihanfragment.data.entity.User

class EditorActivity : AppCompatActivity() {
    private lateinit var database: AppDatabase

    private lateinit var fullName: EditText
    private lateinit var email: EditText
    private lateinit var phone: EditText
    private lateinit var buttonSave: Button

    private fun initializeVariable(){
        fullName = findViewById(R.id.edt_full_name)
        email = findViewById(R.id.edt_email)
        phone = findViewById(R.id.edt_phone)
        buttonSave = findViewById(R.id.btn_save)
        database = AppDatabase.getInstance(applicationContext)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)
        initializeVariable()

        var intent = intent.extras
        if (intent!=null){
            var user = database.userDao().get(intent.getInt("id"))

            fullName.setText(user.fullName)
            email.setText(user.email)
            phone.setText(user.phone)
        }

        buttonSave.setOnClickListener {
            if (fullName.text.isNotEmpty() && email.text.isNotEmpty() && phone.text.isNotEmpty()) {
                if (intent!=null){
                    database.userDao().Update(
                        User(
                            intent.getInt("id", 0),
                            fullName.text.toString(),
                            email.text.toString(),
                            phone.text.toString()
                        ))
                }else {
                    database.userDao().insertAll(
                        User(
                            uid = null,
                            fullName.text.toString(),
                            email.text.toString(),
                            phone.text.toString()
                        )
                    )
                }
                finish()
            } else {
                Toast.makeText(applicationContext, "fill in the data correctly", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}