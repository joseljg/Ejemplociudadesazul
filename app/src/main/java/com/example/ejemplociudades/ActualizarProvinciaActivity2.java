package com.example.ejemplociudades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejemplociudades.clases.Provincia;
import com.example.ejemplociudades.controladores.ProvinciaController;

public class ActualizarProvinciaActivity2 extends AppCompatActivity {

    EditText edt_actualizarp_id = null;
    EditText edt_actualizarp_nombre = null;
    Provincia pseleccionada = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_provincia2);
        Intent intent = getIntent();
        pseleccionada = (Provincia) intent.getSerializableExtra(ActualizarProvinciaActivity1.EXTRA_OBJETO_PROVINCIA);
        edt_actualizarp_id = (EditText) findViewById(R.id.edt_actualizarp_id);
        edt_actualizarp_nombre = (EditText) findViewById(R.id.edt_actualizarp_nombre);
        edt_actualizarp_id.setText(String.valueOf(pseleccionada.getIdprovincia()));
        edt_actualizarp_nombre.setText(pseleccionada.getNombre());
        edt_actualizarp_id.setEnabled(false);
    }

    public void actualizarDatosProvincia(View view) {
        int id = Integer.valueOf(String.valueOf(edt_actualizarp_id.getText()));
        String nombre = String.valueOf(edt_actualizarp_nombre.getText());
        Provincia p = new Provincia(id, nombre);
        boolean actualizadoOK = ProvinciaController.actualizarProvincia(p);
        if(actualizadoOK)
        {
            ActualizarProvinciaActivity1.adapter.remove(pseleccionada);
            ActualizarProvinciaActivity1.adapter.add(p);
            Toast.makeText(this, "actualizado correctamente", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "No se ha actualizado correctamente", Toast.LENGTH_SHORT).show();
        }
    }
}