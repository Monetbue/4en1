package com.example.dami_practica5_intent1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Practica2 extends AppCompatActivity {
    Button back;
    ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica2);
        back=(Button) findViewById(R.id.comeback2);

        imageView= (ImageView)findViewById(R.id.iv_activity_main);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Practica2.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    float x,y;
    float dx,dy;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            x= event.getX();
            y= event.getY();
        }

        if (event.getAction()== MotionEvent.ACTION_MOVE){
            dx = event.getX() - x;
            dy = event.getY() - y;

            imageView.setX(imageView.getX()+dx);
            imageView.setY(imageView.getY()+dy);

            x= event.getX();
            y= event.getY();
        }
        return super.onTouchEvent(event);
    }

}