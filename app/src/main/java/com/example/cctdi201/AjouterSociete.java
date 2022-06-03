package com.example.cctdi201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AjouterSociete extends AppCompatActivity {
    EditText e1,e2,e3;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_societe);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        db=new MyDatabase(this);
    }

    public void annuler(View view) {
        finish();
    }

    public void enregistrer(View view) {
        Societe s = new Societe();

        s.setNom(e1.getText().toString());
        s.setSecteuractivite(e2.getText().toString());
        s.setNombreemploye(Integer.valueOf(e3.getText().toString()));

        if(MyDatabase.AddSociete(db.getWritableDatabase(),s)==-1)
            Toast.makeText(this, "erreur de l'insertion", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Insertion avec success", Toast.LENGTH_SHORT).show();
    }
}