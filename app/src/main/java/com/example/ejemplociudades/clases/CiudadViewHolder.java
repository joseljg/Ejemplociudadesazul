package com.example.ejemplociudades.clases;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejemplociudades.R;

public class CiudadViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

    // atributos
    public TextView edt_rv_nombrec;
    public TextView edt_rv_habitantes;
    public TextView edt_rv_provincia;
    public  ListaCiudadesAdapter lcAdapter;

    public CiudadViewHolder(@NonNull View itemView,  ListaCiudadesAdapter mAdapter) {
        super(itemView);
        edt_rv_nombrec = itemView.findViewById(R.id.txt_nombrec);
        edt_rv_habitantes = itemView.findViewById(R.id.txt_habitantesc);
        edt_rv_provincia = itemView.findViewById(R.id.txt_provinciac);
        this.lcAdapter = mAdapter;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Log.i("ciudades" , "al hacer click muestro la casilla");
        int posicion = getLayoutPosition();
        Ciudad c = this.lcAdapter.getListaCiudades().get(posicion);
       // Intent intent = new Intent(this.lcAdapter.getC(),)
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}
