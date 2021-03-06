package com.proyect.frisby

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PointOfInterest

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnPoiClickListener {

    private lateinit var mMap: GoogleMap //instancia clase google maps
    var frisby = LatLng(40.1300366,-8.2050543)
    var restaurantes = 0
    var name : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val restaurante = intent.getSerializableExtra("restaurante") as Restaurante
        name = restaurante.nombre

        seleccionarDireccion(restaurante)
    }

    override fun onMapReady(googleMap: GoogleMap) {  //recibe el mapa que me manda google

        activarMyLocation()

        mMap = googleMap //se lo asignamos al componente que habiamos creado

        mMap.mapType = GoogleMap.MAP_TYPE_NORMAL //tipo de mapa

        mMap.uiSettings.isZoomControlsEnabled = true //Coloca el + y - del zoom

        //mMap.setOnPoiClickListener(this)

        if(restaurantes == 0) {
            mMap.addMarker(MarkerOptions().position(frisby).title("$name"))
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(frisby, 15F))
            mMap.addMarker(MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)).position(frisby))

        } else {
            val frisbyFlorida = LatLng(6.270746896948369, -75.57714320719242)
            mMap.addMarker(MarkerOptions().position(frisbyFlorida).title("Frisby C.C. Florida"))
            mMap.addMarker(MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)).position(frisbyFlorida))


            val frisbyManrique = LatLng(6.26529456928309, -75.55525168776512)
            mMap.addMarker(MarkerOptions().position(frisbyManrique).title("Frisby Manrique"))
            mMap.addMarker(MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)).position(frisbyManrique))

            val frisbyExitoColombia = LatLng(6.255444241742275, -75.58261826634407)
            mMap.addMarker(MarkerOptions().position(frisbyExitoColombia).title("Frisby Exito - Colombia"))
            mMap.addMarker(MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)).position(frisbyExitoColombia))


            val frisbyJumbo65 = LatLng(6.251924794266287, -75.58538496494293)
            mMap.addMarker(MarkerOptions().position(frisbyJumbo65).title("Frisby Jumbo de la 65"))
            mMap.addMarker(MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)).position(frisbyJumbo65))

            val frisbySanDiego = LatLng(6.235599714287427, -75.56909792125226)
            mMap.addMarker(MarkerOptions().position(frisbySanDiego).title("Frisby San Diego"))
            mMap.addMarker(MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)).position(frisbySanDiego))

            val frisbyAventura = LatLng(6.264100781869583, -75.5673699080944)
            mMap.addMarker(MarkerOptions().position(frisbyAventura).title("Frisby C.C. Aventura"))
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(frisbyAventura,13F))
            mMap.addMarker(MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)).position(frisbyAventura))
        }



    }

    private fun activarMyLocation() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        mMap.isMyLocationEnabled = true
    }

    override fun onPoiClick(poi: PointOfInterest?) {

        //Toast.makeText(this,"Nombre: ${poi?.name},  Latitud : ${poi?.latLng?.latitude}, Longitud : ${poi?.latLng?.longitude}\"" ,Toast.LENGTH_SHORT).show()

    }

    private fun seleccionarDireccion(restaurante: Restaurante) {
        when (restaurante.id) {
            1 -> frisby = LatLng(6.270746896948369, -75.57714320719242)
            2 -> frisby = LatLng(6.26529456928309, -75.55525168776512)
            3 -> frisby = LatLng(6.255444241742275, -75.58261826634407)
            4 -> frisby = LatLng(6.251924794266287, -75.58538496494293)
            5 -> frisby = LatLng(6.235599714287427, -75.56909792125226)
            6 -> frisby = LatLng(6.264100781869583, -75.5673699080944)
            0 -> restaurantes = 1
            else -> frisby = LatLng(6.268844, -75.6664331)
        }
    }
}