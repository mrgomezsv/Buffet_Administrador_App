package com.buffetproevent.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class DessertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dessert)
//ANTOJITOS
        val database = Firebase.database.reference

        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val anto0 = snapshot.getValue(String::class.java)
                findViewById<TextView>(R.id.tvDataAnto).text = "Para este: $anto0"
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }
        val listener1 = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val anto1 = snapshot.getValue(String::class.java)
                findViewById<TextView>(R.id.menuA1).text = "$anto1"
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }
        val listener2 = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val anto2 = snapshot.getValue(String::class.java)
                findViewById<TextView>(R.id.menuA2).text = "$anto2"
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }
        val listener3 = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val anto3 = snapshot.getValue(String::class.java)
                findViewById<TextView>(R.id.menuA3).text = "$anto3"
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }
        val listener4 = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val anto4 = snapshot.getValue(String::class.java)
                findViewById<TextView>(R.id.menuA4).text = "$anto4"
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }
        val listener5 = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val anto5 = snapshot.getValue(String::class.java)
                findViewById<TextView>(R.id.menuA5).text = "$anto5"
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }
        val listener6 = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val anto6 = snapshot.getValue(String::class.java)
                findViewById<TextView>(R.id.menuA6).text = "$anto6"
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

    }
}