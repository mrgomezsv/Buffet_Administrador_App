package com.buffetproevent.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.buffetproevent.admin.databinding.ActivityMainBinding
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener

    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        val response = IdpResponse.fromResultIntent(it.data)

        if (it.resultCode == RESULT_OK){
            val user = FirebaseAuth.getInstance().currentUser
            if (user != null){
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_LONG).show()
            }
        }else{
            if (response == null){
                Toast.makeText(this, "Hasta Pronto", Toast.LENGTH_LONG).show()
                finish()
            }else{
                response.error?.let {
                    if (it.errorCode == ErrorCodes.NO_NETWORK){
                        Toast.makeText(this, "Sin Red", Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this, "Codigo de Error: ${it.errorCode}", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configAuth() // Autenticacion
        dessertMenu() // Ir a Menu de Postres
        darMenu() // Ir a Menu del Dia
        aboutUs() // Ir a Sobre Nosotros
        ourServices() // Ir a Nuestros Servicios
        publicMenu() // Ir a Publicar Menus
        publicAnto() // Ir a Publicar Antojitos
        signOut() // Cerrar Sesion
    }

    private fun configAuth(){
        firebaseAuth = FirebaseAuth.getInstance()
        authStateListener = FirebaseAuth.AuthStateListener { auth ->
            if (auth.currentUser != null){
                supportActionBar?.title = auth.currentUser?.displayName
                binding.llProgress.visibility = View.GONE
                binding.imageView.visibility = View.VISIBLE
                binding.welcomeMain.visibility = View.VISIBLE
                binding.linearOptions.visibility = View.VISIBLE
            }else{
                val providers = arrayListOf(AuthUI.IdpConfig.EmailBuilder().build(), AuthUI.IdpConfig.GoogleBuilder().build())
                resultLauncher.launch(
                    AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build())
            }
        }
    }

    override fun onResume() {
        super.onResume()
        firebaseAuth.addAuthStateListener(authStateListener)
    }

    override fun onPause() {
        super.onPause()
        firebaseAuth.removeAuthStateListener(authStateListener)
    }

    private fun aboutUs(){
        //Conocenos
        val btnConocenos : Button = findViewById(R.id.btnConocenos)
        btnConocenos.setOnClickListener {
            val intent = Intent(this, AboutUsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun signOut(){
        val logOutButton : Button = findViewById(R.id.logOutButton)
        logOutButton.setOnClickListener {
            AuthUI.getInstance().signOut(this)
                .addOnSuccessListener{
                    Toast.makeText(this, "Sesion Cerrada con Exito", Toast.LENGTH_LONG).show()
                }
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        binding.imageView.visibility = View.GONE
                        binding.linearOptions.visibility = View.GONE
                        binding.welcomeMain.visibility = View.GONE
                        binding.llProgress.visibility = View.GONE
                    }else{
                        Toast.makeText(this, "No se pude Cerrar la Sesion", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }

    private fun darMenu(){
        val btnMenu : Button = findViewById(R.id.btnMenu)
        btnMenu.setOnClickListener {
            val intent = Intent(this,MenuActivity::class.java)
            startActivity(intent)
        }
    }

    private fun ourServices(){
        val btnOurServices : Button = findViewById(R.id.btnOurServices)
        btnOurServices.setOnClickListener {
            val intent = Intent(this,OurServices::class.java)
            startActivity(intent)
        }
    }

    private fun dessertMenu(){
        val btnDessert : Button = findViewById(R.id.btnDessert)
        btnDessert.setOnClickListener {
            val intent = Intent(this,DessertActivity::class.java)
            startActivity(intent)
        }
    }

    private fun publicMenu(){
        val btnPublicar : Button = findViewById(R.id.btnPublicar)
        btnPublicar.setOnClickListener {
            val intent = Intent(this, PublicActivity::class.java)
            startActivity(intent)
        }
    }

    private fun publicAnto(){
        val btnPublicarAnto : Button = findViewById(R.id.btnPublicarAnto)
        btnPublicarAnto.setOnClickListener {
            val intent = Intent(this, PublicAntoActivity::class.java)
            startActivity(intent)
        }
    }
}