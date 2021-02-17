package com.example.ejemplociudades.clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejemplociudades.R;

import java.util.ArrayList;

public class ListaCiudadesAdapter extends RecyclerView.Adapter<CiudadViewHolder> {
    // atributos
    private LayoutInflater mInflater;
    private ArrayList<Ciudad> listaCiudades;
    private Context c;

    public ArrayList<Ciudad> getListaCiudades() {
        return listaCiudades;
    }

    public Context getC() {
        return c;
    }

    public void setC(Context c) {
        this.c = c;
    }

    public void setListaCiudades(ArrayList<Ciudad> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }

    public ListaCiudadesAdapter(Context c, ArrayList<Ciudad> listaCiudades) {
        this.listaCiudades = listaCiudades;
        this.c = c;
        mInflater = LayoutInflater.from(c);
    }

    @NonNull
    @Override
    public CiudadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.item_rv_ciudades, parent, false);
        return new CiudadViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull CiudadViewHolder holder, int position) {
        Ciudad ciudadActual = listaCiudades.get(position);
        holder.edt_rv_nombrec.setText("Ciudad: " + ciudadActual.getNombre());
        holder.edt_rv_habitantes.setText(String.valueOf("habitantes: " + ciudadActual.getHabitantes()));
        holder.edt_rv_provincia.setText(String.valueOf("idprovincia: " + ciudadActual.getIdprovincia()));
    }

    @Override
    public int getItemCount() {
        return listaCiudades.size();
    }
}
