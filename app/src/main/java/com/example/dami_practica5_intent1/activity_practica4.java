package com.example.dami_practica5_intent1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activity_practica4 extends AppCompatActivity {
    Button back;

    private EditText etp;
    private EditText eti;
    private EditText etm;
    private EditText eth;
    private EditText etd;
    private TextView tvresul;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica4);
        back=(Button) findViewById(R.id.comeback4);
        etp=(EditText)findViewById(R.id.txt_programacion);
        eti=(EditText)findViewById(R.id.txt_ingles);
        etm=(EditText)findViewById(R.id.txt_matematicas);
        eth=(EditText)findViewById(R.id.txt_historia);
        etd=(EditText)findViewById(R.id.txt_deporte);
        tvresul=(TextView)findViewById(R.id.tv_resultado);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_practica4.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void calcular (View view) {
        String Programacion_String = etp.getText().toString();
        String Ingles_String = eti.getText().toString();
        String Matematicas_String = etm.getText().toString();
        String Historia_String = eth.getText().toString();
        String Deporte_String = etd.getText().toString();
        int Programacion_int= Integer.parseInt(Programacion_String);
        int Ingles_int= Integer.parseInt(Ingles_String);
        int Matematicas_int= Integer.parseInt(Matematicas_String);
        int Historia_int= Integer.parseInt(Historia_String);
        int Deporte_int= Integer.parseInt(Deporte_String);
        int promedio = (Programacion_int + Ingles_int+ Matematicas_int+ Historia_int+ Deporte_int)/5;

        if (promedio >= 90){
            tvresul.setText("Eres un buen alumno: " + promedio);
        }else if (promedio  >= 80) {
            tvresul.setText("vas bien pero debes mejorar: " + promedio);
        }else if (promedio >=70){
            tvresul.setText("estas aprobando de panzazo: " + promedio);
        }else if (promedio < 70){
            tvresul.setText("Valiste....: " + promedio);
        }


    }
}