package com.buffetproevent.admin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class AboutUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        val btnAtras2 : ImageButton = findViewById(R.id.btnAtras2)
        btnAtras2.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        facebookLink()
        webLink()
        whastappLink()
    }

    private fun facebookLink(){
        val btnFacebook : Button = findViewById(R.id.btnFacebook)
        btnFacebook.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/profile.php?id=100009157009110"))
            startActivity(intent)
        }
    }

    private fun webLink(){
        val btnUrl : Button = findViewById(R.id.btnUrl)
        btnUrl.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://buffetproevent.com/"))
            startActivity(intent)
        }
    }

    private fun whastappLink(){
        val btnWhastapp: Button = findViewById(R.id.btnWhastapp)
        btnWhastapp.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=+50378736282&text=Hola,%20necesito%20informaci%C3%B3n%20de%20buffetproevent.com%20para%20mi%20evento"))
            startActivity(intent)
        }
    }
}