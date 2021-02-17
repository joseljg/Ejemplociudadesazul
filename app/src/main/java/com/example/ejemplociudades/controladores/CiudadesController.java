package com.example.ejemplociudades.controladores;

import com.example.ejemplociudades.clases.Ciudad;
import com.example.ejemplociudades.clases.Provincia;
import com.example.ejemplociudades.tareas.TareaObtenerCiudades;
import com.example.ejemplociudades.tareas.TareaObtenerProvincias;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CiudadesController {
    public static ArrayList<Ciudad> obtenerCiudades() {
        ArrayList<Ciudad> ciudadesDevueltas = null;
        FutureTask t = new FutureTask (new TareaObtenerCiudades());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            ciudadesDevueltas= (ArrayList<Ciudad>)t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(2000, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ciudadesDevueltas;
    }
}
