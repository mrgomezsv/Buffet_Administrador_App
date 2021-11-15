package com.buffetproevent.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class PublicAntoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_public_anto)
//PUBLICAR ANTOJITOS
        val database = Firebase.database.reference

        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val anto = snapshot.getValue(String::class.java)
                findViewById<TextView>(R.id.textViewDataAnto).text = "Fecha del Vigencia: $anto"
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }

        val listener1 = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val anto1 = snapshot.getValue(String::class.java)
                findViewById<TextView>(R.id.textViewPlato1Anto).text = "$anto1"
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }

        val listener2 = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val anto2 = snapshot.getValue(String::class.java)
                findViewById<TextView>(R.id.textViewPlato2Anto).text = "$anto2"
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }

        val listener3 = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val anto3 = snapshot.getValue(String::class.java)
                findViewById<TextView>(R.id.textViewPlato3Anto).text = "$anto3"
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }

        val listener4 = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val anto4 = snapshot.getValue(String::class.java)
                findViewById<TextView>(R.id.textViewPlato4Anto).text = "$anto4"
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }

        val listener5 = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val anto5 = snapshot.getValue(String::class.java)
                findViewById<TextView>(R.id.textViewPlato5Anto).text = "$anto5"
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }

        val listener6 = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val anto6 = snapshot.getValue(String::class.java)
                findViewById<TextView>(R.id.textViewPlato6Anto).text = "$anto6"
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }

        val dataRef0 = database.child("Menu_Antojitos").child("anto0")
        val dataRef1 = database.child("Menu_Antojitos").child("anto1")
        val dataRef2 = database.child("Menu_Antojitos").child("anto2")
        val dataRef3 = database.child("Menu_Antojitos").child("anto3")
        val dataRef4 = database.child("Menu_Antojitos").child("anto4")
        val dataRef5 = database.child("Menu_Antojitos").child("anto5")
        val dataRef6 = database.child("Menu_Antojitos").child("anto6")

        dataRef0.addValueEventListener(listener)
        dataRef1.addValueEventListener(listener1)
        dataRef2.addValueEventListener(listener2)
        dataRef3.addValueEventListener(listener3)
        dataRef4.addValueEventListener(listener4)
        dataRef5.addValueEventListener(listener5)
        dataRef6.addValueEventListener(listener6)

        // Para Enviar Datos

        findViewById<MaterialButton>(R.id.btnSendAnto).setOnClickListener {
            val data0 = findViewById<TextInputEditText>(R.id.etDataAnto).text.toString()
            dataRef0.setValue(data0)
            val data1 = findViewById<TextInputEditText>(R.id.etData1Anto).text.toString()
            dataRef1.setValue(data1)
            val data2 = findViewById<TextInputEditText>(R.id.etData2Anto).text.toString()
            dataRef2.setValue(data2)
            val data3 = findViewById<TextInputEditText>(R.id.etData3Anto).text.toString()
            dataRef3.setValue(data3)
            val data4 = findViewById<TextInputEditText>(R.id.etData4Anto).text.toString()
            dataRef4.setValue(data4)
            val data5 = findViewById<TextInputEditText>(R.id.etData5Anto).text.toString()
            dataRef5.setValue(data5)
            val data6 = findViewById<TextInputEditText>(R.id.etData6Anto).text.toString()
            dataRef6.setValue(data6)
        }
    }
}