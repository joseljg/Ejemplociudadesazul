package com.example.ejemplociudades;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ejemplociudades.clases.Provincia;
import com.example.ejemplociudades.controladores.ProvinciaController;

import java.util.ArrayList;

public class BorrarProvinciaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner sp_provincias = null;
    ArrayList<Provincia> provincias = null;
    ArrayAdapter<Provincia> adapter = null;
    Provincia pseleccionada = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_provincia);
        sp_provincias = (Spinner) findViewById(R.id.sp_provincias);
        provincias = ProvinciaController.obtenerProvincias();
        //------------------------------------------------------------------
 //       provincias = new ArrayList<Provincia>();
 //       provincias.add(new Provincia("Toledo"));
 //       provincias.add(new Provincia("Ciudad Real"));

        for(Provincia p: provincias)
        {
            System.out.println(p.toString());
            Log.i("provincias", p.toString());
        }
        //----------------------------------------------------------------
        sp_provincias.setOnItemSelectedListener(this);
        //----------------------------------------------------------------
        adapter = new ArrayAdapter<Provincia>(this,R.layout.support_simple_spinner_dropdown_item, provincias);
        sp_provincias.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
           pseleccionada = (Provincia) sp_provincias.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void borrarLaProvincia(View view) {
        if(pseleccionada == null)
        {
            Toast.makeText(this, "debes seleccionar una provincia para borrarla", Toast.LENGTH_SHORT).show();
            return;
        }
        AlertDialog.Builder alertaBorrar = new AlertDialog.Builder(this);
        alertaBorrar.setTitle("de verdad quieres borrar la provincia?");
        alertaBorrar.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                boolean borradoOK = ProvinciaController.borrarProvincia(pseleccionada);
                if(borradoOK)
                {
                    mostrarToast("el borrado se hizo correctamente");
                    adapter.remove(pseleccionada);
                   //  finish();
                   //  startActivity(getIntent());
                    //----------------------------------------------------
                   // adapter.clear();
                    // provincias = ProvinciaController.obtenerProvincias();
                   //  adapter.addAll(provincias);
                    //----------------------------------------------------
                }
                else{
                    mostrarToast("el borrado no se hizo correctamente");
                }
            }
        });
        alertaBorrar.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertaBorrar.show();
    }

    private void mostrarToast(String texto) {
        Toast.makeText(this,texto, Toast.LENGTH_SHORT);
    }
}