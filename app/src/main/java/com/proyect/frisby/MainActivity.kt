package com.proyect.frisby

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val restaurante = Restaurante(1,"Frisby C.C. Florida", "Cra. 71 N° 65-150 Local 99347", 5F)
        val restaurante2 = Restaurante(2,"Frisby Manrique", "Cra. 45 N° 70-10", 4.1F)
        val restaurante3 = Restaurante(3, "Frisby Exito - Colombia", "Cra. 66 N° 49-43", 4.0F)
        val restaurante4 = Restaurante(4, "Frisby Jumbo de la 65", "Calle 47D, Naranjal", 4.0F)
        val restaurante5 = Restaurante(5, "Frisby San Diego", "Cl. 34 N° 43-66 Local 2311", 5F)
        val restaurante6 = Restaurante(6, "Frisby C.C. Aventura", "Cra 52 N° 65-40", 4.5F)
        val restaurante7 = Restaurante(0, "MAS CERCANOS", "Medellin - Antioquia", 4.0F)


        val listaRestaurante = listOf(restaurante,restaurante2,restaurante3,restaurante4,restaurante5,restaurante6, restaurante7)

        val adapter = RestaurantesAdapter(this, listaRestaurante)

        lv_restaurantes.adapter = adapter

        lv_restaurantes.setOnItemClickListener{parent, view, position, id ->
            val intent = Intent(this, MapsActivity::class.java)
            intent.putExtra("restaurante", listaRestaurante[position])
            startActivity(intent)
        }
    }
}