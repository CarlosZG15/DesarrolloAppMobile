package com.example.ecoaprovechadorapp

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity() : AppCompatActivity(), Parcelable {

    private val database = FirebaseDatabase.getInstance().reference.child("usuario")
    private lateinit var editTextNombre: EditText
    private lateinit var editTextCorreo: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var btnAgregarUsuario: Button

    constructor(parcel: Parcel) : this() {

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RegisterActivity> {
        override fun createFromParcel(parcel: Parcel): RegisterActivity {
            return RegisterActivity(parcel)
        }

        override fun newArray(size: Int): Array<RegisterActivity?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        editTextNombre = findViewById(R.id.editTextNombre)
        editTextCorreo = findViewById(R.id.editTextCorreo)
        editTextPassword = findViewById(R.id.editTextPassword)

        val tvGoLogin = findViewById<TextView>(R.id.tv_go_to_login)
        tvGoLogin.setOnClickListener {
            goToLogin()
        }

        findViewById<Button>(R.id.btnAgregarUsuario).setOnClickListener {
            val nombre = editTextNombre.text.toString()
            val correo = editTextCorreo.text.toString()
            val password = editTextPassword.text.toString()

            // Crear un nuevo usuario en Firebase
            val usuarioId = database.push().key
            if (usuarioId != null) {
                val usuario = Usuario(usuarioId, nombre, correo, password)
                database.child(usuarioId).setValue(usuario)

                fun onCreate(savedInstanceState: Bundle?) {
                    super.onCreate(savedInstanceState)
                    setContentView(R.layout.activity_register)
                }
            }
        }
    }

    private fun goToLogin() {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}
