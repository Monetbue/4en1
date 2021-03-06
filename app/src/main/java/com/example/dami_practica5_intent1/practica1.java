package com.example.dami_practica5_intent1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class practica1 extends AppCompatActivity {
   Button back;
   Button verificar;
   AlertDialog.Builder dialogo;
   EditText Anio;
   TextView respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica1);
        back=(Button) findViewById(R.id.comeback);
        Anio = (EditText) findViewById(R.id.edtxtAnio);
        verificar = (Button) findViewById(R.id.btnVerificar);
        respuesta = (TextView) findViewById(R.id.resultado);


        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificar.getText().toString().equals("Limpiar")){
                    Anio.setText("");
                    respuesta.setText("");
                    Anio.setEnabled(true);
                    Anio.requestFocus();
                    verificar.setText("Verificar");
                }else{
                    if(Anio.getText().length() == 0){
                        dialogo = new AlertDialog.Builder(practica1.this);
                        dialogo.setTitle("Error");
                        dialogo.setMessage("Debe ingresar el cociente 'año'");
                        dialogo.setCancelable(false);
                        dialogo.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogo, int id) {
                                dialogo.cancel();
                                Anio.setText("");
                                Anio.requestFocus();
                            }
                        });
                        dialogo.show();
                    }else{
                        int anio = Integer.parseInt(Anio.getText().toString());
                        if(anio % 4 == 0  &&  (anio % 100 != 0  ||  anio % 400 == 0)){
                            respuesta.setText("El año " + Anio.getText() + " es bisiesto");
                        }else{
                            respuesta.setText("El año " + Anio.getText() + " no es bisiesto");
                        }
                    }
                    Anio.setEnabled(false);
                    verificar.setText("Limpiar");
                }
            }
        });



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(practica1.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}