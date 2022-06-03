package com.example.cctdi201;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ModifierSociete extends AppCompatActivity {
    ArrayList<Societe> soc;
    ArrayAdapter ad;
    EditText e1,e2,e3;
    MyDatabase db;
    Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_societe);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        sp=findViewById(R.id.sp);
        soc= MyDatabase.getAllSociete(db.getReadableDatabase());
        db=new MyDatabase(this);
        ArrayList<Societe> as =MyDatabase.getAllSociete(db.getReadableDatabase());
        ArrayList<String> s =new ArrayList<>();
        for(Societe ss : as){
            s.add(ss.getId()+"-"+ss.getNom());
        }
        ad = new ArrayAdapter(this,R.layout.activity_modifier_societe,s);
        sp.setAdapter(ad);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Societe s = soc.get(i);
                e1.setText(s.getNom());
                e2.setText(s.getSecteuractivite());
                e3.setText(Integer.valueOf(s.getNombreemploye()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void modifier(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(ModifierSociete.this);
        alert.setTitle("Modifier Societe");
        alert.setMessage("Voulez-vous modifier cette societe ?");
        alert.setPositiveButton("oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Societe s = soc.get(sp.getSelectedItemPosition());

                s.setNom(e1.getText().toString());
                s.setSecteuractivite(e2.getText().toString());
                s.setNombreemploye(Integer.valueOf(e3.getText().toString()));

                if(MyDatabase.UpdateSociete(db.getWritableDatabase(),s)==-1)
                    Toast.makeText(ModifierSociete.this, "Erreur de modification", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(ModifierSociete.this, "Modification aves siccess", Toast.LENGTH_SHORT).show();
            }
        });
        alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(ModifierSociete.this, "Annulation", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();

    }

    public void supprimer(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(ModifierSociete.this);
        alert.setTitle("Suppression d'une societe");
        alert.setMessage("Voulez-vous supprimer cette societe ?");

        alert.setPositiveButton("oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Societe s = soc.get(sp.getSelectedItemPosition());

                if(MyDatabase.DeleteSociete(db.getWritableDatabase(),s.getId())==-1)
                    Toast.makeText(ModifierSociete.this, "Erreur de suppression", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(ModifierSociete.this, "Suppression avec success", Toast.LENGTH_SHORT).show();
                    ad.remove(s.getId() + " - " + s.getNom());
                }
            }
        });

        alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(ModifierSociete.this, "Annulation", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }
}