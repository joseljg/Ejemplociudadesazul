package com.example.ejemplociudades;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejemplociudades.clases.Provincia;
import com.example.ejemplociudades.controladores.ProvinciaController;


public class NuevaProvinciaActivity extends AppCompatActivity {

    private EditText edt_nombrep = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_provincia);
        edt_nombrep = (EditText) findViewById(R.id.edt_nombrep);
    }

    public void insertarProvincia(View view) {
        // recuperar los datos del formulario
        String nombrep = String.valueOf(edt_nombrep.getText());
        if(nombrep.isEmpty())
        {
            edt_nombrep.setError("debes introducir el nombre de la provincia");
        }
        else{
            AlertDialog.Builder alertaconfirmacion = new AlertDialog.Builder(this);
            alertaconfirmacion.setTitle("de verdad quieres crear la provincia?");
            alertaconfirmacion.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Provincia p = new Provincia(nombrep);
                    boolean insercionOK = ProvinciaController.insertarProvincia(p);
                    if(insercionOK)
                    {
                        mostrarToast("insercion correcta");
                    }
                    else
                    {
                        mostrarToast("insercion erronea");
                    }
                }
            });
            alertaconfirmacion.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // mensaje de cancelacion
                    mostrarToast(" ha cancelado la operacion de insercion");
                }
            });
            alertaconfirmacion.show(); // mostrar la alerta
        }

        // guardar la información en la base de datos
    }

    private void mostrarToast(String s) {
        Toast.makeText(this,s, Toast.LENGTH_SHORT ).show();
    }
}