package com.example.ejemplociudades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.ejemplociudades.clases.Ciudad;
import com.example.ejemplociudades.clases.ListaCiudadesAdapter;
import com.example.ejemplociudades.controladores.CiudadesController;

import java.util.ArrayList;


public class MostrarCiudadesActivity extends AppCompatActivity {
    RecyclerView rv_ciudades = null;
    ArrayList<Ciudad> ciudades = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_ciudades);
        rv_ciudades =  (RecyclerView) findViewById(R.id.rv_ciudades);
        ciudades = CiudadesController.obtenerCiudades();
        ListaCiudadesAdapter mAdapter = new ListaCiudadesAdapter(this, ciudades);
        // Connect the adapter with the RecyclerView.
        rv_ciudades.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        rv_ciudades.setLayoutManager(new LinearLayoutManager(this));
    }
}