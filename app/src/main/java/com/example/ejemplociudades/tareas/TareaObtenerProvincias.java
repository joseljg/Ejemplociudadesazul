package com.example.ejemplociudades.tareas;

import com.example.ejemplociudades.clases.Provincia;
import com.example.ejemplociudades.modelos.ProvinciaDB;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class TareaObtenerProvincias implements Callable<ArrayList<Provincia>> {

    @Override
    public ArrayList<Provincia> call() throws Exception {
        ArrayList<Provincia> provincias= ProvinciaDB.obtenerProvincias();
        return provincias;
    }
}
