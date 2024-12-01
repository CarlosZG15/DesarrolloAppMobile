package com.example.ecoaprovechadorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnFlayerInfo = findViewById<Button>(R.id.btn_flayer)
        btnFlayerInfo.setOnClickListener{
            goToFlayerActivity()
        }

        val tvGoLogin = findViewById<TextView>(R.id.btn_cerrar)
        tvGoLogin.setOnClickListener{
            goToCerrar()
        }
    }
    private fun goToFlayerActivity(){
        val i = Intent(this, FlayerActivity::class.java)
        startActivity(i)
    }
    private fun goToCerrar(){
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}
