package com.example.ejemplociudades.tareas;

import com.example.ejemplociudades.clases.Provincia;
import com.example.ejemplociudades.modelos.ProvinciaDB;

import java.util.concurrent.Callable;

public class TareaBorrarProvincia implements Callable<Boolean> {
private Provincia p = null;

public TareaBorrarProvincia(Provincia p) {
        this.p = p;
        }

@Override
public Boolean call() throws Exception {
        boolean borradoOK = ProvinciaDB.borrarProvinciaTabla(p);
        return borradoOK;
        }
}