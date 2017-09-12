package com.example.edutools.ejemplo_app_login;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.snowdream.android.widget.SmartImageView;

public class Main2Activity extends AppCompatActivity {
    SmartImageView si1,si2;
    String url = "http://www.programadoresperuanos.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        si1 = (SmartImageView) findViewById(R.id.imagensmart1);
        si2 = (SmartImageView) findViewById(R.id.imagensmart2);
        Rect rectangulo = new Rect(si1.getLeft(),si1.getTop(),si1.getRight(),si1.getBottom());
        Rect rectangulo2 = new Rect(si2.getLeft(),si2.getTop(),si2.getRight(),si2.getBottom());
        si1.setImageUrl(url+"imagenes/imagen1.jpg",rectangulo);
        si2.setImageUrl(url+"imagenes/imagen2.jpg",rectangulo2);
    }
}
