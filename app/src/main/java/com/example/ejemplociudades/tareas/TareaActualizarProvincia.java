package com.example.ejemplociudades.tareas;

import com.example.ejemplociudades.clases.Provincia;
import com.example.ejemplociudades.modelos.ProvinciaDB;

import java.util.concurrent.Callable;

public class TareaActualizarProvincia implements Callable<Boolean> {

    private Provincia p;
    public TareaActualizarProvincia(Provincia p) {
        this.p = p;
    }

    @Override
    public Boolean call() throws Exception {
        boolean actualizarOK = ProvinciaDB.actualizarProvinciaTabla(this.p);
        return actualizarOK;
    }
}
