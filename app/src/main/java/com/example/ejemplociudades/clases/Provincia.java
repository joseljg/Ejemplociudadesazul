package com.example.ejemplociudades.clases;

import android.graphics.Bitmap;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.Objects;

public class Provincia implements Serializable {

    private int idprovincia ;
    private String nombre;
    private Bitmap foto;

    public Provincia(int idprovincia, String nombre, Bitmap foto) {
        this.idprovincia = idprovincia;
        this.nombre = nombre;
        this.foto = foto;
    }
    public Provincia(int idprovincia, String nombre) {
        this.idprovincia = idprovincia;
        this.nombre = nombre;
        this.foto = null;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    public Provincia(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provincia provincia = (Provincia) o;
        return idprovincia == provincia.idprovincia;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(idprovincia);
    }

    public int getIdprovincia() {
        return idprovincia;
    }

    public void setIdprovincia(int idprovincia) {
        this.idprovincia = idprovincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
   /*     return "Provincia{" +
                "idprovincia=" + idprovincia +
                ", nombre='" + nombre + '\'' +
                '}';
     */
    return nombre;
    }
}
