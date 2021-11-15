package com.buffetproevent.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
//MENU DEL DIA
        val database = Firebase.database.reference

        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val data0 = snapshot.getValue(String::class.java)
                findViewById<TextView>(R.id.tvData).text = "Fecha del Vigencia: $data0"
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }
        val listener1 = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val data1 = snapshot.getValue(String::class.java)
                findViewById<TextView>(R.id.menuD1).text = "$data1"
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }
        val listener2 = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val data2 = snapshot.getValue(String::class.java)
                findViewById<TextView>(R.id.menuD2).text = "$data2"
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }
        val listener3 = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val data3 = snapshot.getValue(String::class.java)
                findViewById<TextView>(R.id.menuD3).text = "$data3"
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }
        val listener4 = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val data4 = snapshot.getValue(String::class.java)
                findViewById<TextView>(R.id.menuD4).text = "$data4"
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }
        val listener5 = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val data5 = snapshot.getValue(String::class.java)
                findViewById<TextView>(R.id.menuD5).text = "$data5"
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }
        val dataRef = database.child("Menu_del_Dia").child("data0")
        val dataRef1 = database.child("Menu_del_Dia").child("data1")
        val dataRef2 = database.child("Menu_del_Dia").child("data2")
        val dataRef3 = database.child("Menu_del_Dia").child("data3")
        val dataRef4 = database.child("Menu_del_Dia").child("data4")
        val dataRef5 = database.child("Menu_del_Dia").child("data5")

        dataRef.addValueEventListener(listener)
        dataRef1.addValueEventListener(listener1)
        dataRef2.addValueEventListener(listener2)
        dataRef3.addValueEventListener(listener3)
        dataRef4.addValueEventListener(listener4)
        dataRef5.addValueEventListener(listener5)
    }
}