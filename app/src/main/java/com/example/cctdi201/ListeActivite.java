package com.example.cctdi201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ListeActivite extends AppCompatActivity {
    ListView lst;
    MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_activite);
        lst=findViewById(R.id.ls);
        db=new MyDatabase(this);
        ArrayList<Societe> s =MyDatabase.getAllSociete(db.getReadableDatabase());
        ArrayList<HashMap<String,Object>> h = new ArrayList<>();
        for(Societe so : s){
            HashMap<String,Object> has =new HashMap<>();
            has.put("nom",so.getNom());
            has.put("nb",so.getNombreemploye());
            h.add(has);
        }
        String[] from = {"nom","nb"};
        int [] to ={R.id.trai,R.id.tcap};
        SimpleAdapter sa = new SimpleAdapter(this,h,R.layout.societes,from,to);
        lst.setAdapter(sa);
    }
}