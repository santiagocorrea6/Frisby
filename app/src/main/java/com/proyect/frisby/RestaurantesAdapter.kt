package com.proyect.frisby

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.elemento_lista.view.*

class RestaurantesAdapter (
    private val mContext: Context,
    private val listaRestaurantes: List<Restaurante>) : ArrayAdapter<Restaurante>(mContext,0,listaRestaurantes){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.elemento_lista, parent, false)

        val restaurante = listaRestaurantes[position]

        layout.tv_titulo.text = restaurante.nombre
        layout.tv_direccion.text = restaurante.direccion
        layout.rb_rating.rating = restaurante.rate
        layout.rb_rating.numStars = 5

        return layout
    }
}