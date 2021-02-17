package com.example.ejemplociudades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ejemplociudades.clases.Provincia;
import com.example.ejemplociudades.controladores.ProvinciaController;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class ActualizarProvinciaActivity1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String EXTRA_OBJETO_PROVINCIA = "com.example.ejemplociudades.objetoprovincia";
    public static final String EXTRA_IMAGEN_PROVINCIA ="com.example.ejemplociudades.fotoprovincia" ;
    public static final String EXTRA_NOMBRE_PROVINCIA = "com.example.ejemplociudades.nombreprovincia";
    public static final String EXTRA_ID_PROVINCIA = "com.example.ejemplociudades.idprovincia";
    Spinner sp_actualizarp = null;
    ArrayList<Provincia> provincias = null;
    public static ArrayAdapter<Provincia> adapter = null;
    Provincia pseleccionada = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_provincia1);
        sp_actualizarp = (Spinner) findViewById(R.id.sp_actualizarp);
        //------------------------------------------------------------
        provincias = ProvinciaController.obtenerProvincias();
        sp_actualizarp.setOnItemSelectedListener(this);
        //------------------------------------------------------------
        if(provincias != null) {
            adapter = new ArrayAdapter<Provincia>(this, R.layout.support_simple_spinner_dropdown_item, provincias);
            sp_actualizarp.setAdapter(adapter);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(provincias != null) {
            pseleccionada = (Provincia) sp_actualizarp.getItemAtPosition(position);
            // Toast.makeText(this, "has elegido la provincia " + pseleccionada.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void enviarProvinciaActualizar2(View view) {
        if(pseleccionada == null)
        {
            Toast.makeText(this, "debes seleccionar una provincia ", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            //--------------------------------------------------
                  Intent intent = new Intent(this, ActualizarProvinciaActivity2.class);

                  Bitmap fotobm = pseleccionada.getFoto();
                  if(fotobm != null)
                  {
                     ByteArrayOutputStream stream = new ByteArrayOutputStream();
                     fotobm.compress(Bitmap.CompressFormat.PNG, 100, stream);
                     byte[] byteArray = stream.toByteArray();
                     intent.putExtra(EXTRA_IMAGEN_PROVINCIA, byteArray);
                  }
            intent.putExtra(EXTRA_NOMBRE_PROVINCIA, pseleccionada.getNombre());
            intent.putExtra(EXTRA_ID_PROVINCIA, pseleccionada.getIdprovincia());
            startActivity(intent);
        }
    }
}