package com.example.dami_practica5_intent1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_practica3 extends AppCompatActivity {
    Button back;

    EditText editTextNumber;
    EditText editTextTextMultiline;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica3);
        back=(Button) findViewById(R.id.comeback3);
        editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        editTextTextMultiline= (EditText) findViewById(R.id.editTextTextMultiLine);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_practica3.this,MainActivity.class);
                startActivity(intent);
            }

        });
    }
    public void calcular(View view){
        String cad = "";
        if (editTextNumber.getText().toString().equals("")){
            Toast.makeText(this, "Ingrese un numero", Toast.LENGTH_LONG).show();
        }
        else {
            int numero = Integer.parseInt(editTextNumber.getText().toString());
            for (int i=1; i <=10 ; i++){
                cad += String.valueOf(numero) + "\t x \t" + i + "\t = \t" + (numero * i) + "\n";
            }
            editTextTextMultiline.setText(cad);
        }
    }
}