package com.example.cctdi201;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void affichage(View view) {
        Intent i=null;
        switch (view.getId()){
            case R.id.btn1:i=new Intent(MainActivity.this,AjouterSociete.class);break;
            case R.id.btn2:i=new Intent(MainActivity.this,ModifierSociete.class);break;
            case R.id.btn3:i=new Intent(MainActivity.this,ListeActivite.class);break;

        }
        startActivity(i);
    }
}